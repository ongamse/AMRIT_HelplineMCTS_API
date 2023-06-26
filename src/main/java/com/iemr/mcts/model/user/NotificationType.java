package com.iemr.mcts.model.user;

import java.sql.Timestamp;
import java.util.List;

import com.iemr.mcts.model.userbeneficiary.EmergencyContacts;

import lombok.Data;

public @Data class NotificationType
{
	private Integer notificationTypeID;
	private List<NotificationModel> notificationModels;
	private List<EmergencyContacts> emergencyContacts;
	private String notificationType;
	private String notificationTypeDesc;
	private Integer providerServiceMapID;
	private Boolean deleted;
	private String createdBy;
	private Timestamp createdDate;
	private String modifiedBy;
	private Timestamp lastModDate;
}
