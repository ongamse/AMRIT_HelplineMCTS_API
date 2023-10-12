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
import static org.mockito.Mockito.doThrow;

import java.util.List;

import org.apache.commons.compress.utils.Lists;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.iemr.mcts.data.agent.MctsCallResponseDetail;
import com.iemr.mcts.data.agent.MctsOutboundCallDetail;
import com.iemr.mcts.repository.agent.MctsCallResponseRepository;
import com.iemr.mcts.utils.exception.IEMRException;

@RunWith(MockitoJUnitRunner.class)
public class MctsCallResponseServiceImplTest {

	@InjectMocks
	MctsCallResponseServiceImpl mctsCallResponseServiceImpl;
	
	@Mock
	MctsCallResponseRepository mctsCallResponseRepository;
	
	@Test
	public void saveMctsCallResponseTest()
	{
		List<MctsCallResponseDetail> list=Lists.newArrayList();
		MctsCallResponseDetail detail=new MctsCallResponseDetail();
		detail.setCallDetailID(new Long("101"));
		detail.setQuestionID(102);
		list.add(detail);
		try {
			String response=mctsCallResponseServiceImpl.saveMctsCallResponse(list.toString());
			assertTrue(response.contains("Response added successfully"));
		} catch (IEMRException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Test
	public void saveMctsCallResponseTest1()
	{
		List<MctsCallResponseDetail> list=Lists.newArrayList();
		MctsCallResponseDetail detail=new MctsCallResponseDetail();
		list.add(detail);
		doReturn(null).when(mctsCallResponseRepository).isRecordAvail(Mockito.anyLong(), Mockito.anyInt());
		try {
			String response=mctsCallResponseServiceImpl.saveMctsCallResponse(list.toString());
			assertTrue(response.contains("Response added successfully"));
		} catch (IEMRException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Test
	public void getMctsCallResponseTest()
	{
		List<MctsOutboundCallDetail> list=Lists.newArrayList();
		MctsOutboundCallDetail mctsOutboundCallDetail=new MctsOutboundCallDetail();
		mctsOutboundCallDetail.setCallDetailID(new Long("101"));
		list.add(mctsOutboundCallDetail);
		doReturn(list).when(mctsCallResponseRepository).getMctsCallResponse(Mockito.anyLong());
		try {
			String response=mctsCallResponseServiceImpl.getMctsCallResponse(mctsOutboundCallDetail.toString());
			//assertTrue(response.contains("\"callDetailID\":101"));
		} catch (IEMRException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Test
	public void getMctsCallResponseTest1()
	{
		List<MctsOutboundCallDetail> list=Lists.newArrayList();
		MctsOutboundCallDetail mctsOutboundCallDetail=new MctsOutboundCallDetail();
		list.add(mctsOutboundCallDetail);
		doReturn(list).when(mctsCallResponseRepository).getMctsCallResponse(Mockito.anyLong());
		try {
			String response=mctsCallResponseServiceImpl.getMctsCallResponse(mctsOutboundCallDetail.toString());
			assertFalse(response.contains("\"callDetailID\":101"));
		} catch (IEMRException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Test
	public void updateMctsCallResponse()
	{
		MctsCallResponseDetail mctsCallResponseDetail=new MctsCallResponseDetail();
		mctsCallResponseDetail.setAnswer("answer");
		mctsCallResponseDetail.setRemarks("remark");
		mctsCallResponseDetail.setCallDetailID(new Long("101"));
		try {
			String response = mctsCallResponseServiceImpl.updateMctsCallResponse(mctsCallResponseDetail.toString());
			assertTrue(response.contains("Updated answer successfully"));
		} catch (IEMRException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	@Test
	public void updateMctsCallResponse1()
	{
		MctsCallResponseDetail mctsCallResponseDetail=new MctsCallResponseDetail();
		doThrow(IEMRException.class).when(mctsCallResponseRepository).updateMctsCall(Mockito.anyLong(),Mockito.anyString(),Mockito.anyString());
		String response="";
		try {
			response = mctsCallResponseServiceImpl.updateMctsCallResponse(mctsCallResponseDetail.toString());
			
		} catch (IEMRException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertFalse(response.contains("Updated answer successfully"));
		
	}
}
