package com.iemr.mcts.model.user;

import java.sql.Timestamp;
import java.util.List;

import lombok.Data;

public @Data class WorkLocation
{
	private Integer psAddMapID;
	private List<NotificationModel> notificationModels;
	private Integer providerServiceMapID;
	private Integer districtID;
	private Boolean deleted;
	private String locationName;
	private String address;
	private String processed;
	private String CreatedBy;
	private String ModifiedBy;
	private Timestamp CreatedDate;
	private Timestamp lastModDate;
}
