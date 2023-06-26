package com.iemr.mcts.model.userbeneficiary;

import java.sql.Timestamp;
import java.util.List;

import com.iemr.mcts.model.feedback.FeedbackDetailsModel;
import com.iemr.mcts.model.feedback.FeedbackRequestModel;

import lombok.Data;

public @Data class EmailStatus
{
	private Integer emailStatusID;
	private String emailStatus;
	private String emailStatusDesc;
	private Boolean deleted;
	private String createdBy;
	private Timestamp createdDate;
	private String modifiedBy;
	private Timestamp lastModDate;
	private List<FeedbackDetailsModel> feedbackDetailsModel;
	private List<FeedbackRequestModel> feedbackRequestModels;
}
