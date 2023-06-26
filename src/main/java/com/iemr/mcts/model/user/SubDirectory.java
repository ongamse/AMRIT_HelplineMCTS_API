package com.iemr.mcts.model.user;

import java.sql.Timestamp;
import java.util.List;

import com.iemr.mcts.model.institute.InstituteDirectoryMapping;

import lombok.Data;

public @Data class SubDirectory
{
	private Integer instituteSubDirectoryID;
	private List<InstituteDirectoryMapping> instituteDirectoryMappings;
	private Integer instituteDirectoryID;
	private String instituteSubDirectoryName;
	private String instituteSubDirectoryDesc;
	private Boolean deleted;
	private String createdBy;
	private Timestamp createdDate;
	private String modifiedBy;
	private Timestamp lastModDate;
}
