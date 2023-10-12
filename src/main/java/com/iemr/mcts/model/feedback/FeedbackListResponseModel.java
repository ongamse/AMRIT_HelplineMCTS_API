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
package com.iemr.mcts.model.feedback;

import java.sql.Timestamp;
import java.util.List;

import com.iemr.mcts.model.beneficiary.BeneficiaryModel;
import com.iemr.mcts.model.institute.Institute;
import com.iemr.mcts.model.institute.InstituteType;
import com.iemr.mcts.model.user.ProviderServiceMappingModel;
import com.iemr.mcts.model.user.UserModel;
import com.iemr.mcts.model.userbeneficiary.DesignationModel;
import com.iemr.mcts.model.userbeneficiary.District;
import com.iemr.mcts.model.userbeneficiary.DistrictBlock;
import com.iemr.mcts.model.userbeneficiary.DistrictBranchMapping;
import com.iemr.mcts.model.userbeneficiary.EmailStatus;
import com.iemr.mcts.model.userbeneficiary.StateModel;

import lombok.Data;

@Data
public class FeedbackListResponseModel
{
	private Long feedbackID;
	private List<FeedbackRequestModel> feedbackRequests;
	private List<FeedbackResponseModel> feedbackResponses;
	private List<FeedbackRequestModel> consolidatedRequests;
	private Long institutionID;
	private Institute institute;
	private String instituteName = "";
	private Integer designationID;
	private DesignationModel designation;
	private String designationName = "";
	private Integer severityID;
	private FeedbackSeverity severity;
	private String severityTypeName = "";
	private Integer feedbackTypeID;
	private FeedbackType feedbackType;
	private String feedbackTypeName = "";
	private Long beneficiaryRegID;
	private BeneficiaryModel beneficiary;
	private String beneficiaryName;
	private Integer serviceID;
	private ProviderServiceMappingModel mservicemaster;
	private String serviceName = "";
	private Integer userID;
	private UserModel mUser;
	private String userName;
	private String sMSPhoneNo;
	private Timestamp serviceAvailDate;
	private Boolean deleted;
	private String createdBy;
	private Timestamp createdDate;
	private String modifiedBy;
	private Timestamp lastModDate;
	private Integer feedbackStatusID;
	private FeedbackStatus feedbackStatus;
	private String feedbackStatusName;
	private String feedback;
	private Integer emailStatusID;
	private EmailStatus emailStatus;
	private String emailStatusName;
	private Long benCallID;
	private Integer subServiceID;
	private Integer stateID;
	private StateModel state;
	private Integer districtID;
	private District district;
	private Integer blockID;
	private DistrictBlock districtBlock;
	private Integer districtBranchID;
	private DistrictBranchMapping districtBranchMapping;
	private Integer instituteTypeID;
	private InstituteType instituteType;
	private Integer feedbackNatureID;
	private FeedbackNatureDetail feedbackNatureDetail;
}
