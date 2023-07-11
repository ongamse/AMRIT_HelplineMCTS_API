/*
* AMRIT – Accessible Medical Records via Integrated Technology
* Integrated EHR (Electronic Health Records) Solution
*
* Copyright (C) "Piramal Swasthya Management and Research Institute"
*
* This file is part of AMRIT.
*
* This program is free software: you can redistribute it and/or modify
* it under the terms of the GNU General Public License as published by
* the Free Software Foundation, either version 3 of the License, or
* (at your option) any later version.
*
* This program is distributed in the hope that it will be useful,
* but WITHOUT ANY WARRANTY; without even the implied warranty of
* MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
* GNU General Public License for more details.
*
* You should have received a copy of the GNU General Public License
* along with this program.  If not, see https://www.gnu.org/licenses/.
*/
package com.iemr.mcts.services.supervisor;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iemr.mcts.data.supervisor.CallConfigurationDetail;
import com.iemr.mcts.data.supervisor.CallNumbersConfigDetail;
import com.iemr.mcts.repository.supervisor.CallConfigurationRepository;
import com.iemr.mcts.utils.exception.IEMRException;
import com.iemr.mcts.utils.mapper.InputMapper;

@Service
public class CallConfigurationServiceImpl implements CallConfigurationService {

	
	private static InputMapper inputMapper = new InputMapper();
	
	/*
	 * (non-Javadoc)
	 * @see com.iemr.mcts.services.supervisor.CallConfigurationService#createConfigurations(java.util.List)
	 */
	@Override
	public List<CallConfigurationDetail> createConfigurations(List<CallConfigurationDetail> callConfigurationDetailList) {
		
		List<CallConfigurationDetail> callConfigurationDetails = new ArrayList<CallConfigurationDetail>();
		
		for(CallConfigurationDetail callConfigurationDetail : callConfigurationDetailList){
			
			CallConfigurationDetail callConfigurationDetail2 = callConfigurationRepository.save(callConfigurationDetail);
			callConfigurationDetails.add(callConfigurationDetail2);
		}
		
		return callConfigurationDetails;
	}
	
	/**
	 * Call configuration Repository declare
	 */
	private CallConfigurationRepository callConfigurationRepository;
	
	/**
	 *  inject Call configuration Repository
	 * @param callConfigurationRepository
	 */
	@Autowired
	public void setCallConfigurationRepository(CallConfigurationRepository callConfigurationRepository){
		
		this.callConfigurationRepository = callConfigurationRepository;
	}

	@Override
	public List<CallConfigurationDetail> createCallNumberConfigurations(
			CallNumbersConfigDetail callNumbersConfigDetail) {
		
		List<CallConfigurationDetail> callConfigurationDetails = new ArrayList<CallConfigurationDetail>();
		CallConfigurationDetail callConfigurationDetail;
		
		// to set ANC calls configuration
		
		for(int i=1;i<=callNumbersConfigDetail.getAnc();i++){
			
			callConfigurationDetail = new CallConfigurationDetail();
			callConfigurationDetail.setProviderServiceMapID(callNumbersConfigDetail.getProviderServiceMapID());
			callConfigurationDetail.setOutboundCallType("ANC"+i);
			callConfigurationDetail.setEffectiveFrom(callNumbersConfigDetail.getEffectiveFrom());
			callConfigurationDetail.setEffectiveUpto(callNumbersConfigDetail.getEffectiveUpto());
			callConfigurationDetail.setCreatedBy(callNumbersConfigDetail.getCreatedBy());
			callConfigurationDetails.add(callConfigurationDetail);
		}
		
		// to set PNC calls configuration
		
		for(int i=1;i<=callNumbersConfigDetail.getPnc();i++){
			
			callConfigurationDetail = new CallConfigurationDetail();
			callConfigurationDetail.setProviderServiceMapID(callNumbersConfigDetail.getProviderServiceMapID());
			callConfigurationDetail.setOutboundCallType("PNC"+i);
			callConfigurationDetail.setEffectiveFrom(callNumbersConfigDetail.getEffectiveFrom());
			callConfigurationDetail.setEffectiveUpto(callNumbersConfigDetail.getEffectiveUpto());
			callConfigurationDetail.setCreatedBy(callNumbersConfigDetail.getCreatedBy());
			callConfigurationDetails.add(callConfigurationDetail);
		}
		
		return this.createConfigurations(callConfigurationDetails);
	}

	@Override
	public List<CallConfigurationDetail> updateConfigurations(
			List<CallConfigurationDetail> callConfigurationDetails) {
		
		List<CallConfigurationDetail> callConfigurationList = new ArrayList<CallConfigurationDetail>();
		
		for(CallConfigurationDetail callConfigurationDetail: callConfigurationDetails){
			
			this.callConfigurationRepository.setConfigTerms(callConfigurationDetail.getFromTerm(), 
					callConfigurationDetail.getToTerm(), callConfigurationDetail.getMctsCallConfigID());
		}
		
		return callConfigurationList;
	}

