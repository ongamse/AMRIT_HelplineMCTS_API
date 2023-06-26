package com.iemr.mcts.services.agent;

import com.iemr.mcts.utils.exception.IEMRException;

public interface ChildCongenitalAnomaliesService {

	/**
	 * to get ca on child id
	 * @param request child id
	 * @return list child ca
	 * @throws IEMRException 
	 * @throws com.iemr.mcts.utils.exception.IEMRException 
	 */
	String getChildCongenitalAnomalies(String request) throws IEMRException;

}
