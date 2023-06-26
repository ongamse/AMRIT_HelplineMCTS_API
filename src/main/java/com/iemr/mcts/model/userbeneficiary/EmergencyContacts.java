package com.iemr.mcts.model.userbeneficiary;

import java.sql.Timestamp;

import com.iemr.mcts.model.user.NotificationType;
import com.iemr.mcts.model.user.ProviderServiceMappingModel;

import lombok.Data;

public @Data class EmergencyContacts
{
	private Integer emergContactID;
	private Integer designationID;
	private DesignationModel designationModel;
	private String emergContactName;
	private String emergContactNo;
	private String emergContactDesc;
	private String location;
	private Integer providerServiceMapID;
	private ProviderServiceMappingModel providerServiceMappingModel;
	private Integer notificationTypeID;
	private NotificationType notificationType;
	private Boolean deleted;
	private String processed;
	private String createdBy;
	private Timestamp createdDate;
	private String modifiedBy;
	private Timestamp lastModDate;
}
