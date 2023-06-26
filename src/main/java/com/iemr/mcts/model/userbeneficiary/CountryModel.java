package com.iemr.mcts.model.userbeneficiary;

import java.sql.Timestamp;
import java.util.List;

import com.iemr.mcts.model.beneficiary.BeneficiaryDemographicsModel;
import com.iemr.mcts.model.user.UserDemographicsModel;

import lombok.Data;

public @Data class CountryModel
{
	private Integer countryID;
	private List<BeneficiaryDemographicsModel> i_bendemographics;
	private List<UserDemographicsModel> m_userdemographics;
	private String countryName;
	private String countryCode;
	private String continent;
	private Boolean deleted;
	private String createdBy;
	private Timestamp createdDate;
	private String modifiedBy;
	private Timestamp lastModDate;
}