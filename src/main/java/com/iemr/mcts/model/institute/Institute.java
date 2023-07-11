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
package com.iemr.mcts.model.institute;

import java.sql.Timestamp;
import java.util.List;

import com.iemr.mcts.model.feedback.FeedbackDetailsModel;
import com.iemr.mcts.model.userbeneficiary.District;
import com.iemr.mcts.model.userbeneficiary.DistrictBlock;
import com.iemr.mcts.model.userbeneficiary.DistrictBranchMapping;
import com.iemr.mcts.model.userbeneficiary.StateModel;

import lombok.Data;

public @Data class Institute
{
	private Integer institutionID;
	private List<InstituteDirectoryMapping> instituteDirectory;
	private List<FeedbackDetailsModel> feedbackDetailsModel;
	private String institutionName;
	private Integer stateID;
	private StateModel stateModels;
	private Integer districtID;
	private District district;
	private Integer blockID;
	private DistrictBlock districtBlock;
	private Integer districtBranchMappingID;
	private DistrictBranchMapping m_districtbranchmapping;
	private Boolean deleted;
	private String createdBy;
	private Timestamp createdDate;
	private String modifiedBy;
	private Timestamp lastModDate;
	private String govtInstituteID;
	private String address;
	private String contactPerson1;
	private String contactPerson1_Email;
	private String contactNo1;
	private String contactPerson2;
	private String contactPerson2_Email;
	private String contactNo2;
	private String contactPerson3;
	private String contactPerson3_Email;
	private String contactNo3;
	private String website;
	private Integer providerServiceMapID;
}
