package com.iemr.mcts.controller.supervisor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.iemr.mcts.services.supervisor.MctsStatewiseFieldsService;
import com.iemr.mcts.utils.response.OutputResponse;

import io.swagger.annotations.ApiParam;

@RestController
@RequestMapping("/mctsStatewiseFieldsController")
public class MctsStatewiseFieldsController {

	/**
	 * mcta statewise fields controller
	 */
	private MctsStatewiseFieldsService mctsStatewiseFieldsService;
	
	/**
	 * Inject
	 */
	@Autowired
	public void setMctsStatewiseFieldsService(MctsStatewiseFieldsService mctsStatewiseFieldsService){
		
		this.mctsStatewiseFieldsService = mctsStatewiseFieldsService;
	}
	
	@CrossOrigin
	@RequestMapping(value = "/get/variablenames", method = RequestMethod.POST, headers = "Authorization")
	public String getVariables(@ApiParam("{\"providerServiceMapID\":\"Integer\", \"fieldFor\":\"String Name\"}") @RequestBody String request){
		
		OutputResponse response = new OutputResponse();
		
		try{
			
			response.setResponse(mctsStatewiseFieldsService.getVariables(request));
			
		}catch (Exception e) {
			
			response.setError(e);
		}
		
		return response.toString();
	}
}
