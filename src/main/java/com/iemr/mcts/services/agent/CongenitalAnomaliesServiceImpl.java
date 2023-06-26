package com.iemr.mcts.services.agent;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iemr.mcts.data.agent.CongenitalAnomaliesDetail;
import com.iemr.mcts.repository.agent.CongenitalAnomaliesRepository;

@Service
public class CongenitalAnomaliesServiceImpl implements CongenitalAnomaliesService {

	/**
	 * CongenitalAnomalies Repository
	 */
	private CongenitalAnomaliesRepository congenitalAnomaliesRepository;
	
	/**
	 * Inject CongenitalAnomalies Repository
	 */
	@Autowired
	public void setCongenitalAnomaliesRepository(CongenitalAnomaliesRepository congenitalAnomaliesRepository){
		
		this.congenitalAnomaliesRepository = congenitalAnomaliesRepository;
	}
	
	@Override
	public String getCongenitalAnomalies() {
		
		CongenitalAnomaliesDetail det = new CongenitalAnomaliesDetail(0,"Other");
		List<CongenitalAnomaliesDetail>  congenitalAnomaliesDetails = congenitalAnomaliesRepository.getCongenitalAnomalies();
		congenitalAnomaliesDetails.add(det);
		return congenitalAnomaliesDetails.toString();
	}

}
