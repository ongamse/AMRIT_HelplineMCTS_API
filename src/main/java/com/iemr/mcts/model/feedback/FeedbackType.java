package com.iemr.mcts.model.feedback;

import java.sql.Timestamp;
import java.util.Set;

import com.iemr.mcts.model.user.ProviderServiceMappingModel;

import lombok.Data;

public @Data class FeedbackType
{
	private Integer feedbackTypeID;
	private Set<FeedbackDetailsModel> feedbacks;
	private String feedbackTypeName;
	private String feedbackDesc;
	private Boolean deleted;
	private String createdBy;
	private Timestamp createdDate;
	private String modifiedBy;
	private Timestamp lastModDate;
	private Integer providerServiceMapID;
	private ProviderServiceMappingModel providerServiceMappingModel;
}
