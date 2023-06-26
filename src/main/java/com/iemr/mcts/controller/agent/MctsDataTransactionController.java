package com.iemr.mcts.controller.agent;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.iemr.mcts.services.agent.MctsDataTransactionService;
import com.iemr.mcts.utils.response.OutputResponse;

import io.swagger.annotations.ApiParam;

@RestController
@RequestMapping(value = "/mctsdatatransactioncontroller")
public class MctsDataTransactionController {

	/**
	 * private MctsDataTransactionService
	 */
	private MctsDataTransactionService mctsDataTransactionService;

	/**
	 * Inject MctsDataTransactionService
	 */
	@Autowired
	public void setMctsDataTransactionService(MctsDataTransactionService mctsDataTransactionService) {

		this.mctsDataTransactionService = mctsDataTransactionService;
	}

	/**
	 * 
	 * @param request
	 * @return
	 */
	@CrossOrigin
	@RequestMapping(value = "/edit/mctsdata", method = RequestMethod.POST, headers = "Authorization")
	public String updateData(@RequestBody String request, HttpServletRequest servletRequest) {

		OutputResponse response = new OutputResponse();
		try {

			response.setResponse(mctsDataTransactionService.updateData(request, servletRequest));
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
	@RequestMapping(value = "/associate/beneficiaryID", method = RequestMethod.POST, headers = "Authorization")
	public String associateBeneficiaryID(@ApiParam("{\"mCTSID_no\":\"Integer\", \"beneficiaryRegID\":\"String \"}") 
			@RequestBody String request) {

		OutputResponse response = new OutputResponse();
		try {

			response.setResponse(mctsDataTransactionService.associateBeneficiaryID(request));
		} catch (Exception e) {

			response.setError(e);
		}
		return response.toString();
	}
}
