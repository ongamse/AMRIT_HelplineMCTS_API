package com.iemr.mcts.services.supervisor;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.tika.exception.TikaException;

import com.iemr.mcts.data.mapper.UploadData;
import com.iemr.mcts.data.supervisor.FileManager;
import com.iemr.mcts.utils.exception.IEMRException;

public interface MctsDataHandlerService {

	
	String savemother(UploadData uploadData);
	/**
	 * service method to upload mcts data
	 * @param request 
	 * @param servletRequest 
	 * @param inputStream
	 * @return
	 * @throws IEMRException 
	 */
	UploadData mctsDataUpload(String request, HttpServletRequest servletRequest) throws IOException, TikaException, IEMRException;

	/**
	 * this to update beneficiary details
	 * @param request
	 * @return
	 * @throws IEMRException 
	 */
	String updateBeneficiary(String request) throws IEMRException;
	
	UploadData validateData(UploadData uploadData);
	
	FileManager uploadstatus(String request) throws IEMRException;
	FileManager savefilemanger(FileManager fileManager);

}
