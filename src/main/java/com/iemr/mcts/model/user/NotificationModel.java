package com.iemr.mcts.model.user;

import java.sql.Timestamp;
import java.util.List;

import com.iemr.mcts.model.userbeneficiary.Language;

import lombok.Data;

public @Data class NotificationModel
{
	private Integer notificationID;
	private String notification;
	private String notificationDesc;
	private Integer notificationTypeID;
	private NotificationType notificationType;
	private Integer roleID;
	private Role role;
	private Integer providerServiceMapID;
	private ProviderServiceMappingModel providerServiceMappingModel;
	private Timestamp validTill;
	private Timestamp validFrom;
	private Boolean deleted;
	private String createdBy;
	private Timestamp createdDate;
	private String modifiedBy;
	private Timestamp lastModDate;
	private Integer kmFileManagerID;
	private KMFileManagerModel kmFileManager;
	private Integer workingLocationID;
	private WorkLocation workingLocation;
	private List<Integer> workingLocationIDs;
	private Integer languageID;
	private Language language;
	private List<Integer> languageIDs;
	private Integer userID;
	private UserModel user;
	private List<Integer> userIDs;
	private Timestamp validStartDate;
	private Timestamp validEndDate;
	private String kmFilePath;
}
