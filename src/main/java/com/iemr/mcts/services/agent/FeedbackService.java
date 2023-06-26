package com.iemr.mcts.services.agent;

import com.iemr.mcts.utils.exception.IEMRException;

public interface FeedbackService {

	/**
	 * function to get all complaints
	 * @param request
	 * @return
	 * @throws IEMRException
	 */
	String getFeedBackList(String request) throws IEMRException;

}
