/*
* AMRIT – Accessible Medical Records via Integrated Technology
* Integrated EHR (Electronic Health Records) Solution
*
* Copyright (C) "Piramal Swasthya Management and Research Institute"
*
* This file is part of AMRIT.
*
* This program is free software: you can redistribute it and/or modify
* it under the terms of the GNU General Public License as published by
* the Free Software Foundation, either version 3 of the License, or
* (at your option) any later version.
*
* This program is distributed in the hope that it will be useful,
* but WITHOUT ANY WARRANTY; without even the implied warranty of
* MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
* GNU General Public License for more details.
*
* You should have received a copy of the GNU General Public License
* along with this program.  If not, see https://www.gnu.org/licenses/.
*/
package com.iemr.mcts.services.report;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iemr.mcts.data.report.ComplaintReportDetails;
import com.iemr.mcts.data.report.FeedbacksDetail;
import com.iemr.mcts.mapper.report.MctsReportmapper;
import com.iemr.mcts.repository.report.ComplaintReportRepository;
import com.iemr.mcts.utils.mapper.InputMapper;

@Service
public class ComplaintReportServiceImpl implements ComplaintReportService{

	Logger logger = LoggerFactory.getLogger(ComplaintReportServiceImpl.class);
	
	private InputMapper inputMapper = new InputMapper();
	/**
	 * ANCComplaintReportRepository repo
	 */
	private ComplaintReportRepository complaintReportRepository;
	
	/**
	 * Inject ANCComplaintReportRepository repo
	 */
	@Autowired
	public void setMctsReportRepository(ComplaintReportRepository ancComplaintReportRepository) {
		this.complaintReportRepository = ancComplaintReportRepository;
	}

	@Autowired
	MctsReportmapper mapper;
	
	@Override
	public String getComplaintReport(String request) throws Exception
	{
		logger.info("MctsReportService.getComplaintReport - start");
		
		FeedbacksDetail feedback = inputMapper.gson().fromJson(request,
				FeedbacksDetail.class);
		
		List<FeedbacksDetail> motherComplaintList=new ArrayList<FeedbacksDetail>();
		List<FeedbacksDetail> childComplaintList=new ArrayList<FeedbacksDetail>();
		
		if(feedback.getUserID()!=null && feedback.getUserID()>0){
			
		if(feedback.getIsMother()!=null && Boolean.TRUE.equals(feedback.getIsMother())) 
		{
			motherComplaintList=complaintReportRepository.getMotherComplaintByAgent(feedback.getStartDate(),feedback.getEndDate()
					, feedback.getProviderServiceMapID(), feedback.getUserID());
		}
		else if(feedback.getIsMother()!=null && Boolean.FALSE.equals(feedback.getIsMother()))
		{
				childComplaintList=complaintReportRepository.getChildComplaintByAgent(feedback.getStartDate(),feedback.getEndDate() 
						, feedback.getProviderServiceMapID(), feedback.getUserID());
		}
		else
		{
			motherComplaintList=complaintReportRepository.getMotherComplaintByAgent(feedback.getStartDate(),feedback.getEndDate()
					, feedback.getProviderServiceMapID(), feedback.getUserID());
			childComplaintList=complaintReportRepository.getChildComplaintByAgent(feedback.getStartDate(),feedback.getEndDate()
						, feedback.getProviderServiceMapID(), feedback.getUserID());
		}
		}
		else
		{
			if(feedback.getIsMother()!=null && Boolean.TRUE.equals(feedback.getIsMother())) 
			{
				motherComplaintList=complaintReportRepository.getMotherComplaint(feedback.getStartDate(),feedback.getEndDate()
						, feedback.getProviderServiceMapID());
			}
			else if(feedback.getIsMother()!=null && Boolean.FALSE.equals(feedback.getIsMother()))
			{
					childComplaintList=complaintReportRepository.getChildComplaint(feedback.getStartDate(),feedback.getEndDate() 
							, feedback.getProviderServiceMapID());
			}
			else
			{
				motherComplaintList=complaintReportRepository.getMotherComplaint(feedback.getStartDate(),feedback.getEndDate()
						, feedback.getProviderServiceMapID());
				childComplaintList=complaintReportRepository.getChildComplaint(feedback.getStartDate(),feedback.getEndDate() 
						, feedback.getProviderServiceMapID());
			}
			
		}
			List<ComplaintReportDetails> reportList=new ArrayList<ComplaintReportDetails>();
			for(FeedbacksDetail feed : motherComplaintList)
			{
				ComplaintReportDetails dto=mapper.mapMotherComplaint(feed);
				reportList.add(dto);
			}
			for(FeedbacksDetail feed : childComplaintList)
			{
				ComplaintReportDetails dto=mapper.mapChildComplaint(feed);
				reportList.add(dto);
			}
		logger.info("MctsReportService.getComplaintReport - end");
		
		return reportList.toString();
	}
	
}
