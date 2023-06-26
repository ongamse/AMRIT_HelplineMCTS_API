package com.iemr.mcts.data.mapper;

import org.springframework.beans.factory.annotation.Autowired;

import com.iemr.mcts.data.domain.GovtIdentityType;
import com.iemr.mcts.data.domain.Identity;
import com.iemr.mcts.repository.supervisor.IdentityProofRepository;

public abstract class IdentityProofMapperDecorator implements IdentityProofMapper {

	@Autowired
	IdentityProofRepository identityProofRepository;

	@Override
	public Identity getProofDetail(String aadharNo) {
		Identity identities = null;
		if (aadharNo != null && !aadharNo.equals(" ")) {
			GovtIdentityType govtIdentityType = identityProofRepository.findIdentityProofbyName("Aadhar");
			if (govtIdentityType != null) {
				identities = new Identity();
				identities.setIdentityName(govtIdentityType.getIdentityType()); 
				identities.setIdentityNameId(govtIdentityType.getGovtIdentityTypeID());
			}
		}
		return identities;
	}

}
