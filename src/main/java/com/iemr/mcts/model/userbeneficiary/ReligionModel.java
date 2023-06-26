package com.iemr.mcts.model.userbeneficiary;

import java.sql.Timestamp;
import java.util.Set;

import com.iemr.mcts.model.beneficiary.BeneficiaryDemographicsModel;
import com.iemr.mcts.model.user.UserDemographicsModel;

import lombok.Data;

public @Data class ReligionModel
{
	private Integer religionID;
	private Set<BeneficiaryDemographicsModel> beneficiariesDemographics;
	private Set<UserDemographicsModel> usersDemographics;
	private String religionType;
	private String religionDesc;
	private Boolean deleted;
	private String createdBy;
	private Timestamp createdDate;
	private String modifiedBy;
	private Timestamp lastModDate;
}
