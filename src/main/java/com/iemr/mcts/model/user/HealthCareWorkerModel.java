package com.iemr.mcts.model.user;

import java.sql.Timestamp;

import lombok.Data;

public @Data class HealthCareWorkerModel
{
	private Short healthCareWorkerID;
	private String healthCareWorkerType;
	private String healthCareWorkerDesc;
	private Boolean deleted;
	private String createdBy;
	private Timestamp createdDate;
	private String modifiedBy;
	private Timestamp lastModDate;
}
