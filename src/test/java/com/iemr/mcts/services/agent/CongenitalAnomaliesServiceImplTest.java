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

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.doReturn;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.beust.jcommander.internal.Lists;
import com.iemr.mcts.data.agent.CongenitalAnomaliesDetail;
import com.iemr.mcts.repository.agent.CongenitalAnomaliesRepository;

@RunWith(MockitoJUnitRunner.class)
public class CongenitalAnomaliesServiceImplTest {

	@InjectMocks
	CongenitalAnomaliesServiceImpl congenitalAnomaliesServiceImpl;
	
	@Mock
	CongenitalAnomaliesRepository congenitalAnomaliesRepository;
	
	@Test
	public void getCongenitalAnomalies()
	{
		
		List<CongenitalAnomaliesDetail>  congenitalAnomaliesDetails=Lists.newArrayList();
		CongenitalAnomaliesDetail congenitalAnomaliesDetail=new CongenitalAnomaliesDetail();
		congenitalAnomaliesDetail.setCongenitalAnomaliesDesc("abc");
		congenitalAnomaliesDetails.add(congenitalAnomaliesDetail);
		doReturn(congenitalAnomaliesDetails).when(congenitalAnomaliesRepository).getCongenitalAnomalies();
		String response=congenitalAnomaliesServiceImpl.getCongenitalAnomalies();
		assertTrue(response.contains("\"congenitalAnomaliesDesc\":\"abc\""));
	}
	@Test
	public void getCongenitalAnomalies1()
	{
		
		String response=congenitalAnomaliesServiceImpl.getCongenitalAnomalies();
		assertFalse(response.contains("\"congenitalAnomaliesDesc\":\"abc\""));
	}
}
