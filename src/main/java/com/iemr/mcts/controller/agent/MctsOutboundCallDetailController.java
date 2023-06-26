package com.iemr.mcts.controller.agent;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.iemr.mcts.services.agent.MctsOutboundCallDetailService;
import com.iemr.mcts.utils.response.OutputResponse;

import io.swagger.annotations.ApiParam;

@RestController
@RequestMapping("mctsOutboundCallDetailController")
public class MctsOutboundCallDetailController {

	/**
	 * outbound call service for history
	 */
	private MctsOutboundCallDetailService mctsOutboundCallDetailService;
	
	/**
	 * Inject outbound call service for history
	 */
	@Autowired 
	public void setMctsOutboundCallDeatilService(MctsOutboundCallDetailService mctsOutboundCallDetailService){
		
		this.mctsOutboundCallDetailService = mctsOutboundCallDetailService;
	}
	
	/**
	 * api for reading beneficiary on call transfer
	 * @param request
	 * @return String count of allocated calls
	 */
	@CrossOrigin()
	@RequestMapping(value="/get/benificiary/details", method = RequestMethod.POST, headers = "Authorization")
	public String getBeneficiaryDetails(@ApiParam("{\"beneficiaryRegID\":\"Integer \"}")
			@RequestBody String request, HttpServletRequest servletRequest){
	
		OutputResponse response  = new OutputResponse();
		try{
			
			response.setResponse(mctsOutboundCallDetailService.getBeneficiaryDetails(request, servletRequest));
		}catch (Exception e) {
			
			response.setError(e);
		}
		return response.toString(); 
	}
	
	/**
	 * to save call after call is connected
	 * @param request
	 * @return
	 */
	@CrossOrigin
	@RequestMapping(value = "/put/call/history", method = RequestMethod.POST, headers = "Authorization")
	public String getVariables(@ApiParam("{\"czentrixCallID\":\"String\", \"allocatedUserID\":\"Integer \"}")
			@RequestBody String request){
		
		OutputResponse response = new OutputResponse();
		
		try{
			
			response.setResponse(mctsOutboundCallDetailService.createCallHistory(request));
			
		}catch (Exception e) {
			
			response.setError(e);
		}
		
		return response.toString();
	}
	
	/**
	 * to save call after call is connected
	 * @param request
	 * @return
	 */
	@CrossOrigin
	@RequestMapping(value = "/get/change/log", method = RequestMethod.POST, headers = "Authorization")
	public String getChangeLog(@ApiParam("{\"childID or mothetID\":\"String\"}")
			@RequestBody String request){
		
		OutputResponse response = new OutputResponse();
		
		try{
			
			response.setResponse(mctsOutboundCallDetailService.getChangeLog(request));
			
		}catch (Exception e) {
			
			response.setError(e);
		}
		
		return response.toString();
	}
	
	/**
	 * to send sms advice
	 * @param request
	 * @return
	 */
	@CrossOrigin
	@RequestMapping(value = "/put/sms/advice", method = RequestMethod.POST, headers = "Authorization")
	public String sendSmsAdvise(@ApiParam("{\"smsAdvice\":\"String\", \"callDetailID\":\"Integer\"}")
			@RequestBody String request){
		
		OutputResponse response = new OutputResponse();
		
		try{
			
			response.setResponse(mctsOutboundCallDetailService.sendSmsAdvice(request));
			
		}catch (Exception e) {
			
			response.setError(e);
		}
		
		return response.toString();
	}
	
	/**
	 * to save get advice - updation will be done if required
	 * @param request
	 * @return
	 */
	@CrossOrigin
	//@RequestMapping(value = "/get/sms/advise", method = RequestMethod.POST, headers = "Authorization")
	public String getSmsAdvise(@RequestBody String request){
		
		OutputResponse response = new OutputResponse();
		
		try{
			
			response.setResponse(mctsOutboundCallDetailService.getSmsAdvice(request));
			
		}catch (Exception e) {
			
			response.setError(e);
		}
		
		return response.toString();
	}
	
	/**
	 * case sheet
	 * @param request
	 * @return
	 */
	@CrossOrigin
	@RequestMapping(value = "/case/sheet", method = RequestMethod.POST, headers = "Authorization")
	public String caseSheet(@ApiParam("{\"callDetailID\":\"Integer\"}")
			@RequestBody String request, HttpServletRequest servletRequest) {

		OutputResponse response = new OutputResponse();
		try {

			response.setResponse(mctsOutboundCallDetailService.caseSheet(request, servletRequest));
		} catch (Exception e) {

			response.setError(e);
		}
		return response.toString();
	}
}
