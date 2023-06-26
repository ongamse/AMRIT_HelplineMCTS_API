package com.iemr.mcts.model.userbeneficiary;

import java.sql.Timestamp;
import java.util.List;

import com.iemr.mcts.model.beneficiary.BeneficiaryModel;

import lombok.Data;

public @Data class SexualOrientationModel
{
	private Short sexualOrientationId;
	private List<BeneficiaryModel> i_Beneficiaries;
	private String sexualOrientation;
	private String sexualOrientationDesc;
	private Boolean deleted;
	private String createdBy;
	private Timestamp createdDate;
	private String modifiedBy;
	private Timestamp lastModDate;
}
