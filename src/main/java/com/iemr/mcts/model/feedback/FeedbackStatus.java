package com.iemr.mcts.model.feedback;

import java.sql.Timestamp;
import java.util.List;

import lombok.Data;

public @Data class FeedbackStatus
{
	private Integer feedbackStatusID;
	private String feedbackStatus;
	private String feedbackStatusDesc;
	private Boolean deleted;
	private String createdBy;
	private Timestamp createdDate;
	private String modifiedBy;
	private Timestamp lastModDate;
	private Integer providerServiceMapID;
	private List<FeedbackDetailsModel> feedbackDetailsModel;
}
