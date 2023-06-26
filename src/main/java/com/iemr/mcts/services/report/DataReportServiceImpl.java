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