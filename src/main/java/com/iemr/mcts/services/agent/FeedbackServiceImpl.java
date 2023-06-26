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
