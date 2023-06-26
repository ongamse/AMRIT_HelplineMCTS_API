package com.iemr.mcts.data.utils;

import java.sql.Date;
import java.time.LocalDate;
import java.util.Iterator;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.iemr.mcts.data.supervisor.MctsOutboundCall;
import com.iemr.mcts.repository.agent.MCTSOutboundCallRepository;
import com.iemr.mcts.utils.MCTSDateUtils;

@Component
public class OutboundCallDatesUpdater {

	/**
	 * mcts outbound call repository
	 */
	private MCTSOutboundCallRepository mctsOutboundCallRepository;

	/**
	 * inject mcts outbound call repository
	 */
	@Autowired
	public void setMCTSOutboundCallsRepository(MCTSOutboundCallRepository mctsOutboundCallRepository) {

		this.mctsOutboundCallRepository = mctsOutboundCallRepository;
	}

	/**
	 * mcts utils
	 */
	private MCTSDateUtils mctsDateUtils;

	/**
	 * Inject mcts date utils
	 */
	@Autowired
	public void setMCTSDateUtils(MCTSDateUtils mctsDateUtils) {

		this.mctsDateUtils = mctsDateUtils;
	}

	public void updateOutboundCallDates(Date updatedDate, String outboundCallType, Boolean isMother, Long mctsID,
			Long providerServiceMapID) {

		if (isMother) {
			Map<String, MctsOutboundCall> callsDateMap = mctsDateUtils.getCallTypesDates(updatedDate,
					this.getEDD(updatedDate), providerServiceMapID);
			Iterator<Map.Entry<String, MctsOutboundCall>> itrator = callsDateMap.entrySet().iterator();
			while (itrator.hasNext()) {

				Map.Entry<String, MctsOutboundCall> entry = itrator.next();

				if (entry.getValue().getCallDateTo().toLocalDate().isAfter(LocalDate.now())) {
					mctsOutboundCallRepository.updateMotherOutboundCallDates(entry.getValue().getCallDateFrom(),
							entry.getValue().getCallDateTo(), entry.getKey(), mctsID);
				} else {

					mctsOutboundCallRepository.updateMotherOutboundCallDateAndStatus(entry.getValue().getCallDateFrom(),
							entry.getValue().getCallDateTo(), entry.getKey(), mctsID);
				}
			}
		} else {
			Map<String, MctsOutboundCall> childCallsDateMap = mctsDateUtils.getChildCallTypesDates(updatedDate,
					providerServiceMapID);
			Iterator<Map.Entry<String, MctsOutboundCall>> itrator = childCallsDateMap.entrySet().iterator();
			while (itrator.hasNext()) {
				Map.Entry<String, MctsOutboundCall> entry = itrator.next();

				if (entry.getValue().getCallDateTo().toLocalDate().isAfter(LocalDate.now())) {
					mctsOutboundCallRepository.updateChildOutboundCallDates(entry.getValue().getCallDateFrom(),
							entry.getValue().getCallDateTo(), entry.getKey(), mctsID);
				} else {

					mctsOutboundCallRepository.updateChildOutboundCallDateAndStatus(entry.getValue().getCallDateFrom(),
							entry.getValue().getCallDateTo(), entry.getKey(), mctsID);
				}
			}
		}
	}

	/**
	 * method for edd calc
	 */
	private Date getEDD(Date lmpDate) {

		LocalDate ld = lmpDate.toLocalDate();
		ld = ld.plusMonths(9);
		ld = ld.plusDays(7);
		return Date.valueOf(ld);
	}
}
