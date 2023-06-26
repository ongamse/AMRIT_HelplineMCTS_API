package com.iemr.mcts.transport;

import com.iemr.mcts.data.supervisor.MctsOutboundCall;
import com.iemr.mcts.model.beneficiary.BeneficiarySearchModal;

import lombok.Data;

@Data
public class IdentityTransport {

	private MctsOutboundCall mctsOutboundCall;
	
	private BeneficiarySearchModal beneficiarySearchModal;
}
