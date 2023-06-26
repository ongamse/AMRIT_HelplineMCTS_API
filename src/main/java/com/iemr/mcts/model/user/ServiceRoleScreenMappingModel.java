package com.iemr.mcts.model.user;

import java.sql.Timestamp;

import lombok.Data;

public @Data class ServiceRoleScreenMappingModel
{
	private Integer srsMappingID;// int(11) NO PRI auto_increment
	private Integer screenID;// int(11) YES MUL
	private Screen screen;
	private Integer providerServiceMapID;
	private ProviderServiceMappingModel providerServiceMappingModel;
	private Integer roleID;
	private Role role;
	private Boolean deleted;
	private String createdBy;
	private Timestamp createdDate;
	private String modifiedBy;
	private Timestamp lastModDate;
}
