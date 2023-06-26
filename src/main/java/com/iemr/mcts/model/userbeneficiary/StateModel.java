package com.iemr.mcts.model.userbeneficiary;

import java.sql.Timestamp;
import java.util.Set;

//import com.iemr.common.data.location.Districts;
import com.iemr.mcts.model.beneficiary.BeneficiaryDemographicsModel;
import com.iemr.mcts.model.institute.Institute;

import lombok.Data;

public @Data class StateModel
{
	private Integer stateID;
	private Set<BeneficiaryDemographicsModel> beneficiariesDemographics;
	private String stateName;
	private String stateCode;
	private Integer countryID;
	private Boolean deleted;
	private String createdBy;
	private String modifiedBy;
	private Timestamp createdDate;
	private Timestamp lastModDate;
	//private Set<Districts> districts;
	private Set<Institute> institutes;
}
