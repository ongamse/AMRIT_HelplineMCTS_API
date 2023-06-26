package com.iemr.mcts.model.beneficiary;

import java.sql.Timestamp;
import java.util.List;

import lombok.Data;

public @Data class BeneficiaryIncomeStatusModel
{
	private Integer incomeStatusID;
	private List<BeneficiaryDemographicsModel> beneficiariesDemographics;
	private String incomeStatus;
	private Boolean deleted;
	private String createdBy;
	private Timestamp createdDate;
	private String modifiedBy;
	private Timestamp lastModDate;
}
