package com.iemr.mcts.model.institute;

import java.sql.Date;

import lombok.Data;

public @Data class InstituteType
{
	private Integer institutionTypeID;
	private String institutionType;
	private String institutionTypeDesc;
	private Integer providerServiceMapID;
	private Boolean deleted;
	private String createdBy;
	private Date createdDate;
	private String modifiedBy;
	private Date lastModDate;
}
