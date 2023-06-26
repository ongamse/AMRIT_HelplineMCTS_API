package com.iemr.mcts.services.agent;

import javax.servlet.http.HttpServletRequest;

import com.iemr.mcts.utils.exception.IEMRException;

public interface MctsOutboundCallDetailService {

	/**
	 * this method saves the call history with comments
	 * @param request
	 * @return
	 * @throws IEMRException 
	 * @throws Exception 
	 */
	String saveCallClosure(String request) throws IEMRException, Exception;

	/**
	 * this method define to get previous history of the call
	 * @param request
	 * @return
	 * @throws IEMRException 
	 */
	String getCallHistory(String request) throws IEMRException;

	/**
	 * method to get beneficiary details for call history
	 * @param request
	 * @return
	 * @throws IEMRException 
	 */
	String getBeneficiaryDetails(String request,  HttpServletRequest servletRequest) throws IEMRException;

	/**
	 * method to save history when call is connected
	 * @param request
	 * @return
	 * @throws IEMRException 
	 */
	String createCallHistory(String request) throws IEMRException;

	/**
	 * api to send sms
	 * @param request
	 * @return
	 * @throws IEMRException 
	 */
	String sendSmsAdvice(String request) throws IEMRException;

	/**
	 * api to get sms
	 * @param request
	 * @return
	 * @throws IEMRException
	 */
	String getSmsAdvice(String request) throws IEMRException;

	String getChangeLog(String request) throws IEMRException;

	String caseSheet(String request, HttpServletRequest servletRequest) throws IEMRException;

	String getChangeLogs(String request) throws IEMRException;
}
