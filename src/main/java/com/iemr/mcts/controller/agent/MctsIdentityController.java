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

import com.iemr.mcts.services.agent.MctsIdentityService;
import com.iemr.mcts.utils.response.OutputResponse;

import io.swagger.annotations.ApiParam;

@RestController
@RequestMapping("/mctsidentitycontroller")
public class MctsIdentityController {

	private final Logger logger = LoggerFactory.getLogger(this.getClass().getName());
	/**
	 * decleration MctsIdentityService
	 */
	private MctsIdentityService mctsIdentityService;
	
	/**
	 * Inject MctsIdentityService
	 */
	@Autowired
	public void setMctsIdentityService(MctsIdentityService mctsIdentityService){
		
		this.mctsIdentityService = mctsIdentityService;
	}
	
	/**
	 * 
	 * @param request
	 * @return
	 */
	@CrossOrigin
	@RequestMapping(value="/search/beneficiary", method = RequestMethod.POST, headers = "Authorization")
	public String searchBeneficiaries(@ApiParam("{\"firstName\":\"String\", \"lastName\":\"String \", \"contactNumber\":\"String \"}")
			@RequestBody String request, HttpServletRequest servletRequest){
		logger.info("searchBeneficiaries request "+request);
		OutputResponse response = new OutputResponse();
		try {

			response.setResponse(mctsIdentityService.searchBeneficiary(request, servletRequest));
			logger.info("searchBeneficiaries response "+response.toString());
		} catch (Exception e) {

			response.setError(e);
		}
		return response.toString();
	}
	
	/**
	 * 
	 * @param request
	 * @return
	 */
	@CrossOrigin
	@RequestMapping(value="/create/beneficiary", method = RequestMethod.POST, headers = "Authorization")
	public String createBeneficiaries(@ApiParam("{\"firstName\":\"String\", \"lastName\":\"String \", \"contactNumber\":\"String \", \"stateID\":\"Integer \", \"districtID\":\"Integer \", "
			+ "\"createdBy\":\"String \", \"providerServiceMapID\":\"Integer \", \"vanID\":\"Integer \", \"genderID\":\"Integer \"}") 
			@RequestBody String request, HttpServletRequest servletRequest){
		
		OutputResponse response = new OutputResponse();
		try {

			response.setResponse(mctsIdentityService.createBeneficiaries(request, servletRequest));
		} catch (Exception e) {

			response.setError(e);
		}
		return response.toString();
	}
	
	/**
	 * 
	 * @param request
	 * @return
	 */
	@CrossOrigin
	@RequestMapping(value="/get/beneficiaryid", method = RequestMethod.POST, headers = "Authorization")
	public String getBeneficiaryID(@ApiParam("{\"beneficiaryRegID\":\"Integer \"}")
			@RequestBody String request, HttpServletRequest servletRequest){
		logger.info("getBeneficiaryID request "+request);
		OutputResponse response = new OutputResponse();
		try {

			response.setResponse(mctsIdentityService.getBeneficiaryID(request, servletRequest));
			logger.info("getBeneficiaryID response "+response.toString());
		} catch (Exception e) {

			response.setError(e);
		}
		return response.toString();
	}
}
