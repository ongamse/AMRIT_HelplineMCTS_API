package com.iemr.mcts.model.institute;

import java.sql.Timestamp;

import com.iemr.mcts.model.user.SubDirectory;
import com.iemr.mcts.model.userbeneficiary.Directory;

import lombok.Data;

public @Data class InstituteDirectoryMapping
{
	private Long instituteDirMapID;
	private Integer institutionID;
	private Institute institute;
	private Integer instituteDirectoryID;
	private Directory directory;
	private Integer instituteSubDirectoryID;
	private SubDirectory subDirectory;
	private Integer instituteRouteDirectoryID;
	private Boolean deleted;
	private String createdBy;
	private Timestamp createdDate;
	private String modifiedBy;
	private Timestamp lastModDate;
}
