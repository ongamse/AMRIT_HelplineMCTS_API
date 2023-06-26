package com.iemr.mcts.services.agent;

import com.iemr.mcts.utils.exception.IEMRException;

public interface MctsCallResponseService {

	/**
	 * Method defined to catch the mcts call response
	 * @param request
	 * @return message of created response
	 * @throws IEMRException 
	 */
	String saveMctsCallResponse(String request) throws IEMRException;

	/**
	 * Method to get the mcts call response
	 * @param request
	 * @return
	 * @throws IEMRException 
	 */
	String getMctsCallResponse(String request) throws IEMRException;

	/**
	 * Method to update response one by one
	 * @param request
	 * @return
	 * @throws IEMRException 
	 */
	String updateMctsCallResponse(String request) throws IEMRException;

}
