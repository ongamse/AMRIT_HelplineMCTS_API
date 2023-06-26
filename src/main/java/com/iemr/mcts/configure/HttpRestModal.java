package com.iemr.mcts.configure;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.iemr.mcts.utils.exception.IEMRException;
import com.iemr.mcts.utils.http.HttpUtils;
import com.iemr.mcts.utils.mapper.InputMapper;
import com.iemr.mcts.utils.response.OutputResponse;

@Service
public class HttpRestModal {

//	/**
//	 * HttpHeaders
//	 */
//	private HttpHeaders httpHeaders;
//	
//	/**
//	 * Rest Template
//	 */
//	@Autowired
//	private RestTemplate restTemplate;
//	
//	/**
//	 * HttpEntity<String> 
//	 */
//	
//	private HttpEntity<String> httpEntity;
	
	private static HttpUtils httpUtils = new HttpUtils();
	
	private InputMapper inputMapper = new InputMapper();
	
//	public String restURLConnect(String request, String url, String auth){
//		
//		httpHeaders = new HttpHeaders();
//		httpHeaders.setContentType(MediaType.APPLICATION_JSON);
//		httpHeaders.set("Authentication", auth);
//		httpEntity = new HttpEntity<String>(request, httpHeaders);
//		
//		return restTemplate.postForObject(url, request, String.class);
//	}
	
	public String restURLConnect(String request, String url, String auth) throws IEMRException
	{

		String result;

		HashMap<String, Object> header = new HashMap<>();
		if (auth != null)
		{
			header.put("Authorization", auth);
		}
		result = httpUtils.post(url, request, header);

		OutputResponse identityResponse = inputMapper.gson().fromJson(result, OutputResponse.class);
		if (identityResponse.getStatusCode() == OutputResponse.USERID_FAILURE)
		{
			throw new IEMRException(identityResponse.getErrorMessage());
		}
		return identityResponse.getData();
	}
}
