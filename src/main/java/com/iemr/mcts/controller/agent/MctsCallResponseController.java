package com.iemr.mcts.controller.agent;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.iemr.mcts.services.agent.MctsCallResponseService;
import com.iemr.mcts.utils.response.OutputResponse;

import io.swagger.annotations.ApiParam;

@RestController
@RequestMapping("mctsCallResponseController")
public class MctsCallResponseController {

	private final Logger logger = LoggerFactory.getLogger(this.getClass().getName());
	/**
	 * mcts call response service
	 */
	private MctsCallResponseService mctsCallResponseService;

	/**
	 * Inject mcts call response
	 */
	@Autowired
	public void setMctsCallResponseService(MctsCallResponseService mctsCallResponseService) {

		this.mctsCallResponseService = mctsCallResponseService;
	}

	/**
	 * api for reading call history
	 * 
	 * @param request
	 * @return String count of allocated calls
	 */
	@CrossOrigin()
	@RequestMapping(value = "/put/call/response", method = RequestMethod.POST, headers = "Authorization")
	public String putMctsCallResponse(@ApiParam("{\"callDetailID\":\"Integer\", \"questionID\":\"Integer\", \"answer\":\"String \", \"remark\":\"String\"}") 
					@RequestBody String request) {
		logger.info("putMctsCallResponse request "+request);
		OutputResponse response = new OutputResponse();
		try {

			response.setResponse(mctsCallResponseService.saveMctsCallResponse(request));
			logger.info("putMctsCallResponse response "+response.toString());
		} catch (Exception e) {

			response.setError(e);
		}
		return response.toString();
	}

	@CrossOrigin()
	@RequestMapping(value = "get/call/response", method = RequestMethod.POST, headers = "Authorization")
	public String getMctsCallResponse(@ApiParam("{\"callDetailID\":\"Integer\"}")  
			@RequestBody String request) {
		logger.info("getMctsCallResponse request "+request);
		OutputResponse response = new OutputResponse();
		try {

			response.setResponse(mctsCallResponseService.getMctsCallResponse(request));
			logger.info("getMctsCallResponse response "+response.toString());
		} catch (Exception e) {

			response.setError(e);
		}
		return response.toString();
	}

	@CrossOrigin()
	@RequestMapping(value = "update/call/response", method = RequestMethod.POST, headers = "Authorization")
	public String updateMctsCallResponse(@ApiParam("{\"mctsCallResponseID\":\"Integer\", \"answer\":\"String \", \"remark\":\"String\"}")
			@RequestBody String request) {
		logger.info("updateMctsCallResponse request "+request);
		OutputResponse response = new OutputResponse();
		try {

			response.setResponse(mctsCallResponseService.updateMctsCallResponse(request));
			logger.info("updateMctsCallResponse response "+response.toString());
		} catch (Exception e) {

			response.setError(e);
		}
		return response.toString();
	}

}
