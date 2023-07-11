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
package com.iemr.mcts.services.supervisor;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.assertj.core.util.Lists;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.iemr.mcts.data.supervisor.MctsQAMappingDetail;
import com.iemr.mcts.data.supervisor.QuestionnaireDetail;
import com.iemr.mcts.repository.supervisor.MctsQAMappingRepository;
import com.iemr.mcts.repository.supervisor.QuestionnaireRepository;
import com.iemr.mcts.utils.exception.IEMRException;

@RunWith(MockitoJUnitRunner.class)
public class QuestionnaireServiceImplTest {

	
	@InjectMocks
	QuestionnaireServiceImpl questionnaireServiceImpl;
	
	@Mock
	QuestionnaireRepository questionnaireRepository;
	
	@Mock
	MctsQAMappingRepository mctsQAMappingRepository;
	
	@Test
	public void createQuestionnaireTest()
	{
		QuestionnaireDetail questionnaireDetail=new QuestionnaireDetail();
		questionnaireDetail.setAnswerType("answerType");
		List<QuestionnaireDetail> list=Lists.newArrayList();
		list.add(questionnaireDetail);
		try {
			String response=questionnaireServiceImpl.createQuestionnaire(list.toString());
			assertTrue(response.contains("Inserted question successfully;"));
		} catch (IEMRException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void updateQuestionnaireTest()
	{
		MctsQAMappingDetail mctsQAMappingDetail=new MctsQAMappingDetail();
		mctsQAMappingDetail.setVariableName("variable");
		mctsQAMappingDetail.setQuestionID(101);
		QuestionnaireDetail questionnaireDetail=new QuestionnaireDetail();
		questionnaireDetail.setAnswerType("answerType");
		questionnaireDetail.setMctsQAMappingDetail(mctsQAMappingDetail);
		
	}
}
