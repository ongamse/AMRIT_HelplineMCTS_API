package com.iemr.mcts.data.domain;

import java.sql.Date;
import java.util.List;

import lombok.Data;

@Data
public class BeneficiariesDTO 
{
	private Long benMapId; //
	private Long benId;
	private Long benRegId;
	private String createdBy; //
	//private Timestamp createdDate; //
	private Boolean deleted; //
	//private Timestamp lastModDate; //
	private String modifiedBy; //
	private Address currentAddress; //
	private Address permanentAddress; //
	private Address emergencyAddress; //
	private String preferredPhoneNum; //
	private String preferredPhoneTyp; //
	private String preferredSMSPhoneNum; //
	private String preferredSMSPhoneTyp; //
	private String emergencyContactNum; //
	private String emergencyContactTyp; //
	private String preferredEmailId; //
	private BenDetailDTO beneficiaryDetails;
	private List<BenFamilyDTO> beneficiaryFamilyTags;
	private List<BenIdentityDTO> beneficiaryIdentites;
	//private List<BenServiceDTO> beneficiaryServiceMap;
	private List<Phone> contacts;
	
	public static Date setDobOfChild(BeneficiariesDTO beneficiariesDTO) {
		Date date = BenDetailDTO.setDateForBen(beneficiariesDTO.beneficiaryDetails);
		return date;
	}

}
