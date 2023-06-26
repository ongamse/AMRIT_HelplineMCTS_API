package com.iemr.mcts.model.user;

import java.sql.Timestamp;

import lombok.Data;

public @Data class SubService
{
	private Integer subServiceID;
	private Integer providerServiceMapID;
	private ProviderServiceMappingModel service;
	private String subServiceName;
	private String subServiceDesc;
	private Boolean deleted;
	private String createdBy;
	private Timestamp createdDate;
	private String modifiedBy;
	private Timestamp lastModDate;
}
