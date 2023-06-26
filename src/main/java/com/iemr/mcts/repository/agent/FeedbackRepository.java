package com.iemr.mcts.repository.agent;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

import com.iemr.mcts.data.agent.FeedbackDetail;

@Repository
@RestResource(exported = false)
public interface FeedbackRepository extends CrudRepository<FeedbackDetail, Long> {

	@Query("select feedback from FeedbackDetail feedback join feedback.feedbackType "
			+ "join feedback.feedBacknatureDetail join feedback.designation "
			+ "where feedback.beneficiaryRegID = :beneficiaryRegID")
	public ArrayList<FeedbackDetail> getBenificiaryComplaintList(@Param("beneficiaryRegID") Long beneficiaryRegID);
}
