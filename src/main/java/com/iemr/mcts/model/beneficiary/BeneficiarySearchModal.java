package com.iemr.mcts.model.beneficiary;

import java.sql.Timestamp;

import lombok.Data;

@Data
public class BeneficiarySearchModal {

	private String outboundCallType;
	private String beneficiaryID;
	private Short titleId;
	private String titleName;
	private String firstName;
	private String middleName;
	private String lastName;
	private Short genderID;
//	private String genderName;
	private Timestamp dOB;
	private String govtIdentityNo;
	private Short govtIdentityTypeID;
	private Integer cityID;
	private String cityName;
	private Integer stateID;
	private String stateName;
	private Integer districtID;
	private String districtName;
	private Integer blockID;
	private String blockName;
	private Integer districtBranchID;
	private String districtBranchName;
	private Integer countryID;
	private String countryName;
	private String pinCode;
	private String contactNumber;
	private String createdBy;
}
