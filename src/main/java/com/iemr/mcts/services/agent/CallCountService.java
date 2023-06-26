package com.iemr.mcts.services.agent;

import com.iemr.mcts.data.supervisor.OutboundCallAnsweredCountDetail;

public interface CallCountService {

	String getCallAnsweredCount(OutboundCallAnsweredCountDetail outboundCallReportDetail) throws Exception;
	
	String getCallVerifiedCount(OutboundCallAnsweredCountDetail outboundCallReportDetail) throws Exception;
}
