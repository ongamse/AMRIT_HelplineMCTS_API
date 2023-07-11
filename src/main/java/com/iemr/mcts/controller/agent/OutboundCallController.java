/*
* AMRIT – Accessible Medical Records via Integrated Technology
* Integrated EHR (Electronic Health Records) Solution
*
* Copyright (C) "Piramal Swasthya Management and Research Institute"
*
* This file is part of AMRIT.
*
* This program is free software: you can redistribute it and/or modify
* it under the terms of the GNU General Public License as published by
* the Free Software Foundation, either version 3 of the License, or
* (at your option) any later version.
*
* This program is distributed in the hope that it will be useful,
* but WITHOUT ANY WARRANTY; without even the implied warranty of
* MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
* GNU General Public License for more details.
*
* You should have received a copy of the GNU General Public License
* along with this program.  If not, see https://www.gnu.org/licenses/.
*/
package com.iemr.mcts.controller.agent;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.iemr.mcts.services.agent.MctsOutbondCallService;
import com.iemr.mcts.services.agent.MctsOutboundCallDetailService;
import com.iemr.mcts.utils.response.OutputResponse;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@RequestMapping(value="/outbondcallcontroller")
public class OutboundCallController {

	private final Logger logger = LoggerFactory.getLogger(this.getClass().getName());
	/**
	 * Outbond call service 
	 */
	private MctsOutbondCallService mctsOutbondCallService;
	
	/**
	 * Inject outbond call service
	 */
	@Autowired
	public void setMctsOutbondCallService(MctsOutbondCallService mctsOutbondCallService){
		
		this.mctsOutbondCallService = mctsOutbondCallService;
	}
	
	/**
	 * outbound call service for history
	 */
	private MctsOutboundCallDetailService mctsOutboundCallDetailService;
	
	/**
	 * 
	 * Inject outbound call service for history
	 */
	@Autowired 
	public void setMctsOutboundCallDeatilService(MctsOutboundCallDetailService mctsOutboundCallDetailService){
		
		this.mctsOutboundCallDetailService = mctsOutboundCallDetailService;
	}
	
	/**
	 * The method return outbond call worklist
	 * @return list of all call worklist
	 */
/*	@CrossOrigin()
	@ApiOperation(value = "This API will get the worklist for the given userID")
	@ApiParam(value="", required=true)
	@RequestMapping(value="/get/worklist", method = RequestMethod.POST, headers = "Authorization")
	public String getWorkList(@ApiParam("{\"allocatedUserID\":\"Integer\"}")
			@RequestBody String request){
		
		OutputResponse response = new OutputResponse();
		
		try{
			
			response.setResponse(mctsOutbondCallService.getOutbondCalls(request));
		}catch (Exception e) {
		
			response.setError(e);
		}
		
		return response.toString();
	}
*/	
	/**
	 * api for auto allocation/ manual 
	 * @param request
	 * @return String count of allocated calls
	 */
	@CrossOrigin()
	@RequestMapping(value="/put/agentcallallocate", method = RequestMethod.POST, headers = "Authorization")
	public String agentCallAllocation(@ApiParam("{\"obCallID\":\"Integer\"}")
			@RequestBody String request){
	
		OutputResponse response  = new OutputResponse();
		try{
			
			response.setResponse(mctsOutbondCallService.allocateCalls(request));
		}catch (Exception e) {
			
			response.setError(e);
		}
		return response.toString(); 
	}
	
	/**
	 * api to get all unallocated calls
	 * @return
	 */
	@CrossOrigin()
	@RequestMapping(value="/get/unallocatedcalls", method = RequestMethod.POST, headers = "Authorization")
	public String getUnallocatedCalls(@ApiParam("{\"callDateFrom\":\"Date\", \"callDateTo\":\"Date\", \"providerServiceMapID\":\"Integer\"}")
			@RequestBody String request){
		
		OutputResponse response = new OutputResponse();
		
		try{
			
			response.setResponse(mctsOutbondCallService.getUnallocatedCalls(request));
		}catch (Exception e) {
            	response.setError(e);
			}

		return response.toString();
	}
	
	/**
	 * api to get all unallocated calls
	 * @return
	 */
	@CrossOrigin()
	@RequestMapping(value="/get/reallocated/calls", method = RequestMethod.POST, headers = "Authorization")
	public String getReallocateCalls(@ApiParam("{\"callDateFrom\":\"Date\", \"callDateTo\":\"Date\", \"userID\":\"Integer\"}")
			@RequestBody String request){
		
		OutputResponse response = new OutputResponse();

		try{
			
			response.setResponse(mctsOutbondCallService.getReallocateCalls(request));
		}catch (Exception e) {
            	response.setError(e);
			}

		return response.toString();
	}
	
	/**
	 * api to get all unallocated calls
	 * @return
	 */
	@CrossOrigin()
	@RequestMapping(value="/move/calls/tobucket", method = RequestMethod.POST, headers = "Authorization")
	public String moveToBucket(@ApiParam("{\"obCallID\":\"Integer\"}")
			@RequestBody String request){
		
		OutputResponse response = new OutputResponse();

		try{
			
			response.setResponse(mctsOutbondCallService.moveCallsToBucket(request));
		}catch (Exception e) {
            	response.setError(e);
			}

		return response.toString();
	}
	
