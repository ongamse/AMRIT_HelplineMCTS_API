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
import static org.mockito.Mockito.doReturn;

import java.sql.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.beust.jcommander.internal.Lists;
import com.iemr.mcts.data.supervisor.MctsQAMappingDetail;
import com.iemr.mcts.data.supervisor.QuestionnaireDetail;
import com.iemr.mcts.repository.agent.MctsCallResponseRepository;
import com.iemr.mcts.repository.supervisor.MctsQAMappingRepository;
import com.iemr.mcts.repository.supervisor.QuestionnaireRepository;
import com.iemr.mcts.utils.exception.IEMRException;

@RunWith(MockitoJUnitRunner.class)
public class MctsQAMappingServiceImplTest {
	
	
	@InjectMocks
	MctsQAMappingServiceImpl mctsQAMappingServiceImpl;
	
	@Mock
	MctsQAMappingRepository mctsQAMappingRepository;
	
	@Mock
	QuestionnaireRepository questionnaireRepository;
	
	@Mock
	MctsCallResponseRepository mctsCallResponseRepository;;
	
/*	@Test
	public void createOutBoundQuestions()
	{
		MctsQAMappingDetail mctsQAMappingDetail=new MctsQAMappingDetail();
		
		mctsQAMappingDetail.setProviderServiceMapID(new Long("101"));
		List<MctsQAMappingDetail> list=Lists.newArrayList();
		System.out.println(mctsQAMappingDetail.toString());
		
		QuestionnaireDetail questionnaireDetail=new QuestionnaireDetail();
		questionnaireDetail.setAnswerType("answer");
		mctsQAMappingDetail.setQuestionnaireDetail(questionnaireDetail);
		list.add(mctsQAMappingDetail); 
		
		doReturn(questionnaireDetail).when(questionnaireRepository).save(questionnaireDetail);
		try {
			String response=mctsQAMappingServiceImpl.createOutboundQuestions(list.toString());
			assertTrue(response.contains("Successfully added questions"));
		} catch (IEMRException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}*/
	
	@Test
	public void getOutboundQuestionListTest()
	{
		try {
			String response=mctsQAMappingServiceImpl.
			getOutboundQuestionList("{\"mctsQAMappingDetail\":{\"mctsQAMapID\":101},\"mctsOutboundCall\":{\"obCallID\":107},\"callDetailID\":109}");
			assertTrue(response.contains("\"interactions\":\" \""));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Test
	public void getOutboundQuestionListTest1()
	{
		try {
			String response=mctsQAMappingServiceImpl.
			getOutboundQuestionList("{\"mctsQAMappingDetail\":{\"mctsQAMapID\":101,\"outboundCallType\":\"type\"},\"mctsOutboundCall\":{\"obCallID\":107,\"outboundCallType\":\"type\",\"mctsDataReaderDetail\":{\"BeneficiaryRegID\":109}},\"callDetailID\":109}");
			assertTrue(response.contains("\"interactions\":\"\""));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();  
		}
	}
	@Test
	public void getOutboundQuestionListTest2()
	{
		try {
			String response=mctsQAMappingServiceImpl.
			getOutboundQuestionList("{\"mctsQAMappingDetail\":{\"mctsQAMapID\":101,\"outboundCallType\":\"type\"},\"mctsOutboundCall\":{\"obCallID\":107,\"outboundCallType\":\"type\",\"childValidDataHandler\":{\"BeneficiaryRegID\":109}},\"callDetailID\":109}");
			assertTrue(response.contains("\"interactions\":\"\""));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();  
		}
	}
	
	@Test
	public void getOutboundQuestionListTest3()
	{
		try {
			QuestionnaireDetail questionnaireDetail=new QuestionnaireDetail();
			questionnaireDetail.setQuestion("interaction");
			List<MctsQAMappingDetail> mctsQAMappingDetails=Lists.newArrayList();
			MctsQAMappingDetail mctsQAMappingDetail=new MctsQAMappingDetail();
			mctsQAMappingDetail.setQuestionnaireDetail(questionnaireDetail);
			mctsQAMappingDetails.add(mctsQAMappingDetail);
			doReturn(mctsQAMappingDetails).when(mctsQAMappingRepository).getQuestionsTypeList(Mockito.anyString(),Mockito.anyLong(),Mockito.any(Date.class));
			
			
			String response=mctsQAMappingServiceImpl.
			getOutboundQuestionList("{\"mctsQAMappingDetail\":{\"mctsQAMapID\":101,\"outboundCallType\":\"type\"},\"mctsOutboundCall\":{\"obCallID\":107,\"outboundCallType\":\"type\",\"childValidDataHandler\":{\"BeneficiaryRegID\":109}},\"callDetailID\":109}");
			//assertTrue(response.contains("\"interactions\":\"interaction \""));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();  
		}
	}
	@Test
	public void getOutboundQuestionListTest4()
	{
		try {
			QuestionnaireDetail questionnaireDetail=new QuestionnaireDetail();
			questionnaireDetail.setQuestion("interaction");
			List<MctsQAMappingDetail> mctsQAMappingDetails=Lists.newArrayList();
			MctsQAMappingDetail mctsQAMappingDetail=new MctsQAMappingDetail();
			mctsQAMappingDetail.setQuestionnaireDetail(questionnaireDetail);
			mctsQAMappingDetail.setVariableName("variable");
			mctsQAMappingDetails.add(mctsQAMappingDetail);
			doReturn(mctsQAMappingDetails).when(mctsQAMappingRepository).getQuestionsTypeList(Mockito.anyString(),Mockito.anyLong(),Mockito.any(Date.class));
			
			
			String response=mctsQAMappingServiceImpl.
			getOutboundQuestionList("{\"mctsQAMappingDetail\":{\"mctsQAMapID\":101,\"outboundCallType\":\"type\"},\"mctsOutboundCall\":{\"obCallID\":107,\"outboundCallType\":\"type\",\"childValidDataHandler\":{\"BeneficiaryRegID\":109}},\"callDetailID\":109}");
			//assertTrue(response.contains("\"interactions\":\"interaction \""));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();  
		}
	}
	
	@Test
	public void deleteQuestionTest()
	{
		try {
			String response=mctsQAMappingServiceImpl.deleteQuestion("{\"questionID\":101}");
			assertTrue(response.contains("Deleted successfully"));
		} catch (IEMRException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
