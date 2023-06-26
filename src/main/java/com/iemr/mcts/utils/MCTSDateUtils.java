package com.iemr.mcts.utils;

import java.sql.Date;
import java.util.Map;

import com.iemr.mcts.data.supervisor.MctsOutboundCall;

public interface MCTSDateUtils {

	public Map<String, MctsOutboundCall> getCallTypesDates(Date lmpDate, Date eddDate, Long providerServiceMapID);
	public Map<String, MctsOutboundCall> getChildCallTypesDates(Date birthDate, Long providerServiceMapID);
}
