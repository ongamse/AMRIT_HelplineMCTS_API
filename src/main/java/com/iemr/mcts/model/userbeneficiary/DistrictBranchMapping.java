package com.iemr.mcts.model.userbeneficiary;

import java.sql.Timestamp;
import java.util.Set;

import com.iemr.mcts.model.beneficiary.BeneficiaryDemographicsModel;

import lombok.Data;

public @Data class DistrictBranchMapping
{
	private Integer districtBranchID;
	private Set<BeneficiaryDemographicsModel> beneficiariesDemographics;
	private Integer blockID;
	private String panchayatName;
	private String villageName;
	private String habitat;
	private String pinCode;
	private Boolean deleted;
	private String createdBy;
	private Timestamp createdDate;
	private String modifiedBy;
	private Timestamp lastModDate;
}
