package com.iemr.mcts.controller.agent;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.iemr.mcts.services.agent.FeedbackService;
import com.iemr.mcts.utils.response.OutputResponse;

import io.swagger.annotations.ApiParam;

@RestController
@RequestMapping("feedbackController")
public class FeedbackController {

	private final Logger logger = LoggerFactory.getLogger(this.getClass().getName());
	
	/**
	 * Feed back service
	 */
	private FeedbackService feedbackService;
	
	/**
	 * set feedback service
	 * @param feedbackService
	 */
	@Autowired
	public void setFeedBackService(FeedbackService feedbackService){
		
		this.feedbackService = feedbackService;
	}
	
	/**
	 * 
	 * @param request
	 * @return
	 */
	@CrossOrigin()
	@RequestMapping(value="/complaint/list", method = RequestMethod.POST, headers = "Authorization")
	public String feedBackList(@ApiParam("{\"beneficiaryRegID\":\"Integer \"}") @RequestBody String request){
		logger.info("feedBackList request "+request);
		OutputResponse response  = new OutputResponse();
		try{
			
			response.setResponse(feedbackService.getFeedBackList(request));
			logger.info("feedBackList response "+response.toString());
		}catch (Exception e) {
			
			response.setError(e);
		}
		return response.toString(); 
	}
}
