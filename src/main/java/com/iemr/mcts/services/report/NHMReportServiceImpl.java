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
import com.iemr.mcts.data.report.NHMReportDetail;
import com.iemr.mcts.mapper.report.MctsReportmapper;
import com.iemr.mcts.repository.report.NHMReportRepository;
import com.iemr.mcts.utils.mapper.InputMapper;

@Service
public class NHMReportServiceImpl implements NHMReportService{

	Logger logger = LoggerFactory.getLogger(ComplaintReportServiceImpl.class);
	
	private InputMapper inputMapper = new InputMapper();
	
	private NHMReportRepository nhmReportRepository;
	
	/**
	 * @param nhmReportRepository the nhmReportRepository to set
	 */
	@Autowired
	public void setNhmReportRepository(NHMReportRepository nhmReportRepository) {
		this.nhmReportRepository = nhmReportRepository;
	}

	@Autowired
	MctsReportmapper mapper;

	@Override
	public String getNHMReport(String request) throws Exception
	{
		logger.info("NHMReportService.getNHMReport - start");
		
		BenCallDetail benCallDetail = inputMapper.gson().fromJson(request,BenCallDetail.class);
		
		List<BenCallDetail> benCallDetailMotherList=new ArrayList<BenCallDetail>();
		List<BenCallDetail> benCallDetailChildList=new ArrayList<BenCallDetail>();
		
		List<NHMReportDetail> reportList = new ArrayList<NHMReportDetail>();
		
		if(benCallDetail.getUserID()!=null && benCallDetail.getUserID()>0) {
			benCallDetailMotherList =nhmReportRepository.getNHMReportMotherByAgent(benCallDetail.getStartDate(),benCallDetail.getEndDate()
				, benCallDetail.getProviderServiceMapID(), benCallDetail.getUserID());
		
			benCallDetailChildList = nhmReportRepository.getNHMReportChildByAgent(benCallDetail.getStartDate(),benCallDetail.getEndDate()
				, benCallDetail.getProviderServiceMapID(), benCallDetail.getUserID());
		
		}
		else
		{
			benCallDetailMotherList =nhmReportRepository.getNHMReportMother(benCallDetail.getStartDate(),benCallDetail.getEndDate()
					, benCallDetail.getProviderServiceMapID());
			
			benCallDetailChildList = nhmReportRepository.getNHMReportChild(benCallDetail.getStartDate(),benCallDetail.getEndDate()
					, benCallDetail.getProviderServiceMapID());
		}
		
		for(BenCallDetail benCall :benCallDetailMotherList)
		{
			NHMReportDetail report = mapper.mapNHMMotherReport(benCall);
			reportList.add(report);
		}
		
		for(BenCallDetail benCall :benCallDetailChildList)
		{
			NHMReportDetail report = mapper.mapNHMChildReport(benCall);
			reportList.add(report);
		}
		
		logger.info("NHMReportService.getNHMReport - end");
		
		return reportList.toString();
	}
	
}
