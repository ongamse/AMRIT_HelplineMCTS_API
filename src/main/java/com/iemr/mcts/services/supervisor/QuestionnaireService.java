package com.iemr.mcts.services.supervisor;

import com.iemr.mcts.utils.exception.IEMRException;

public interface QuestionnaireService {

	/**
	 * method to create questionnaire
	 * @param request
	 * @return
	 * @throws IEMRException
	 */
	String createQuestionnaire(String request) throws IEMRException;

	/**
	 * method defined to update questinnaire
	 * @param request
	 * @return update succcess message
	 * @throws IEMRException 
	 */
	String updateQuestionnaire(String request) throws IEMRException;

}
