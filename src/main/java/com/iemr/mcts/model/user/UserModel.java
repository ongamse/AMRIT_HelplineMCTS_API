package com.iemr.mcts.model.user;

import java.sql.Timestamp;
import java.util.List;

import com.iemr.mcts.model.feedback.FeedbackDetailsModel;
import com.iemr.mcts.model.userbeneficiary.DesignationModel;
import com.iemr.mcts.model.userbeneficiary.GenderModel;
import com.iemr.mcts.model.userbeneficiary.MaritalStatusModel;
import com.iemr.mcts.model.userbeneficiary.Status;

import lombok.Data;

public @Data class UserModel
{
	private Long userID;
	private List<UserServiceRoleMappingModel> userServiceRoleMapping;
	private List<OutboundCallRequestModel> outboundCallRequests;
	private List<UserServiceRoleMappingModel> roleMappings;
	private List<UserLangMappingModel> userLangMappings;
	private List<FeedbackDetailsModel> feedbackDetails;
	private Integer titleID;
	private Title title;
	private String firstName;
	private String middleName;
	private String lastName;
	private Integer genderID;
	private GenderModel gender;
	private Integer maritalStatusID;
	private MaritalStatusModel maritalStatus;
	private Integer statusID;
	private Status status;
	private String aadhaarNo;
	private String pAN;
	private Timestamp dOB;
	private Timestamp dOJ;
	private Integer qualificationID;
	private String userName;
	private String password;
	private String emailID;
	private String emergencyContactPerson;
	private String emergencyContactNo;
	private Boolean isSupervisor;
	private Boolean deleted;
	private String createdBy;
	private Timestamp createdDate;
	private String modifiedBy;
	private Timestamp lastModDate;
	private String agentID;
	private Integer designationID;
	private DesignationModel designation;
	private String agentPassword;
	private String newPassword = null;
}
