package com.iemr.mcts.model.beneficiary;

import java.util.List;

import lombok.Data;

public @Data class BeneficiaryOccupationModel
{
	private Long occupationID;
	private List<BeneficiaryDemographicsModel> beneficiaryDemographicsModel;
	private String occupationType;
	private Boolean deleted;
	private String createdby;
	private String modifiedby;
}
