package com.iemr.mcts.model.userbeneficiary;

import java.util.List;

import com.iemr.mcts.model.beneficiary.BeneficiaryModel;
import com.iemr.mcts.model.user.UserModel;

import lombok.Data;

public @Data class GenderModel
{
	private Short genderID;
	private List<BeneficiaryModel> i_beneficiary;
	private List<UserModel> m_user;
	private String genderName;
}
