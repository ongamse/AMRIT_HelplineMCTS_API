package com.iemr.mcts.model.feedback;

import java.sql.Timestamp;

import com.iemr.mcts.model.user.KMFileManagerModel;
import com.iemr.mcts.model.userbeneficiary.EmailStatus;

import lombok.Data;

public @Data class FeedbackRequestModel
{
	private Long feedbackRequestID;
	private Long feedbackID;
	private FeedbackDetailsModel feedbackDetailsModel;
	private String feedbackSupSummary;
	private Integer supUserID;
	private String comments;
	private Integer emailStatusID;
	private EmailStatus emailStatus;
	private Boolean deleted;
	private String createdBy;
	private Timestamp createdDate;
	private String modifiedBy;
	private Timestamp lastModDate;
	private Integer feedbackStatusID;
	private String responseSummary;
	private String responseComments;
	private String responseUpdatedBy;
	private Timestamp responseDate;
	private KMFileManagerModel kmFileManager;
	private String attachmentPath;
}
