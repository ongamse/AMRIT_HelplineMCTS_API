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
package com.iemr.mcts.controller.agent;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.doThrow;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.iemr.mcts.services.agent.ChildCongenitalAnomaliesService;
import com.iemr.mcts.services.agent.CongenitalAnomaliesService;
import com.iemr.mcts.utils.exception.IEMRException;

@RunWith(MockitoJUnitRunner.class)
public class CongenitalAnomaliesControllerTest {

	@InjectMocks
	CongenitalAnomaliesController congenitalAnomaliesController;
	
	@Mock
	CongenitalAnomaliesService congenitalAnomaliesService;
	
	@Mock
	ChildCongenitalAnomaliesService childCongenitalAnomaliesService;
	
	@Test
	public void getCongAnomoliesTest()
	{
		String str=new String("get conganomolies");
		doReturn(str).when(congenitalAnomaliesService).getCongenitalAnomalies();
		String res=congenitalAnomaliesController.getCongAnomolies();
		assertTrue(res.contains("\"response\":\"get conganomolies\""));
	}
	@Test
	public void getCongAnomoliesExceptionTest()
	{
		doThrow(Exception.class).when(congenitalAnomaliesService).getCongenitalAnomalies();
		String res=congenitalAnomaliesController.getCongAnomolies();
		assertFalse(res.contains("\"response\":\"get conganomolies\""));
	}

	@Test
	public void getchildCATest()
	{
		String str=new String("get child conganomolies");
		try {
			doReturn(str).when(childCongenitalAnomaliesService).getChildCongenitalAnomalies(Mockito.anyString());
		} catch (IEMRException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String res=congenitalAnomaliesController.getchildCA(Mockito.anyString());
		assertTrue(res.contains("\"response\":\"get child conganomolies\""));
		
	}
	@Test
	public void getchildCAExceptionTest()
	{
		try {
			doThrow(Exception.class).when(childCongenitalAnomaliesService).getChildCongenitalAnomalies(Mockito.anyString());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String res=congenitalAnomaliesController.getchildCA(Mockito.anyString());
		assertFalse(res.contains("\"response\":\"get child conganomolies\""));
		
	}

}
