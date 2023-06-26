package com.iemr.mcts.model.beneficiary;

import java.sql.Timestamp;

import com.iemr.mcts.model.userbeneficiary.GenderModel;

import lombok.Data;

@Data
public class BeneficiaryModel104
{
	private Long beneficiaryRegID;
	private String firstName;
	private String middleName;
	private String lastName;
	private GenderModel m_gender;
	private Timestamp dOB;
}
