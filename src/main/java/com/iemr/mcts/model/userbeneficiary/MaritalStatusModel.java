package com.iemr.mcts.model.userbeneficiary;

import java.sql.Timestamp;
import java.util.List;

import com.iemr.mcts.model.beneficiary.BeneficiaryModel;
import com.iemr.mcts.model.user.UserModel;

import lombok.Data;

public @Data class MaritalStatusModel
{
	private Integer maritalStatusID;
	private List<BeneficiaryModel> i_beneficiary;
	private List<UserModel> m_user;
	private String status;
	private String statusDesc;
	private Boolean deleted;
	private String createdBy;
	private Timestamp createdDate;
	private String modifiedBy;
	private Timestamp lastModDate;
	

}
