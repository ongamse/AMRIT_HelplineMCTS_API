package com.iemr.mcts.model.user;

import java.sql.Timestamp;
import java.util.List;

import lombok.Data;

public @Data class Screen
{
	private Integer screenID;
	private List<ServiceRoleScreenMappingModel> serviceRoleScreenMappingModels;
	private String screenName;
	private String apiUsed;
	private String workflowName;
	private String screenDesc;
	private Integer providerServiceMapID;
	private ProviderServiceMappingModel providerServiceMappingModel;
	private Boolean deleted;
	private String createdBy;
	private Timestamp createdDate;
	private String modifiedBy;
	private Timestamp lastModDate;
}
