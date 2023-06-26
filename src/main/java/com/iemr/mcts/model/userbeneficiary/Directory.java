package com.iemr.mcts.model.userbeneficiary;

import java.sql.Timestamp;
import java.util.List;

import com.iemr.mcts.model.institute.InstituteDirectoryMapping;
import com.iemr.mcts.model.user.ProviderServiceMappingModel;

import lombok.Data;

public @Data class Directory
{
	private Integer instituteDirectoryID;
	private List<InstituteDirectoryMapping> instituteDirectoryMappings;
	private String instituteDirectoryName;
	private String instituteDirectoryDesc;
	private Boolean deleted;
	private String createdBy;
	private Timestamp createdDate;
	private String modifiedBy;
	private Timestamp lastModDate;
	private Integer providerServiceMapID;
	private ProviderServiceMappingModel providerServiceMappingModel;
}
