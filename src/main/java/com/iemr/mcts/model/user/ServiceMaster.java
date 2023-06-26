package com.iemr.mcts.model.user;

import java.sql.Timestamp;
import java.util.List;

import com.iemr.mcts.model.feedback.FeedbackDetailsModel;

import lombok.Data;

public @Data class ServiceMaster
{
	private Integer serviceID;
	private String serviceName;
	private String serviceDesc;
	private Boolean deleted;
	private String createdBy;
	private Timestamp createdDate;
	private String modifiedBy;
	private Timestamp lastModDate;
	private List<UserServiceRoleMappingModel> m_UserServiceRoleMapping;
	private List<SubService> subServices;
	private List<FeedbackDetailsModel> feedbacks;
}
