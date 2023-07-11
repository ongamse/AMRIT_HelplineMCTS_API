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

import com.iemr.mcts.data.report.BenCallDetail;
import com.iemr.mcts.data.report.HighRisk;
import com.iemr.mcts.data.report.HighRiskCall;
import com.iemr.mcts.data.report.HighRiskReportDetail;
import com.iemr.mcts.mapper.report.MctsReportmapper;
import com.iemr.mcts.repository.report.HighRiskReportRepository;
import com.iemr.mcts.utils.mapper.InputMapper;

@Service
public class HighRiskReportServiceImpl implements HighRiskReportService{

	Logger logger = LoggerFactory.getLogger(HighRiskReportServiceImpl.class);
	
	private InputMapper inputMapper = new InputMapper();
	
	private HighRiskReportRepository highRiskReportRepository;
	
	/**
	 * @param highRiskReportRepository the highRiskReportRepository to set
	 */
	@Autowired
	public void setHighRiskReportRepository(HighRiskReportRepository highRiskReportRepository) {
		this.highRiskReportRepository = highRiskReportRepository;
	}
	@Autowired
	MctsReportmapper mapper;
	
	@Override
	public String getHighRiskReport(String request) throws Exception {
		
		logger.info("HighRiskReportService.getHighRiskReport - start");
	
		HighRiskCall highRiskCall = inputMapper.gson().fromJson(request,HighRiskCall.class);
		List<HighRiskReportDetail> highRiskReportDetailList=new ArrayList<HighRiskReportDetail>();
		List<HighRisk> highRiskList=new ArrayList<HighRisk>();
		List<BenCallDetail> highRiskList1=new ArrayList<BenCallDetail>();
	
		if(highRiskCall.getUserID()!=null && highRiskCall.getUserID() >0)
		{
			highRiskList=highRiskReportRepository.getHighRiskReportByAgent(highRiskCall.getStartDate(), 
					highRiskCall.getEndDate(), highRiskCall.getProviderServiceMapID(), highRiskCall.getUserID());
		}
		else {
			highRiskList = highRiskReportRepository.getHighRiskReport(highRiskCall.getStartDate(), 
					highRiskCall.getEndDate(), highRiskCall.getProviderServiceMapID());
			highRiskList1 = highRiskReportRepository.getHighRiskReportAll(highRiskCall.getStartDate(), 
					highRiskCall.getEndDate(), highRiskCall.getProviderServiceMapID());

		}
		for(HighRisk highRisk : highRiskList)
		{
			HighRiskReportDetail report = mapper.mapHighRiskReport(highRisk);
			highRiskReportDetailList.add(report);
		}
		for(BenCallDetail highRisk : highRiskList1)
		{
			HighRiskReportDetail report = mapper.mapHighRiskMotherCall(highRisk);
			highRiskReportDetailList.add(report);
		}
		
		
		logger.info("HighRiskReportService.getHighRiskReport - end");
		
		return highRiskReportDetailList.toString();
	
	}
}
