package com.iemr.mcts.services.agent;

import javax.servlet.http.HttpServletRequest;

import com.iemr.mcts.utils.exception.IEMRException;

public interface MctsIdentityService {

	String searchBeneficiary(String request, HttpServletRequest servletRequest) throws IEMRException;

	String createBeneficiaries(String request, HttpServletRequest servletRequest)  throws IEMRException;

	String getBeneficiaryID(String request, HttpServletRequest servletRequest) throws IEMRException;

	String getByBeneficiaryPhoneNo(String request, HttpServletRequest servletRequest) throws IEMRException;

	String updateBeneficiaries(String request, HttpServletRequest servletRequest) throws IEMRException;
	
}
