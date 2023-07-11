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

import static org.mockito.Mockito.doReturn;

import java.util.List;

import org.assertj.core.util.Lists;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.iemr.mcts.data.supervisor.MctsStatewiseFieldsDetail;
import com.iemr.mcts.repository.supervisor.MctsStatewiseFieldsRepository;
import com.iemr.mcts.utils.exception.IEMRException;

@RunWith(MockitoJUnitRunner.class)
public class MctsStatewiseFieldsServiceImplTest {

	@InjectMocks
	MctsStatewiseFieldsServiceImpl mctsStatewiseFieldsServiceImpl;
	
	@Mock
	MctsStatewiseFieldsRepository mctsStatewiseFieldsRepository;
	
	@Test
	public void getVariables()
	{
		/*List<MctsStatewiseFieldsDetail> list=Lists.newArrayList();
		MctsStatewiseFieldsDetail mctsStatewiseFieldsDetail=new MctsStatewiseFieldsDetail();
		mctsStatewiseFieldsDetail.setProviderServiceMapID(new Long("101"));
		list.add(mctsStatewiseFieldsDetail);
		doReturn(mctsStatewiseFieldsDetail).when(mctsStatewiseFieldsRepository).getAllFields(Mockito.anyLong(),Mockito.anyString());
		try {
			//mctsStatewiseFieldsServiceImpl.getVariables("{\"providerServiceMapID\":109, \"dataFields\":\"dataFields\", \"fieldFor\":\"fieldFor\"}");
			mctsStatewiseFieldsServiceImpl.getVariables(mctsStatewiseFieldsDetail.toString());
		} catch (IEMRException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
	}
}
