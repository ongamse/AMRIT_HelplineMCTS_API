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
