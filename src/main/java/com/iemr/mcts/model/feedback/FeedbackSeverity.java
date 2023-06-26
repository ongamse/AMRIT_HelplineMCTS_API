package com.iemr.mcts.model.feedback;

import java.sql.Timestamp;
import java.util.Set;

import com.iemr.mcts.model.user.ProviderServiceMappingModel;

import lombok.Data;

public @Data class FeedbackSeverity
{
	private Integer severityID;
	private Set<FeedbackDetailsModel> feedbacks;
	private String severityTypeName;
	private String severityDesc;
	private Boolean deleted;
	private String createdBy;
	private Timestamp createdDate;
	private String modifiedBy;
	private Timestamp lastModDate;
	private Integer providerServiceMapID;
	private ProviderServiceMappingModel providerServiceMappingModel;
}
