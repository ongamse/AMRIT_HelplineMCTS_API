package com.iemr.mcts.model.beneficiary;

import java.util.ArrayList;
import java.util.List;

import com.iemr.mcts.data.domain.BenIdentityDTO;

import lombok.Data;

@Data
public class BeneficiaryIdentityModel
{
	private GovtIdentityTypeModel govtIdentityType;
	private String govtIdentityNo;
	private Integer govtIdentityTypeID;

	public static List<BeneficiaryIdentityModel> createBeneficiaryIdentities(List<BenIdentityDTO> benIdentityDTOList)
	{
		List<BeneficiaryIdentityModel> beneficiaryIdentities = null;
		if (benIdentityDTOList != null)
		{
			beneficiaryIdentities = new ArrayList<BeneficiaryIdentityModel>();
			for (BenIdentityDTO benIdentityDTO : benIdentityDTOList)
			{
				BeneficiaryIdentityModel beneficiary = new BeneficiaryIdentityModel();
				beneficiary.setGovtIdentityNo(benIdentityDTO.getIdentityNo());
				beneficiary.setGovtIdentityTypeID(benIdentityDTO.getIdentityTypeId());
				beneficiary.setGovtIdentityType(GovtIdentityTypeModel.createGovtIdentity(benIdentityDTO));
				beneficiaryIdentities.add(beneficiary);
			}
		}
		return beneficiaryIdentities;
	}
}
