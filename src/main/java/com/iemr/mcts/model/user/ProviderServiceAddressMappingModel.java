package com.iemr.mcts.model.user;

import java.sql.Date;
import java.util.List;

import lombok.Data;

public @Data class ProviderServiceAddressMappingModel
{
	private Integer pSAddMapID;
	private List<UserServiceRoleMappingModel> userServiceRoleMappingModels;
	private Integer providerServiceMapID;
	private Integer districtID;
	private String address;
	private Boolean deleted;
	private String createdBy;
	private Date createdDate;
	private String modifiedBy;
	private Date lastModDate;
	private String locationName;
}
