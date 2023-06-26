package com.iemr.mcts.services.supervisor;

import com.iemr.mcts.utils.exception.IEMRException;

public interface MctsQAMappingService {

	/**
	 * Function to set questions with respect to outbound calls
	 * @param request
	 * @return
	 * @throws IEMRException 
	 */
	String createOutboundQuestions(String request) throws IEMRException;

	String getOutboundQuestionList(String request) throws Exception;

	String deleteQuestion(String request) throws IEMRException;

	String saveInteractions(String request) throws IEMRException;

	String updateInteraction(String request) throws IEMRException;

	String interactionsList(String request) throws IEMRException;

	String deleteInteraction(String request) throws IEMRException;
	
	String addDeriveQuestion(String request) throws IEMRException;
	
	String getAgentOutboundQuestionList(String request) throws Exception;
	
	String deleteMultipleQuestions(String request) throws Exception;

}