	/**
	 * api call closure
	 * @param request
	 * @return String count of allocated calls
	 */
	@CrossOrigin()
	@RequestMapping(value="/put/call/closure", method = RequestMethod.POST, headers = "Authorization")
	public String putCallHistory(@RequestBody String request){
		logger.info("putCallHistory request "+request);
		OutputResponse response  = new OutputResponse();
		try{
			
			response.setResponse(mctsOutboundCallDetailService.saveCallClosure(request));
			logger.info("putCallHistory response "+response.toString());
		}catch (Exception e) {
			
			response.setError(e);
		}
		return response.toString(); 
	}
	
	/**
	 * api for reading call history
	 * @param request
	 * @return String count of allocated calls
	 */
	@CrossOrigin()
	@RequestMapping(value="/get/call/history", method = RequestMethod.POST, headers = "Authorization")
	public String getCallHistory(@ApiParam("{\"childID or motherID\":\"Integer\"}")
			@RequestBody String request){
		logger.info("getCallHistory request "+request);
		OutputResponse response  = new OutputResponse();
		try{
			
			response.setResponse(mctsOutboundCallDetailService.getCallHistory(request));
			logger.info("getCallHistory response "+response.toString());
		}catch (Exception e) {
			
			response.setError(e);
		}
		return response.toString(); 
	}
	
	/**
	 * api for getting next call date
	 * @param request
	 * @return String next call date
	 */
	@CrossOrigin()
	@RequestMapping(value="/get/next/anc/pnc", method = RequestMethod.POST, headers = "Authorization")
	public String getNextANC_PNC(@ApiParam("{\"childID or motherID\":\"Integer\", \"outboundCallType\":\"ANC or PNC\"}")
			@RequestBody String request){
		logger.info("getNextANC_PNC request "+request);
		OutputResponse response  = new OutputResponse();
		try{
			
			response.setResponse(mctsOutbondCallService.getNextANC_PNC(request));
			logger.info("getNextANC_PNC response "+response.toString());
		}catch (Exception e) {
			
			response.setError(e);
		}
		return response.toString(); 
	}
	
	/**
	 * api for getting next call date
	 * @param request
	 * @return String next call date
	 */
	@CrossOrigin()
	@RequestMapping(value="/get/updated/object", method = RequestMethod.POST, headers = "Authorization")
	public String getUpdatedObject(@ApiParam("{\"obCallID\":\"Integer\"}")
			@RequestBody String request, HttpServletRequest servletRequest){
	
		OutputResponse response  = new OutputResponse();
		try{
			
			response.setResponse(mctsOutbondCallService.getUpdatedObject(request, servletRequest));
		}catch (Exception e) {
			
			response.setError(e);
		}
		return response.toString(); 
	}
	
	/**
	 * api for getting High Risk Reason
	 * @param request
	 * @return String High Risk Reason
	 */
	@CrossOrigin()
	@RequestMapping(value="/getHighRiskReason", method = RequestMethod.POST, headers = "Authorization")
	public String getHighRiskReason(){
		logger.info("getHighRiskReason request ");
		OutputResponse response  = new OutputResponse();
		try{
			
			response.setResponse(mctsOutbondCallService.getHighRiskReason());
			logger.info("getHighRiskReason response "+response.toString());
		}catch (Exception e) {
			
			response.setError(e);
		}
		return response.toString(); 
	}

	/**
	 * The method return outbond call worklist
	 * @return list of all call worklist
	 */
	@CrossOrigin()
	@ApiOperation(value = "This API will get the worklist for the given userID")
	@ApiParam(value="", required=true)
	@RequestMapping(value="/getMotherWorklist", method = RequestMethod.POST, headers = "Authorization")
	public String getMotherWorklist(@ApiParam("{\"allocatedUserID\":\"Integer\"}")
			@RequestBody String request){
		
		OutputResponse response = new OutputResponse();
		
		try{
			
			response.setResponse(mctsOutbondCallService.getMotherWorklist(request));
		}catch (Exception e) {
		
			response.setError(e);
		}
		
		return response.toString();
	}
	
	/**
	 * The method return outbond call worklist
	 * @return list of all call worklist
	 */
	@CrossOrigin()
	@ApiOperation(value = "This API will get the worklist for the given userID")
	@ApiParam(value="", required=true)
	@RequestMapping(value="/getChildWorklist", method = RequestMethod.POST, headers = "Authorization")
	public String getChildWorklist(@ApiParam("{\"allocatedUserID\":\"Integer\"}")
			@RequestBody String request){
		
		OutputResponse response = new OutputResponse();
		
		try{
			
			response.setResponse(mctsOutbondCallService.getChildWorklist(request));
		}catch (Exception e) {
		
			response.setError(e);
		}
		
		return response.toString();
	}
	
	
}
