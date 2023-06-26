package com.iemr.mcts.controller.agent;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.iemr.mcts.services.agent.ChildCongenitalAnomaliesService;
import com.iemr.mcts.services.agent.CongenitalAnomaliesService;
import com.iemr.mcts.utils.response.OutputResponse;

import io.swagger.annotations.ApiParam;

@RestController
@RequestMapping("/congenitalAnomaliesController")
public class CongenitalAnomaliesController {

	/**
	 * Congenital Anomolies Service
	 */
	private CongenitalAnomaliesService congenitalAnomaliesService;
	
	/**
	 * Inject Congenital Anomolies Service
	 */
	@Autowired
	public void setCongenitalAnomaliesService(CongenitalAnomaliesService congenitalAnomaliesService){
		
		this.congenitalAnomaliesService = congenitalAnomaliesService;
	}
	
	/**
	 * Child Congenital AnomaliesService
	 */
	private ChildCongenitalAnomaliesService childCongenitalAnomaliesService;
	
	/**
	 * Inject Child Congenital AnomaliesService
	 */
	@Autowired
	public void setChildCongenitalAnomaliesService(ChildCongenitalAnomaliesService childCongenitalAnomaliesService){
		
		this.childCongenitalAnomaliesService = childCongenitalAnomaliesService;
	}
	
	@CrossOrigin()
	@RequestMapping(value="/get/conganomolies", method = RequestMethod.POST, headers = "Authorization")
	public String getCongAnomolies(){
		
		OutputResponse response  = new OutputResponse();
		try{
			
			response.setResponse(congenitalAnomaliesService.getCongenitalAnomalies());
		}catch (Exception e) {
			
			response.setError(e);
		}
		return response.toString(); 
	}
	
	@CrossOrigin()
	@RequestMapping(value="/get/child/conganomolies", method = RequestMethod.POST, headers = "Authorization")
	public String getchildCA(@ApiParam("{\"childID\":\"Integer \"}") @RequestBody String request){
		
		OutputResponse response  = new OutputResponse();
		try{
			
			response.setResponse(childCongenitalAnomaliesService.getChildCongenitalAnomalies(request));
		}catch (Exception e) {
			
			response.setError(e);
		}
		return response.toString(); 
	}
}
