/*
* AMRIT – Accessible Medical Records via Integrated Technology
* Integrated EHR (Electronic Health Records) Solution
*
* Copyright (C) "Piramal Swasthya Management and Research Institute"
*
* This file is part of AMRIT.
*
* This program is free software: you can redistribute it and/or modify
* it under the terms of the GNU General Public License as published by
* the Free Software Foundation, either version 3 of the License, or
* (at your option) any later version.
*
* This program is distributed in the hope that it will be useful,
* but WITHOUT ANY WARRANTY; without even the implied warranty of
* MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
* GNU General Public License for more details.
*
* You should have received a copy of the GNU General Public License
* along with this program.  If not, see https://www.gnu.org/licenses/.
*/
package com.iemr.mcts.model.user;

import java.sql.Timestamp;
import java.util.List;

import com.iemr.mcts.model.feedback.FeedbackDetailsModel;
import com.iemr.mcts.model.userbeneficiary.DesignationModel;
import com.iemr.mcts.model.userbeneficiary.GenderModel;
import com.iemr.mcts.model.userbeneficiary.MaritalStatusModel;
import com.iemr.mcts.model.userbeneficiary.Status;

import lombok.Data;

public @Data class LoginResponseModel
{
	private Long userID;
	private List<UserServiceRoleMappingModel> userServiceRoleMappings;
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
	private GenderModel genderModel;
	private Integer maritalStatusID;
	private MaritalStatusModel maritalstatus;
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
	private DesignationModel designationModel;
	private String agentPassword;
	private String newPassword = null;
	private String loginKey;
	private String ipAddress;
	private String hostName;
}
