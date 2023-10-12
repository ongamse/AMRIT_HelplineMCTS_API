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

import com.iemr.mcts.data.report.CongenitalAnomalies;
import com.iemr.mcts.data.report.CongenitalAnomaliesReport;
import com.iemr.mcts.mapper.report.MctsReportmapper;
import com.iemr.mcts.repository.report.CongenitalReportRepository;
import com.iemr.mcts.utils.mapper.InputMapper;

@Service
public class CongenitalAnomaliesReportServiceImpl implements CongenitalAnomaliesReportService{

	Logger logger = LoggerFactory.getLogger(CongenitalAnomaliesReportServiceImpl.class);
	
	private InputMapper inputMapper = new InputMapper();
	
	private CongenitalReportRepository congenitalAnomaliesRepository;
	
	/**
	 * @param congenitalAnomaliesRepository the congenitalAnomaliesRepository to set
	 */
	@Autowired
	public void setCongenitalAnomaliesRepository(CongenitalReportRepository congenitalAnomaliesRepository) {
		this.congenitalAnomaliesRepository = congenitalAnomaliesRepository;
	}
	
	@Autowired
	MctsReportmapper mapper;

	@Override
	public String getCongenitalAnomaliesReport(String request) throws Exception
	{
		logger.info("CongenitalAnomaliesReportServiceImpl.getCongenitalAnomaliesReport - start");
		
		CongenitalAnomalies congenitalAnomalies = inputMapper.gson().fromJson(request,CongenitalAnomalies.class);
		
		List<CongenitalAnomalies> congenitalAnomaliesList=new ArrayList<CongenitalAnomalies>();
		List<CongenitalAnomaliesReport> reportList=new ArrayList<CongenitalAnomaliesReport>();
		
		if(congenitalAnomalies.getUserID()!=null && congenitalAnomalies.getUserID()> 0) {
		
		congenitalAnomaliesList =congenitalAnomaliesRepository.getCongenitalAnomaliesReportByAgent(congenitalAnomalies.getStartDate(),congenitalAnomalies.getEndDate()
				, congenitalAnomalies.getProviderServiceMapID(), congenitalAnomalies.getUserID());
		}
		else
		{
			congenitalAnomaliesList =congenitalAnomaliesRepository.getCongenitalAnomaliesReport(congenitalAnomalies.getStartDate(),congenitalAnomalies.getEndDate()
					, congenitalAnomalies.getProviderServiceMapID());
		}
		
		for(CongenitalAnomalies anomalies  : congenitalAnomaliesList)
		{
			CongenitalAnomaliesReport report = mapper.mapCongenitalAnomaliesReport(anomalies);
			reportList.add(report);
		}
		
		logger.info("CongenitalAnomaliesReportServiceImpl.getCongenitalAnomaliesReport - end");
		return reportList.toString();
	}
}
