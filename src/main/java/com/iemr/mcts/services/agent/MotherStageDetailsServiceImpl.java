/*
* AMRIT – Accessible Medical Records via Integrated Technology
* Integrated EHR (Electronic Health Records) Solution
*
* Copyright (C) "Piramal Swasthya Management and Research Institute"
*
* This file is part of AMRIT.
*
* This program is free software: you can redistribute it and/or modify
* it under the terms of the GNU General Public License as published by
* the Free Software Foundation, either version 3 of the License, or
* (at your option) any later version.
*
* This program is distributed in the hope that it will be useful,
* but WITHOUT ANY WARRANTY; without even the implied warranty of
* MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
* GNU General Public License for more details.
*
* You should have received a copy of the GNU General Public License
* along with this program.  If not, see https://www.gnu.org/licenses/.
*/
package com.iemr.mcts.services.agent;

import java.util.List;

import org.springframework.stereotype.Service;

import com.iemr.mcts.data.agent.MotherValidRecordDetail;

@Service
public class MotherStageDetailsServiceImpl implements MotherStageDetailsService {

	@Override
	public List<MotherValidRecordDetail> getMotherDetails(Long mCTSIDNo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MotherValidRecordDetail saveMotherDetails(MotherValidRecordDetail motherStageDetails) {
		// TODO Auto-generated method stub
		return null;
	}

//	@Override
//	public List<MotherValidRecordDetail> getMotherDetails(Long mCTSIDNo) {
//		
//		List<MotherStageDetails> motherList = new ArrayList<MotherStageDetails>();
//		ArrayList<Objects[]> mList = motherStageDetailsRepository.getMotherDetails(mCTSIDNo);
//	
//		for (Object[] objects : mList) {
//			if (objects!=null && objects.length > 0) {
//				motherList.add(new MotherStageDetails((Long)objects[0], (String)objects[1],(String)objects[2],(String)objects[3],
//						(String)objects[4],(String)objects[5],(String)objects[6],(String)objects[7],(String)objects[8],(String)objects[9],
//								(String)objects[10],(String)objects[11],(String)objects[12],(Long)objects[13],(String)objects[14],(Date)objects[15]));
//			}
//		}
//		
//		return motherList;
//	}
//	
//	@Override
//	public MotherStageDetails saveMotherDetails(MotherStageDetails motherStageDetails) {
//		
//		return motherStageDetailsRepository.save(motherStageDetails);
//	}	
//	
//	@Override
//	public List<QuestionerMapping> getMctsCallType(Long stateID) {
//		
//		List<QuestionerMapping> callTypeList = new ArrayList<QuestionerMapping>();
//		ArrayList<Objects[]> calllist = mctsCallTypeRepository.getMctsCallType(stateID);
//	
//		for (Object[] objects : calllist) {
//			if (objects!=null && objects.length > 0) {
//				callTypeList.add(new QuestionerMapping((Long)objects[0], (String)objects[1]));
//			}
//		}
//		
//		return callTypeList;		
//	}	
//	
//	private MotherStageDetailsRepository motherStageDetailsRepository;
//
//	/**
//	 * @param motherStageDetailsRepository the motherStageDetailsRepository to set
//	 */
//	@Autowired
//	public void setMotherStageDetailsRepository(MotherStageDetailsRepository motherStageDetailsRepository) {
//		this.motherStageDetailsRepository = motherStageDetailsRepository;
//	}
//
//	
//	private MctsCallTypeRepository mctsCallTypeRepository;
//	
//	/**
//	 * @param mctsCallTypeRepository the mctsCallTypeRepository to set
//	 */
//	@Autowired
//	public void setMctsCallTypeRepository(MctsCallTypeRepository mctsCallTypeRepository) {
//		this.mctsCallTypeRepository = mctsCallTypeRepository;
//	}
//	
//	private QuestionerRepository questionerRepository;
//	
//	/**
//	 * @param questionerRepository the questionerRepository to set
//	 */
//	@Autowired
//	public void setQuestionerRepository(QuestionerRepository questionerRepository) {
//		this.questionerRepository = questionerRepository;
//	}
//
//	@Override
//	public Questioner saveQuestionDetails(Questioner questioner) {
//		
//		return questionerRepository.save(questioner);
//	}
//
//	@Override
//	public Questioner editQuestioner(QuestionerDTO questionerDTO) {
//		
//		Questioner question = new Questioner();
//		question.setQuestion(questionerDTO.getQuestion());
//		question.setQuestionDesc(questionerDTO.getQuestionDesc());
//		Questioner que =  questionerRepository.save(question);
//		return que;
//		
//	}	
	
}
