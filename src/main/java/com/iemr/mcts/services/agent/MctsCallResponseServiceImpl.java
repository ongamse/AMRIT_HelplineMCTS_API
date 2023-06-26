package com.iemr.mcts.services.agent;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iemr.mcts.data.agent.MctsCallResponseDetail;
import com.iemr.mcts.data.agent.MctsOutboundCallDetail;
import com.iemr.mcts.repository.agent.MctsCallResponseRepository;
import com.iemr.mcts.utils.exception.IEMRException;
import com.iemr.mcts.utils.mapper.InputMapper;

@Service
public class MctsCallResponseServiceImpl implements MctsCallResponseService {

	private InputMapper inputMapper = new InputMapper();

	/**
	 * mcts call response repository
	 */
	private MctsCallResponseRepository mctsCallResponseRepository;

	/**
	 * Inject mcts call response reposijtory
	 */
	@Autowired
	public void setMctsCallResponseRepository(MctsCallResponseRepository mctsCallResponseRepository) {

		this.mctsCallResponseRepository = mctsCallResponseRepository;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.iemr.mcts.services.agent.MctsCallResponseService#saveMctsCallResponse(
	 * java.lang.String)
	 */
	@Override
	public String saveMctsCallResponse(String request) throws IEMRException {

		MctsCallResponseDetail[] mctsCallResponseDetails = InputMapper.gson().fromJson(request,
				MctsCallResponseDetail[].class);
		Long mctsCallResponseID = null;
		int answersDeleted = 0, count = 0;
		for (MctsCallResponseDetail detail : mctsCallResponseDetails) {
			
			//updating the previous answers to false;
			if(count == 0) 
				answersDeleted = mctsCallResponseRepository.deletePreviousAnswer(detail.getCallDetailID(),detail.getOutboundCallType());

			// if(detail.getChildID()!=null){

			mctsCallResponseID = mctsCallResponseRepository.isRecordAvail(detail.getCallDetailID(),
					detail.getQuestionID());
			

			if (mctsCallResponseID != null) {

				detail.setMctsCallResponseID(mctsCallResponseID);
				mctsCallResponseRepository.updateMctsCall(detail.getMctsCallResponseID(), detail.getAnswer(),
						detail.getRemarks());
			} else {
				mctsCallResponseRepository.save(detail);
			}
			
			count++;

		}

		return "Response added successfully";
	}

	@Override
	public String getMctsCallResponse(String request) throws IEMRException {

		MctsOutboundCallDetail callDetail = inputMapper.gson().fromJson(request, MctsOutboundCallDetail.class);
		List<MctsCallResponseDetail> callResponseDetails = new ArrayList<MctsCallResponseDetail>();

		// if(callDetail.getOutboundCallType()!=null){
		//
		// callResponseDetails =
		// mctsCallResponseRepository.getMctsCallResponseForOutboundCallType
		// (callDetail.getCallDetailID());
		// }else{

		callResponseDetails = mctsCallResponseRepository.getMctsCallResponse(callDetail.getCallDetailID());
		// }
		return callResponseDetails.toString();
	}

	@Override
	public String updateMctsCallResponse(String request) throws IEMRException {

		MctsCallResponseDetail mctsCallResponseDetail = inputMapper.gson().fromJson(request,
				MctsCallResponseDetail.class);
		mctsCallResponseRepository.updateMctsCall(mctsCallResponseDetail.getMctsCallResponseID(),
				mctsCallResponseDetail.getAnswer(), mctsCallResponseDetail.getRemarks());
		return "Updated answer successfully";
	}

}
