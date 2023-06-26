package com.iemr.mcts.model.userbeneficiary;

import java.sql.Timestamp;
import java.util.Set;

import com.iemr.mcts.model.beneficiary.BeneficiaryDemographicsModel;

import lombok.Data;

public @Data class CityModel
{
	private Integer cityID;
	private Set<BeneficiaryDemographicsModel> beneficiariesDemographics;
	private String cityName;
	private Integer districtID;
	private Integer stateID;
	private Boolean deleted;
	private String createdBy;
	private Timestamp createdDate;
	private String modifiedBy;
	private Timestamp lastModDate;
}
