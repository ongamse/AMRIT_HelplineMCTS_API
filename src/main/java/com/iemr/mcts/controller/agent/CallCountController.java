package com.iemr.mcts.controller.agent;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.core.MediaType;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.iemr.mcts.data.supervisor.OutboundCallAnsweredCountDetail;
import com.iemr.mcts.services.agent.CallCountService;
import com.iemr.mcts.utils.response.OutputResponse;

import io.swagger.annotations.ApiParam;

@RestController
@RequestMapping("/callCountController")
public class CallCountController {

	Logger logger = LoggerFactory.getLogger(CallCountController.class);
	
	/**
	 * CallCountService service
	 */
	private CallCountService callCountService;

	/**
	 * Inject CallCountService service
	 */

	@Autowired
	public void setCallCountService(CallCountService callCountService) {
		this.callCountService = callCountService;
	}
	
	@CrossOrigin
	@RequestMapping(value = "/getCallAnsweredCount", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON,
			consumes = MediaType.APPLICATION_JSON, headers = "Authorization")
	public String getCallAnsweredCount(@ApiParam("{\"providerServiceMapID\":\"Integer \", \"agentID\":\"Integer\"}")
			@RequestBody OutboundCallAnsweredCountDetail outboundCallAnsweredCountDetail, HttpServletRequest httpRequest)
	{
		OutputResponse response = new OutputResponse();
		logger.info("getCallAnsweredCount request "+outboundCallAnsweredCountDetail);
		try
		{
			response.setResponse(callCountService.getCallAnsweredCount(outboundCallAnsweredCountDetail));
		} catch (Exception e)
		{
			logger.error("getCallAnsweredCount failed with error " + e.getMessage(), e);
			response.setError(e);
		}
		logger.info("getCallAnsweredCount response " + response.toString());
		return response.toString();
	}

	
	@CrossOrigin
	@RequestMapping(value = "/getCallVerifiedCount", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON,
			consumes = MediaType.APPLICATION_JSON, headers = "Authorization")
	public String getCallVerifiedCount(@ApiParam("{\"providerServiceMapID\":\"Integer \", \"agentID\":\"Integer\"}")
			@RequestBody OutboundCallAnsweredCountDetail outboundCallAnsweredCountDetail, HttpServletRequest httpRequest)
	{
		OutputResponse response = new OutputResponse();
		logger.info("getCallVerifiedCount request "+outboundCallAnsweredCountDetail);
		try
		{
			response.setResponse(callCountService.getCallVerifiedCount(outboundCallAnsweredCountDetail));
		} catch (Exception e)
		{
			logger.error("getCallVerifiedCount failed with error " + e.getMessage(), e);
			response.setError(e);
		}
		logger.info("getCallVerifiedCount response " + response.toString());
		return response.toString();
	}
	
}
