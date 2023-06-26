package com.iemr.mcts.services.supervisor;

import com.iemr.mcts.utils.exception.IEMRException;

public interface MctsStatewiseFieldsService {

	/**
	 * this method is to get variables for questioner configuration 
	 * @param request
	 * @return
	 * @throws IEMRException 
	 * @throws com.iemr.mcts.utils.exception.IEMRException 
	 */
	String getVariables(String request) throws IEMRException;

}
