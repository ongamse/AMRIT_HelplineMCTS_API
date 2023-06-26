package com.iemr.mcts.controller.supervisor;

import java.io.IOException;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.servlet.http.HttpServletRequest;

import org.apache.tika.exception.TikaException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.iemr.mcts.data.mapper.UploadData;
import com.iemr.mcts.data.supervisor.FileManager;
import com.iemr.mcts.services.supervisor.MctsDataHandlerService;
import com.iemr.mcts.utils.response.OutputResponse;

import io.swagger.annotations.ApiParam;

@RestController
@RequestMapping("mctsDataHandlerController")
public class MctsDataHandlerController {

	/**
	 * MCTS mother/ child data upload
	 * 
	 * @param file
	 * @return string message
	 */
	@CrossOrigin()
	@RequestMapping(value = "/mcts/data/upload", method = RequestMethod.POST, headers = "Authorization")
	public String uploadData(@RequestBody String request, HttpServletRequest servletRequest) {

		OutputResponse response = new OutputResponse();

		try {

			//
			UploadData uploadData = mctsDataHandlerService.mctsDataUpload(request, servletRequest);
			if(uploadData!=null && uploadData.getFileManager()!=null && uploadData.getFileManager().getFileID()!=null){
				final ExecutorService pool = Executors.newFixedThreadPool(10);
				pool.submit(new Callable<String>() {
					@Override
					public String call() {
						String x="";
						try{
							final UploadData uploadData1=mctsDataHandlerService.validateData(uploadData);
							x=mctsDataHandlerService.savemother(uploadData1);
						}catch(Exception e){
							FileManager file=uploadData.getFileManager();
							file.setStatusReason(e.getMessage());
							file.setFileStatusID(4L);
							mctsDataHandlerService.savefilemanger(uploadData.getFileManager());
						}
						
						return x;
					}
				});
			}
			if(uploadData != null && uploadData.getMessage().contains("FileID"))
			{
				uploadData.setMessage("FileID");
			}
			if(uploadData != null)
			{
			    response.setResponse(uploadData.getMessage());
			}
			
		} catch (IllegalStateException | IOException e) {

			response.setError(e);
		} catch (TikaException e) {

			response.setError(e);
		} catch (Exception e) {
			response.setError(e);
		}

		return response.toString();
	}

	/**
	 * File data upload service
	 */
	private MctsDataHandlerService mctsDataHandlerService;

	/**
	 * Inject service
	 */
	@Autowired
	public void setMctsDataHadlerService(MctsDataHandlerService mctsDataHandlerService) {

		this.mctsDataHandlerService = mctsDataHandlerService;
	}

	/**
	 * MCTS mother/ child data upload
	 * 
	 * @param file
	 * @return string message
	 */
	@CrossOrigin()
	@RequestMapping(value = "/update/beneficiary/data", method = RequestMethod.POST, headers = "Authorization")
	public String updateBeneficiary(@RequestParam("request") String request) {

		OutputResponse response = new OutputResponse();

		try {

			response.setResponse(mctsDataHandlerService.updateBeneficiary(request));

		} catch (Exception e) {
			response.setError(e);
		}

		return response.toString();
	}
	
	@CrossOrigin()
	@RequestMapping(value = "/mcts/data/upload/status", method = RequestMethod.POST, headers = "Authorization")
	public String uploadstatus(@ApiParam("{\"providerServiceMapID\":\"Integer - provider service ID\"}") @RequestBody String request) {

		OutputResponse response = new OutputResponse();

		try {

			response.setResponse(mctsDataHandlerService.uploadstatus(request).toString());

		} catch (Exception e) {
			response.setError(e);
		}

		return response.toString();
	}
}
