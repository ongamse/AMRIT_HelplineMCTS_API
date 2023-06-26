package com.iemr.mcts.model.beneficiary;

import java.sql.Date;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.List;

import com.iemr.mcts.model.user.Title;
import com.iemr.mcts.model.userbeneficiary.GenderModel;
import com.iemr.mcts.model.userbeneficiary.GovtIdentityType;
import com.iemr.mcts.model.userbeneficiary.MaritalStatusModel;
import com.iemr.mcts.model.userbeneficiary.SexualOrientationModel;
import com.iemr.mcts.model.userbeneficiary.Status;

import lombok.Data;

@Data
public class BeneficiaryModel
{
	
	private Long beneficiaryRegID;
	private BeneficiaryDemographicsModel i_bendemographics;
	// private List<BenMedHistoryModel> t_benmedhistory;
	private List<BenPhoneMapModel> benPhoneMaps;
	private List<BenPhoneMapModel> parentBenPhoneMaps;
	// private List<OutboundCallRequestModel> outboundCallRequests;
	// private List<BeneficiaryCallModel> beneficiaryCalls;
	// private List<FeedbackDetailsModel> feedbacks;
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
	private Short genderID;
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
	//private Timestamp lastModDate;
	private Boolean isHIVPos;
	private String placeOfWork;
	private String remarks;
	private Long providerServiceMapID;
	private List<BeneficiaryIdentityModel> beneficiaryIdentities;
	
	//For Data Sync
	private Integer vanID;
	
	private Integer actualAge;

	public BeneficiaryModel() {
		
		
	}
	
	public static Date getJavaSqlData(Timestamp timestamp)
	{
		if(timestamp!=null) {
		LocalDateTime ld = timestamp.toLocalDateTime();
		return Date.valueOf(ld.toLocalDate());}
		
		else {
			
			Date d = null;
			
			return d;
		}
	}
}
