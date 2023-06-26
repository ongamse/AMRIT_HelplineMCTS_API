package com.iemr.mcts.model.user;

import java.util.List;

import com.iemr.mcts.model.beneficiary.BeneficiaryModel;

import lombok.Data;

public @Data class Title
{
	private Integer titleID;
	private List<UserModel> m_user;
	private List<BeneficiaryModel> i_beneficiary;
	private String titleName;
	private String titleDesc;
//	private Boolean deleted;
//	private String createdBy;
//	private Timestamp createdDate;
//	private String modifiedBy;
//	private Timestamp lastModDate;
}