	/*
	 * method to get outbound call type
	 * (non-Javadoc)
	 * @see com.iemr.mcts.services.supervisor.CallConfigurationService#getOutBoundCallTypes(java.lang.String)
	 */
	@Override
	public String getOutBoundCallTypes(String request) throws IEMRException {
		
		CallConfigurationDetail callConfigurationDetail = inputMapper.gson().fromJson(request, CallConfigurationDetail.class);
		return callConfigurationRepository.getConfigTerms(callConfigurationDetail.getProviderServiceMapID()).toString();
	}

	/*
	 * (non-Javadoc)
	 * @see com.iemr.mcts.services.supervisor.CallConfigurationService#getCallConfigurationList(java.lang.String)
	 */
	@Override
	public String getCallConfigurationList(String request) throws IEMRException {

		CallConfigurationDetail callConfigurationDetail = inputMapper.gson().fromJson(request, CallConfigurationDetail.class);
			List<CallConfigurationDetail> callConfigurationDetails = callConfigurationRepository
				.getConfigurations(callConfigurationDetail.getProviderServiceMapID());

		Map<Date, List<CallConfigurationDetail>> grupList =
				callConfigurationDetails.stream().collect(Collectors.groupingBy(w -> w.getEffectiveFrom()));
		
		TreeMap<Date, List<CallConfigurationDetail>> callConfigList = new TreeMap<Date, List<CallConfigurationDetail>>();
		callConfigList.putAll(grupList);
		return callConfigList.toString();
	}

	@Override
	public String updateCallConfigurations(String request) throws IEMRException {
		
		CallConfigurationDetail[] callConfigurationDetails = inputMapper.gson().fromJson(request, CallConfigurationDetail[].class);
		CallConfigurationDetail configDetail= callConfigurationDetails[0];
		
		List<CallConfigurationDetail> list =callConfigurationRepository.checkConfigurations(configDetail.getProviderServiceMapID(), configDetail.getEffectiveUpto(),
				configDetail.getCreatedDate());
		
		if(list.size()>0)
		{
			return "Please modify next configuration to update this change";
		}
		
		if(Date.valueOf(LocalDate.now()).before(configDetail.getEffectiveFrom()))
		{
			for(CallConfigurationDetail detail: callConfigurationDetails){
				
				callConfigurationRepository.updateConfigDisplayCallType(detail.getFromTerm(), detail.getToTerm(), 
						detail.getEffectiveFrom(), detail.getEffectiveUpto(), detail.getNoOfAttempts(), detail.getNextAttemptPeriod(),
						detail.getMctsCallConfigID(), detail.getDisplayOBCallType());
			}
			return "Call configuration updated successfully";
		}
		else {
		for(CallConfigurationDetail detail: callConfigurationDetails){
			
			callConfigurationRepository.updateConfiguration(detail.getFromTerm(), detail.getToTerm(), 
					detail.getEffectiveFrom(), detail.getEffectiveUpto(), detail.getNoOfAttempts(), detail.getNextAttemptPeriod(),
					detail.getMctsCallConfigID());
		}
		return "Call configuration updated successfully";
	  }
	}

	@Override
	public String deleteConfiguration(String request) throws IEMRException {
		
		CallConfigurationDetail[] callConfigurationDetails = inputMapper.gson().fromJson(request, CallConfigurationDetail[].class);
		for(CallConfigurationDetail detail: callConfigurationDetails){
			
			callConfigurationRepository.deleteConfiguration(detail.getMctsCallConfigID());
			callConfigurationRepository.deleteQuestionsList(detail.getProviderServiceMapID(), detail.getEffectiveFrom());
		}
		return "Call configuration deleted successfully";
	}
	
	@Override
	public String getCallConfigurationListForReport(String request) throws IEMRException {

		CallConfigurationDetail callConfigurationDetail = inputMapper.gson().fromJson(request, CallConfigurationDetail.class);
			List<CallConfigurationDetail> callConfigurationDetails = callConfigurationRepository
				.getConfigurationsForReport(callConfigurationDetail.getProviderServiceMapID(),callConfigurationDetail.getEndDate());

		Map<Date, List<CallConfigurationDetail>> grupList =
				callConfigurationDetails.stream().collect(Collectors.groupingBy(w -> w.getEffectiveFrom()));
		
		TreeMap<Date, List<CallConfigurationDetail>> callConfigList = new TreeMap<Date, List<CallConfigurationDetail>>();
		callConfigList.putAll(grupList);
		return callConfigList.toString();
	}
}
