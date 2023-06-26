package com.iemr.mcts.model.beneficiary;

import java.math.BigInteger;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;

import com.iemr.mcts.data.domain.BenFamilyDTO;
import com.iemr.mcts.data.domain.Phone;
import com.iemr.mcts.model.userbeneficiary.PhoneTypeModel;
import com.iemr.mcts.services.agent.MctsIdentityService;

import lombok.Data;

public @Data class BenPhoneMapModel {
	private Long benPhMapID;
	private Long benificiaryRegID;
	// private BeneficiaryModel beneficiaryModel;
	private Long parentBenRegID;
	// private BeneficiaryModel parentBeneficiary;
	private Integer benRelationshipID;
	private BenRelationshipTypeModel benRelationshipType;
	private String phoneNo;
	private Integer phoneTypeID;
	private String phoneTypeName;
	private PhoneTypeModel phoneType;
	private Boolean deleted;
	private String createdBy;
	private Timestamp createdDate;
	private String modifiedBy;
	private Timestamp lastModDate;
	// private Integer nuisanceCallCount = 0;

	private static MctsIdentityService mctsIdentityService;

	@Autowired
	private MctsIdentityService identityService;

	@PostConstruct
	private void init() {
		mctsIdentityService = this.identityService;
	}

	public static BenPhoneMapModel createBenPhoneMap(Long benPhMapID, Long benificiaryRegID, Long parentBenRegID,
			Integer benRelationshipID, String phoneNo) {
		BenPhoneMapModel model = new BenPhoneMapModel();
		model.benPhMapID = benPhMapID;
		model.benificiaryRegID = benificiaryRegID;
		model.parentBenRegID = parentBenRegID;
		model.benRelationshipID = benRelationshipID;
		model.phoneNo = phoneNo;
		return model;
	}

	public static List<BenPhoneMapModel> createBenPhoneMaps(List<BenFamilyDTO> familyMembers, List<Phone> phones,
			BigInteger benificiaryRegID) {
		List<BenPhoneMapModel> models = new ArrayList<BenPhoneMapModel>();
		if (phones != null) {
			for (BenFamilyDTO benFamilyDTO : familyMembers) {
				for (int phoneIdx = 0; phones.size() > phoneIdx; phoneIdx++) {
					BenPhoneMapModel model = new BenPhoneMapModel();
					Phone phone = phones.get(phoneIdx);
					model.benPhMapID = Long.parseLong(benFamilyDTO.getBenFamilyMapId().toString());
					model.benificiaryRegID = Long.parseLong(benificiaryRegID.toString());
					if (benFamilyDTO.getAssociatedBenRegId() != null) {
						model.parentBenRegID = Long.parseLong(benFamilyDTO.getAssociatedBenRegId().toString());
					}
					model.benRelationshipID = benFamilyDTO.getRelationshipID();
					model.phoneNo = phone.getPhoneNum();
					models.add(model);
				}
			}
		}

		return models;
	}

	public static List<BenPhoneMapModel> getBenPhoneMapModelList(String phoneNoOfWhom, String whomPhoneNo, String CreatedBy) {
		List<BenPhoneMapModel> list = new ArrayList<BenPhoneMapModel>();
		BenPhoneMapModel model = new BenPhoneMapModel();
		if (phoneNoOfWhom.equalsIgnoreCase("self")) {

			model.benRelationshipID = 1;
		} 
		model.phoneTypeName = phoneNoOfWhom;
		model.phoneNo = whomPhoneNo;
		model.createdBy = CreatedBy;
		list.add(model);
		return list;
	}

	public static List<BenPhoneMapModel> getBenPhoneMapModelList(String contactNumber) {
		List<BenPhoneMapModel> list = new ArrayList<BenPhoneMapModel>();
		BenPhoneMapModel model = new BenPhoneMapModel();
		model.phoneNo = contactNumber;
		list.add(model);
		return list;
	}
}
