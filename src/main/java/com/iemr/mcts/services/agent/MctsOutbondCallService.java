package com.iemr.mcts.services.agent;

import javax.servlet.http.HttpServletRequest;

import com.iemr.mcts.utils.exception.IEMRException;

public interface MctsOutbondCallService {

	/**
	 * this method is to get worklist of an agent
	 * @param request
	 * @return response
	 * @throws IEMRException 
	 */
	String getOutbondCalls(String request) throws IEMRException;
	
	/**
	 * this method is to allocate/re-allocate calls to agents
	 * @param request
	 * @return
	 * @throws IEMRException 
	 */
	String allocateCalls(String request) throws IEMRException;

	/**
	 * this method provide us the list of calls which needs to allocate
	 * @param request
	 * @return
	 * @throws IEMRException 
	 */
	String getUnallocatedCalls(String request) throws IEMRException;

	/**
	 * this method provide us the list of calls which needs to re-allocate
	 * @param request
	 * @return
	 * @throws IEMRException 
	 */
	String getReallocateCalls(String request) throws IEMRException;

	/**
	 * this method moves allocated call to bucket
	 * @param request
	 * @return message of call moving
	 * @throws IEMRException 
	 */
	String moveCallsToBucket(String request) throws IEMRException;

	/**
	 * api for getting next call date
	 * @param request
	 * @return String next call date
	 * @throws IEMRException 
	 */
	String getNextANC_PNC(String request) throws IEMRException;

	String getUpdatedObject(String request, HttpServletRequest servletRequest) throws IEMRException;

	String getHighRiskReason() throws IEMRException;

	String getMotherWorklist(String request) throws IEMRException;

	String getChildWorklist(String request) throws IEMRException;

}
