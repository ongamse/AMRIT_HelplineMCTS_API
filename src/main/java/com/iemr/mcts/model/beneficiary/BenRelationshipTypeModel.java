package com.iemr.mcts.model.beneficiary;

import java.sql.Timestamp;
import java.util.List;

import lombok.Data;

public @Data class BenRelationshipTypeModel
{
	private Integer benRelationshipID;
	private List<BenPhoneMapModel> benPhoneMapModel;
	private String benRelationshipType;
	private Boolean deleted;
	private String createdBy;
	private Timestamp createdDate;
	private String modifiedBy;
	private Timestamp lastModDate;
}
