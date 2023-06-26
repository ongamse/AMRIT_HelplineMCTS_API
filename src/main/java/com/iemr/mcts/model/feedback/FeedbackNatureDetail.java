package com.iemr.mcts.model.feedback;

import java.sql.Date;
import java.util.List;

import lombok.Data;

public @Data class FeedbackNatureDetail
{
	private Integer feedbackNatureID;
	private String feedbackNature;
	private String feedbackNatureDesc;
	private Integer feedbackTypeID;
	private Boolean deleted;
	private String createdBy;
	private Date createdDate;
	private String modifiedBy;
	private Date lastModDate;
	private String feedbackTypeName;
	private List<FeedbackDetailsModel> feedbackDetailsModel;
}
