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
