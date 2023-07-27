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

import com.iemr.mcts.services.supervisor.MctsStatewiseFieldsService;
import com.iemr.mcts.utils.exception.IEMRException;

@RunWith(MockitoJUnitRunner.class)
public class MCTSStatewiseFieldControllerTest {

	@InjectMocks
	MCTSStatewiseFieldController mctsStatewiseFieldsController;
	
	@Mock
	MctsStatewiseFieldsService mctsStatewiseFieldsService;
	
	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void getVariablesTest()
	{
		String str=new String("abc");
		try {
			doReturn(str).when(mctsStatewiseFieldsService).getVariables(Mockito.anyString());
		} catch (IEMRException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String res=mctsStatewiseFieldsController.getVariables(Mockito.anyString());
		assertTrue(res.contains("\"response\":\"abc\""));
	}
	@Test
	public void getVariablesExceptionTest()
	{
		
		try {
			doThrow(Exception.class).when(mctsStatewiseFieldsService).getVariables(Mockito.anyString());
		} catch (IEMRException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String res=mctsStatewiseFieldsController.getVariables(Mockito.anyString());
		assertFalse(res.contains("\"response\":\"abc\""));
	}

}
