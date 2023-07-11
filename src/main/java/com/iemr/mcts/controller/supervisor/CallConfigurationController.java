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
package com.iemr.mcts.controller.supervisor;

import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.iemr.mcts.data.supervisor.CallConfigurationDetail;
import com.iemr.mcts.data.supervisor.CallNumbersConfigDetail;
import com.iemr.mcts.services.supervisor.CallConfigurationService;
import com.iemr.mcts.utils.mapper.InputMapper;
import com.iemr.mcts.utils.response.OutputResponse;

import io.swagger.annotations.ApiParam;

@RestController
@RequestMapping("/callConfigurationController")
public class CallConfigurationController {

	private InputMapper inputMapper = new InputMapper();
	
	/**
	 * Call configuration service
	 */
	private CallConfigurationService callConfigurationService;
	
	/**
	 * Inject Call configuration service
	 * @param callConfigurationService
	 */
	@Autowired
	public void setCallConfigurationService(CallConfigurationService callConfigurationService){
		
		this.callConfigurationService = callConfigurationService;
	}
	
	public static final Logger logger = LoggerFactory.getLogger(CallConfigurationController.class);
	
	@CrossOrigin()
	@RequestMapping(value="/put/confignumbers", method = RequestMethod.POST, headers = "Authorization")
	public String putConfig(@ApiParam("{\"providerServiceMapID\":\"Integer\", \"effectiveFrom\":\"Date\", \"effectiveUpto\":\"Date\", \"createdBy\":\"String- Name\"}") 
							@RequestBody String request){
		
		OutputResponse response = new OutputResponse();
		
		try{
			
			CallNumbersConfigDetail callNumbersConfigDetail = inputMapper.gson().fromJson(request, CallNumbersConfigDetail.class);
			List<CallConfigurationDetail> callConfigurationDetails = callConfigurationService.createCallNumberConfigurations(callNumbersConfigDetail);
			response.setResponse(callConfigurationDetails.toString());
			
		}catch (Exception e) {
			
			response.setError(e);
		}
		
		return response.toString(); //response.toString();
	}
	
	@CrossOrigin()
	@RequestMapping(value="/put/configupdate", method = RequestMethod.POST, headers = "Authorization")
	public String putConfigUpdate(@ApiParam("{\"mctsCallConfigID\":\"Integer\", \"effectiveFrom\":\"Date\", \"effectiveUpto\":\"Date\"}") @RequestBody String request){
		
		OutputResponse response = new OutputResponse();
		
		try{
			
			CallConfigurationDetail[] callConfigurationDetails = inputMapper.gson().fromJson(request, CallConfigurationDetail[].class);
			List<CallConfigurationDetail> callConfigurationDetailList = Arrays.asList(callConfigurationDetails);
			List<CallConfigurationDetail> callConfigurationDetails2 = callConfigurationService.updateConfigurations(callConfigurationDetailList);
			response.setResponse(callConfigurationDetails2.toString());
			
		}catch (Exception e) {

			response.setError(e);
		}
		
		return response.toString(); //response.toString();
	}
	
	@CrossOrigin()
	@RequestMapping(value="/put/configuration", method = RequestMethod.POST, headers = "Authorization")
	public String createConfig(@ApiParam("{\"providerServiceMapID\":\"Integer\", \"effectiveFrom\":\"Date\", \"effectiveUpto\":\"Date\", \"createdBy\":\"String- Name\"}")
									@RequestBody String request){
		
		OutputResponse response = new OutputResponse();
		
		try{
			
			CallConfigurationDetail[] callConfigurationDetails = inputMapper.gson().fromJson(request, CallConfigurationDetail[].class);
			List<CallConfigurationDetail> callConfigurationDetailList = Arrays.asList(callConfigurationDetails);
			List<CallConfigurationDetail> callConfigurationDetails2 = callConfigurationService.createConfigurations(callConfigurationDetailList);
			response.setResponse(callConfigurationDetails2.toString());
			
		}catch (Exception e) {

			response.setError(e);
		}
		
		return response.toString(); //response.toString();
	}
	
	/**
	 * out bound call types for question configuration
	 * @param request
	 * @return
	 */
	@CrossOrigin()
	@RequestMapping(value="/get/ouboundcalltypes", method = RequestMethod.POST, headers = "Authorization")
	public String getOutboundCallTypes(@ApiParam("{\"providerServiceMapID\":\"Integer\"}") @RequestBody String request){
		
		OutputResponse response = new OutputResponse();
		
		try{
			
			response.setResponse(callConfigurationService.getOutBoundCallTypes(request));
			
		}catch (Exception e) {
			
			response.setError(e);
		}
		
		return response.toString();
	}
	
	/**
	 * out bound call types for question configuration
	 * @param request
	 * @return
	 */
	@CrossOrigin()
	@RequestMapping(value="/get/configuration/list", method = RequestMethod.POST, headers = "Authorization")
	public String getCallConfigurationList(@ApiParam("{\"providerServiceMapID\":\"Integer\"}") @RequestBody String request){
		
		OutputResponse response = new OutputResponse();
		
		try{
			
			response.setResponse(callConfigurationService.getCallConfigurationList(request));
			
		}catch (Exception e) {
			
			response.setError(e);
		}
		
		return response.toString();
	}
	
	/**
	 * 
	 * @param request
	 * @return
	 */
	@CrossOrigin()
	@RequestMapping(value="/put/configuration/update", method = RequestMethod.POST, headers = "Authorization")
	public String putConfigurationUpdate(@ApiParam("{\"providerServiceMapID\":\"Integer\", \"createdDate\":\"Date\", \"effectiveUpto\":\"Date\"}") 
											@RequestBody String request){
		
		OutputResponse response = new OutputResponse();
		
		try{
			
			response.setResponse(callConfigurationService.updateCallConfigurations(request));
			
		}catch (Exception e) {

			response.setError(e);
		}
		
		return response.toString(); //response.toString();
	}
	
	/**
	 * 
	 * @param request
	 * @return
	 */
	@CrossOrigin()
	@RequestMapping(value="/delete/configuration", method = RequestMethod.POST, headers = "Authorization")
	public String deleteConfiguration(@ApiParam("{\"mctsCallConfigID\":\"Integer\"}") @RequestBody String request){
		
		OutputResponse response = new OutputResponse();
		
		try{
			
			response.setResponse(callConfigurationService.deleteConfiguration(request));
			
		}catch (Exception e) {

			response.setError(e);
		}
		
		return response.toString(); //response.toString();
	}
	
	/**
	 * out bound call types for question configuration
	 * @param request
	 * @return
	 */
	@CrossOrigin()
	@RequestMapping(value="/get/configuration/listForReport", method = RequestMethod.POST, headers = "Authorization")
	public String getCallConfigurationListForReport(@ApiParam("{\"providerServiceMapID\":\"Integer\"},{\\\"endDate\\\":\\\"TimeStamp\\\"}") @RequestBody String request){
		
		OutputResponse response = new OutputResponse();
		
		try{
			
			response.setResponse(callConfigurationService.getCallConfigurationListForReport(request));
			
		}catch (Exception e) {
			
			response.setError(e);
		}
		
		return response.toString();
	}
}
