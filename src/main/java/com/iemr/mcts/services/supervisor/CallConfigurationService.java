package com.iemr.mcts.services.supervisor;

import java.util.List;

import com.iemr.mcts.data.supervisor.CallConfigurationDetail;
import com.iemr.mcts.data.supervisor.CallNumbersConfigDetail;
import com.iemr.mcts.utils.exception.IEMRException;

public interface CallConfigurationService {

	List<CallConfigurationDetail> createConfigurations(List<CallConfigurationDetail> callConfigurationDetailList);

	List<CallConfigurationDetail> createCallNumberConfigurations(CallNumbersConfigDetail callNumbersConfigDetail);

	List<CallConfigurationDetail> updateConfigurations(List<CallConfigurationDetail> callConfigurationDetailList);

	String getOutBoundCallTypes(String request) throws IEMRException;

	String getCallConfigurationList(String request) throws IEMRException;

	String updateCallConfigurations(String request) throws IEMRException;

	String deleteConfiguration(String request) throws IEMRException;
	
	String getCallConfigurationListForReport(String request) throws IEMRException;

}
