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

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iemr.mcts.data.agent.FeedbackDetail;
import com.iemr.mcts.repository.agent.FeedbackRepository;
import com.iemr.mcts.utils.exception.IEMRException;
import com.iemr.mcts.utils.mapper.InputMapper;

@Service
public class FeedbackServiceImpl implements FeedbackService {

	/**
	 * Feedback repository
	 */
	private FeedbackRepository feedbackRepository;
	
	/**
	 * set feedback repository
	 * @param feedbackRepository
	 */
	@Autowired
	public void setFeedbackRepository(FeedbackRepository feedbackRepository){
		
		this.feedbackRepository = feedbackRepository;
	}
	
	/*
	 * (non-Javadoc)
	 * @see com.iemr.mcts.services.agent.FeedBackService#getFeedBackList(java.lang.String)
	 */
	@Override
	public String getFeedBackList(String request) throws IEMRException {
		
		FeedbackDetail feedbackDetail = InputMapper.gson().fromJson(request, FeedbackDetail.class);
		
		return feedbackRepository.getBenificiaryComplaintList
				(feedbackDetail.getBeneficiaryRegID()).toString();
	}

}
