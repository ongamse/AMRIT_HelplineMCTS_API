package com.iemr.mcts.model.beneficiary;

import java.util.List;

import lombok.Data;

public @Data class BeneficiaryEducationModel
{
	private Long educationID;
	private List<BeneficiaryDemographicsModel> beneficiaryDemographicsModel;
	private String educationType;
	private Boolean deleted;
	private String createdBy;
	private String modifiedBy;
}
