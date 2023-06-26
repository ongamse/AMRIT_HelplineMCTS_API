package com.iemr.mcts.model.userbeneficiary;

import java.util.List;

import com.iemr.mcts.model.beneficiary.BenPhoneMapModel;

import lombok.Data;

public @Data class PhoneTypeModel
{
	private Integer phoneTypeID;
	private List<BenPhoneMapModel> benPhoneMapModel;
	private String phoneType;
	// private Boolean deleted;
	// private String createdBy;
	// private Timestamp createdDate;
	// private String modifiedBy;
	// private Timestamp lastModDate;
}
