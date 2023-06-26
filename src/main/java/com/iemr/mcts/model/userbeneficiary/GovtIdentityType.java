package com.iemr.mcts.model.userbeneficiary;

import java.sql.Timestamp;
import java.util.List;

import com.iemr.mcts.model.beneficiary.BeneficiaryModel;

import lombok.Data;

public @Data class GovtIdentityType
{
	private Integer govtIdentityTypeID;
	private List<BeneficiaryModel> beneficiaryModels;
	private String identityType;
	private Boolean isGovtID;
	private Boolean deleted;
	private String createdBy;
	private Timestamp createdDate;
	private String modifiedBy;
	private Timestamp lastModDate;
}
