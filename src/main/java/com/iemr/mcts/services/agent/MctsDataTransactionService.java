package com.iemr.mcts.services.agent;

import java.lang.reflect.InvocationTargetException;

import javax.servlet.http.HttpServletRequest;

import com.iemr.mcts.utils.exception.IEMRException;

public interface MctsDataTransactionService {

	String updateData(String request, HttpServletRequest servletRequest) throws IEMRException, 
		IllegalAccessException, InvocationTargetException, NoSuchMethodException;

	/**
	 * To associate beneficiary with mcts data 
	 * @param request
	 * @return
	 * @throws IEMRException
	 */
	String associateBeneficiaryID(String request) throws IEMRException;

}
