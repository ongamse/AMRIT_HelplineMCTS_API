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

import com.iemr.mcts.data.report.ChildDataReportDetail;
import com.iemr.mcts.data.report.ChildInvalidRecordDetail;
import com.iemr.mcts.data.report.MotherDataReportDetail;
import com.iemr.mcts.data.report.MotherInvalidRecordDetail;
import com.iemr.mcts.repository.report.ChildDataReportRepository;
import com.iemr.mcts.repository.report.ChildInvalidReportRepository;
import com.iemr.mcts.repository.report.MotherDataReportRepository;
import com.iemr.mcts.repository.report.MotherInvalidReportRepository;
import com.iemr.mcts.utils.mapper.InputMapper;

@Service
public class DataReportServiceImpl implements DataReportService{

	Logger logger = LoggerFactory.getLogger(DataReportServiceImpl.class);
	
	private InputMapper inputMapper = new InputMapper();

	private MotherDataReportRepository motherDataReportRepository;
	/**
	 * @param motherDataReportRepository the motherDataReportRepository to set
	 */
	@Autowired
	public void setMotherDataReportRepository(MotherDataReportRepository motherDataReportRepository) {
		this.motherDataReportRepository = motherDataReportRepository;
	}
	
	private ChildDataReportRepository childDataReportRepository;
	/**
	 * @param childDataReportRepository the childDataReportRepository to set
	 */
	@Autowired
	public void setChildDataReportRepository(ChildDataReportRepository childDataReportRepository) {
		this.childDataReportRepository = childDataReportRepository;
	}

	private MotherInvalidReportRepository motherInvalidReportRepository;

	/**
	 * @param motherInvalidReportRepository the motherInvalidReportRepository to set
	 */
	@Autowired
	public void setMotherInvalidReportRepository(MotherInvalidReportRepository motherInvalidReportRepository) {
		this.motherInvalidReportRepository = motherInvalidReportRepository;
	}
	
	private ChildInvalidReportRepository childInvalidReportRepository;

	/**
	 * @param childInvalidReportRepository the childInvalidReportRepository to set
	 */
	@Autowired
	public void setChildInvalidReportRepository(ChildInvalidReportRepository childInvalidReportRepository) {
		this.childInvalidReportRepository = childInvalidReportRepository;
	}

	@Override
	public String getDataReport(String request) throws Exception
	{
		logger.info("DataReportService.getDataReport - start");
		
		MotherDataReportDetail motherDataReportDetail = inputMapper.gson().fromJson(request,MotherDataReportDetail.class);
		
		List<MotherDataReportDetail> motherDataReportDetailList=new ArrayList<MotherDataReportDetail>();
		List<ChildDataReportDetail> childDataReportDetailList=new ArrayList<ChildDataReportDetail>();
		
		if(Boolean.TRUE.equals(motherDataReportDetail.getIsMother()))
		{
				motherDataReportDetailList=motherDataReportRepository.getMotherDataReport(motherDataReportDetail.getStartDate(),motherDataReportDetail.getEndDate(), 
							motherDataReportDetail.getProviderServiceMapID());
			logger.info("DataReportService.getDataReport - end");
			return motherDataReportDetailList.toString();
		
		}
		else
		{
				childDataReportDetailList=childDataReportRepository.getChildDataReport(motherDataReportDetail.getStartDate(),motherDataReportDetail.getEndDate()
							, motherDataReportDetail.getProviderServiceMapID());
			
			logger.info("DataReportService.getDataReport - end");
			return childDataReportDetailList.toString();

		}
	}
	
	@Override
	public String getInvalidRecordReport(String request) throws Exception
	{
		logger.info("DataReportService.getDataReport - start");
		
		MotherDataReportDetail motherDataReportDetail = inputMapper.gson().fromJson(request,MotherDataReportDetail.class);
		
		List<MotherInvalidRecordDetail> motherInvalidReportList=new ArrayList<MotherInvalidRecordDetail>();
		List<ChildInvalidRecordDetail> childInvalidReportList=new ArrayList<ChildInvalidRecordDetail>();
		
		if(Boolean.TRUE.equals(motherDataReportDetail.getIsMother()))
		{
			motherInvalidReportList=motherInvalidReportRepository.getMotherInvalidReport(motherDataReportDetail.getStartDate(),motherDataReportDetail.getEndDate(), motherDataReportDetail.getProviderServiceMapID());
		
			logger.info("DataReportService.getDataReport - end");
			return motherInvalidReportList.toString();
		}
		
		else
		{
			childInvalidReportList=childInvalidReportRepository.getChildInvalidReport(motherDataReportDetail.getStartDate(),motherDataReportDetail.getEndDate()
					, motherDataReportDetail.getProviderServiceMapID());
			
			logger.info("DataReportService.getDataReport - end");
			return childInvalidReportList.toString();

		}
	}
}