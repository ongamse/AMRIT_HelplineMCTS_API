package com.iemr.mcts.services.agent;

import java.util.List;

import com.iemr.mcts.data.agent.MotherValidRecordDetail;



public interface MotherStageDetailsService {
	
	List<MotherValidRecordDetail> getMotherDetails(Long mCTSIDNo);
	MotherValidRecordDetail saveMotherDetails(MotherValidRecordDetail motherStageDetails);	

}
