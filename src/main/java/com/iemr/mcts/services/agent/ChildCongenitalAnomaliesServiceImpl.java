package com.iemr.mcts.services.agent;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iemr.mcts.data.agent.ChildCongenitalAnomaliesDetail;
import com.iemr.mcts.repository.agent.ChildCongenitalAnomaliesRepository;
import com.iemr.mcts.utils.exception.IEMRException;
import com.iemr.mcts.utils.mapper.InputMapper;


@Service
public class ChildCongenitalAnomaliesServiceImpl implements ChildCongenitalAnomaliesService {
	
	/**
	 * ChildCongenital Anomalies Repository
	 */
	private ChildCongenitalAnomaliesRepository childCongenitalAnomaliesRepository;
	
	/**
	 * Inject ChildCongenital Anomalies Repository
	 */
	@Autowired
	public void setChildCongenitalAnomaliesRepository
		(ChildCongenitalAnomaliesRepository childCongenitalAnomaliesRepository){
		
		this.childCongenitalAnomaliesRepository = childCongenitalAnomaliesRepository;
	}
	
	/*
	 * (non-Javadoc)
	 * @see com.iemr.mcts.services.agent.ChildCongenitalAnomaliesService#getChildCongenitalAnomalies(java.lang.String)
	 */
	@Override
	public String getChildCongenitalAnomalies(String request) throws IEMRException {
		
		ChildCongenitalAnomaliesDetail anomaliesDetail = 
				InputMapper.gson().fromJson(request , ChildCongenitalAnomaliesDetail.class); 
		
		List<ChildCongenitalAnomaliesDetail> childCongenitalAnomaliesDetails;
		
		if(anomaliesDetail.getChildID() != null) {
			
			childCongenitalAnomaliesDetails = childCongenitalAnomaliesRepository.
					findByChildID(anomaliesDetail.getChildID());
		}else {
			
			childCongenitalAnomaliesDetails = childCongenitalAnomaliesRepository.
								findByMotherID(anomaliesDetail.getMotherID());
		}
		
		return childCongenitalAnomaliesDetails.toString();
	}

}
