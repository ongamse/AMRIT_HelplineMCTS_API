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
package com.iemr.mcts.controller.supervisor;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.doThrow;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;

import com.iemr.mcts.services.supervisor.MctsQAMappingService;
import com.iemr.mcts.services.supervisor.QuestionnaireService;

@RunWith(MockitoJUnitRunner.class)
public class QuestionnaireControllerTest {

	@InjectMocks
	QuestionnaireController questionerController;
	
	@Mock
	QuestionnaireService questionnaireService;
	
	@Mock
	MctsQAMappingService mctsQAMappingService;
	
	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void editInteractionTest()
	{
		String str=new String("Inserted question successfully");
		try {
			doReturn(str).when(mctsQAMappingService).updateInteraction(Mockito.anyString());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String res=questionerController.editInteraction(Mockito.anyString());
		assertTrue(res.contains("\"response\":\"Inserted question successfully\""));
	}
	@Test
	public void editInteractionExceptionTest()
	{
		try {
			doThrow(Exception.class).when(mctsQAMappingService).updateInteraction(Mockito.anyString());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String res=questionerController.editInteraction(Mockito.anyString());
		assertFalse(res.contains("\"response\":\"Inserted question successfully\""));
	}
	@Test
	public void editQuestionnaireTest()
	{
		String str=new String("Updated question successfully");
		try {
			doReturn(str).when(questionnaireService).updateQuestionnaire(Mockito.anyString());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String res=questionerController.editQuestionnaire(Mockito.anyString());
		assertTrue(res.contains("\"response\":\"Updated question successfully\""));
	}
	@Test
	public void editQuestionnaireExceptionTest()
	{
		try {
			doThrow(Exception.class).when(questionnaireService).updateQuestionnaire(Mockito.anyString());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String res=questionerController.editQuestionnaire(Mockito.anyString());
		assertFalse(res.contains("\"response\":\"Updated question successfully\""));
	}
	@Test
	public void createOutBoundQuestionsTest()
	{
		String str=new String("Successfully added questions");
		try {
			doReturn(str).when(mctsQAMappingService).createOutboundQuestions(Mockito.anyString());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String res=questionerController.createOutBoundQuestions(Mockito.anyString());
		assertTrue(res.contains("\"response\":\"Successfully added questions\""));
	}
	@Test
	public void createOutBoundQuestionsExceptionTest()
	{
		try {
			doThrow(Exception.class).when(mctsQAMappingService).createOutboundQuestions(Mockito.anyString());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String res=questionerController.createOutBoundQuestions(Mockito.anyString());
		assertFalse(res.contains("\"response\":\"Successfully added questions\""));
	}
	@Test
	public void outboundQuestionListTest()
	{
		String str=new String("get outbound question list");
		try {
			doReturn(str).when(mctsQAMappingService).getOutboundQuestionList(Mockito.anyString());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String res=questionerController.outboundQuestionList(Mockito.anyString());
		assertTrue(res.contains("\"response\":\"get outbound question list\""));

	}
	@Test
	public void outboundQuestionListExceptionTest()
	{
		try {
			doThrow(Exception.class).when(mctsQAMappingService).getOutboundQuestionList(Mockito.anyString());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String res=questionerController.outboundQuestionList(Mockito.anyString());
		assertFalse(res.contains("\"response\":\"get outbound question list\""));

	}
	@Test
	public void updateQuestionTest()
	{
		String str=new String("Deleted successfully");
		try {
			doReturn(str).when(mctsQAMappingService).deleteQuestion(Mockito.anyString());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String res=questionerController.updateQuestion(Mockito.anyString());
		assertTrue(res.contains("\"response\":\"Deleted successfully\""));
		
	}
	@Test
	public void updateQuestionExceptionTest()
	{
		try {
			doThrow(Exception.class).when(mctsQAMappingService).deleteQuestion(Mockito.anyString());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String res=questionerController.updateQuestion(Mockito.anyString());
		assertFalse(res.contains("\"response\":\"Deleted successfully\""));
		
	}

}
