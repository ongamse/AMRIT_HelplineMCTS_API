package com.iemr.mcts.model.user;

import java.sql.Timestamp;

import com.iemr.mcts.model.userbeneficiary.Status;

import lombok.Data;

public @Data class UserServiceRoleMappingModel
{
	private Long usrMappingID;
	private Long userID;
	private UserModel user;
	private Integer roleID;
	private Role role;
	private Integer serviceID;
	private Boolean deleted;
	private String createdBy;
	private Timestamp createdDate;
	private String modifiedBy;
	private Timestamp lastModDate;
	private Integer providerServiceMapID;
	private ProviderServiceMappingModel providerServiceMapping;
	private String agentID;
	private String agentPassword;
	private Integer statusID;
	private Status status;
	private Integer workingLocationID;
	private ProviderServiceAddressMappingModel providerServiceAddressMapping;
	private String languageName;
}
