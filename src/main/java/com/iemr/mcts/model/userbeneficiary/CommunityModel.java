package com.iemr.mcts.model.userbeneficiary;

import java.util.List;

import com.iemr.mcts.model.beneficiary.BeneficiaryDemographicsModel;
import com.iemr.mcts.model.user.UserDemographicsModel;

import lombok.Data;

public @Data class CommunityModel
{
	private Integer communityID;
	private List<BeneficiaryDemographicsModel> beneficiariesDemographics;
	private List<UserDemographicsModel> usersDemographics;
	private String communityType;
	private String communityDesc;
//	private Boolean deleted;
//	private String createdBy;
//	private Timestamp createdDate;
//	private String modifiedBy;
//	private Timestamp lastModDate;
}
