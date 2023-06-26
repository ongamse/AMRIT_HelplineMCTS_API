package com.iemr.mcts.model.beneficiary;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.List;

import com.iemr.mcts.model.user.Title;
import com.iemr.mcts.model.userbeneficiary.GenderModel;
import com.iemr.mcts.model.userbeneficiary.GovtIdentityType;
import com.iemr.mcts.model.userbeneficiary.MaritalStatusModel;
import com.iemr.mcts.model.userbeneficiary.SexualOrientationModel;
import com.iemr.mcts.model.userbeneficiary.Status;

import lombok.Data;

@Data
public class UpdateBeneficiaryModel {
	
	private Long beneficiaryRegID;
	private UpdateBenDemographicsModel i_bendemographics;
	private List<BenPhoneMapModel> benPhoneMaps;
	private List<BenPhoneMapModel> parentBenPhoneMaps;
	private String beneficiaryID;
	private Short titleId;
	private String titleName;
	private Title m_title;
	private String firstName;
	private String middleName;
	private String lastName;
	private Short statusID;
	private String statusName;
	private Status status;
	private Integer genderID;
	private String genderName;
	private GenderModel m_gender;
	private Short maritalStatusID;
	private String maritalStatusName;
	private MaritalStatusModel maritalStatusModel;
	private Short sexualOrientationId;
	private SexualOrientationModel sexualOrientationModel;
	private Timestamp dOB;
	private Integer age;
	private String fatherName;
	private String motherName;// newly added
	private String spouseName;
	private SimpleDateFormat formatYear/* = new SimpleDateFormat("yyyy") */;
	private String govtIdentityNo;
	private Short govtIdentityTypeID;
	private GovtIdentityType govtIdentityType;
	private Short registeredServiceID;
	private String sourceOfInformation;
	private Boolean deleted;
	private String createdBy;
	private Timestamp createdDate;
	private String modifiedBy;
	private Boolean isHIVPos;
	private String placeOfWork;
	private String remarks;
	private List<BeneficiaryIdentityModel> beneficiaryIdentities;
	
	//For Data Sync
	private Integer vanID;
	
	private Boolean changeInSelfDetails = false;
	private Boolean changeInAddress = false;
	private Boolean changeInContacts = false;

	public UpdateBeneficiaryModel() {
		
		
	}
	
}
