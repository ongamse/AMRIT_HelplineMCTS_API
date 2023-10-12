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
