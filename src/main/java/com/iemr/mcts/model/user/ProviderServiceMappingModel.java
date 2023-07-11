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

import com.iemr.mcts.model.feedback.FeedbackSeverity;
import com.iemr.mcts.model.feedback.FeedbackType;
import com.iemr.mcts.model.userbeneficiary.Directory;
import com.iemr.mcts.model.userbeneficiary.EmergencyContacts;
import com.iemr.mcts.model.userbeneficiary.Status;

import lombok.Data;

public @Data class ProviderServiceMappingModel
{
	private Integer providerServiceMapID;
	private List<UserServiceRoleMappingModel> userServiceRoleMappingModels;
	private List<NotificationModel> notificationModels;
	private List<ServiceRoleScreenMappingModel> serviceRoleScreenMappingModel;
	private List<Screen> screens;
	private List<Directory> directories;
	private List<FeedbackType> feedbacks;
	private List<FeedbackSeverity> feedbackSeverities;
	private List<EmergencyContacts> emergencyContacts;
	private List<PhoneBlock> blockNumbers;
	private Short serviceProviderID;
	private ServiceProvider serviceProvider;
	private Short serviceID;
	private ServiceMaster ServiceMaster;
	private Integer countryID;
	private Integer stateID;
	private Integer districtID;
	private Integer cityID;
	private Integer districtBlockID;
	private String address;
	private Boolean deleted;
	private String createdBy;
	private Timestamp createdDate;
	private String modifiedBy;
	private Timestamp lastModDate;
	private String ctiCampaignName;
	private Integer statusID;
	private Status status;
}
