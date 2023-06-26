package com.iemr.mcts.model.userbeneficiary;

import java.sql.Timestamp;
import java.util.List;

import com.iemr.mcts.model.beneficiary.BeneficiaryDemographicsModel;
import com.iemr.mcts.model.institute.Institute;

import lombok.Data;

public @Data class DistrictBlock
{
	private Integer blockID;
	private List<BeneficiaryDemographicsModel> beneficiariesDemographics;
	private List<Institute> institutes;
	private Integer districtID;
	private String blockName;
	private Integer stateID;
	private Boolean deleted;
	private String createdBy;
	private Timestamp createdDate;
	private String modifiedBy;
	private Timestamp lastModDate;
}
