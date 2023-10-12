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

import java.sql.Date;
import java.util.Calendar;
import java.util.List;

import org.assertj.core.util.Lists;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.iemr.mcts.data.supervisor.AgentCallAllocationDetail;
import com.iemr.mcts.data.supervisor.MctsOutboundCall;
import com.iemr.mcts.data.utils.ReallocationDataUtil;
import com.iemr.mcts.repository.agent.MCTSOutboundCallRepository;
import com.iemr.mcts.utils.exception.IEMRException;

@RunWith(MockitoJUnitRunner.class)
public class MctsOutbondCallServiceImplTest {

	@InjectMocks
	MctsOutbondCallServiceImpl mctsOutbondCallServiceImpl;
	
	@Mock
	MCTSOutboundCallRepository mctsOutboundCallRepository;
	
	@Test
	public void getOutbondCallsTest()
	{
		MctsOutboundCall mctsOutboundCall=new MctsOutboundCall();
		mctsOutboundCall.setOutboundCallType("type");
		mctsOutboundCall.setProviderServiceMapID(new Long("101"));
		mctsOutboundCall.setAllocatedUserID(501);
		mctsOutboundCall.setCallDateFrom(new Date(Calendar.getInstance().getTimeInMillis()));
		List<MctsOutboundCall> list=Lists.newArrayList();
		list.add(mctsOutboundCall);
		doReturn(list).when(mctsOutboundCallRepository).getMotherAllocatedCalls(Mockito.anyInt());
		
		MctsOutboundCall mctsOutboundCall1=new MctsOutboundCall();
		mctsOutboundCall1.setOutboundCallType("type");
		mctsOutboundCall1.setProviderServiceMapID(new Long("201"));
		mctsOutboundCall1.setAllocatedUserID(601);
		mctsOutboundCall1.setCallDateFrom(new Date(Calendar.getInstance().getTimeInMillis()));
		List<MctsOutboundCall> list1=Lists.newArrayList();
		list1.add(mctsOutboundCall1);
		doReturn(list1).when(mctsOutboundCallRepository).getChildAllocatedCalls(Mockito.anyInt());
		
		try {
			String response=mctsOutbondCallServiceImpl.getOutbondCalls(mctsOutboundCall.toString());
			assertTrue(response.contains("\"allocatedUserID\":501"));
			assertTrue(response.contains("\"allocatedUserID\":601"));
		} catch (IEMRException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Test
	public void getOutbondCallsTest1()
	{
		MctsOutboundCall mctsOutboundCall=new MctsOutboundCall();
		mctsOutboundCall.setOutboundCallType("type");
		mctsOutboundCall.setAllocatedUserID(501);
		String response="";
		try {
			doThrow(IEMRException.class).when(mctsOutboundCallRepository).getMotherAllocatedCalls(Mockito.anyInt());
			response=mctsOutbondCallServiceImpl.getOutbondCalls(mctsOutboundCall.toString());
			
		} catch (IEMRException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertFalse(response.contains("\"allocatedUserID\":501"));
	}
	@Test
	public void getOutbondCallsTest2()
	{
		MctsOutboundCall mctsOutboundCall=new MctsOutboundCall();
		mctsOutboundCall.setOutboundCallType("type");
		mctsOutboundCall.setAllocatedUserID(501);
		String response="";
		try {
			doThrow(IEMRException.class).when(mctsOutboundCallRepository).getChildAllocatedCalls(Mockito.anyInt());
			response=mctsOutbondCallServiceImpl.getOutbondCalls(mctsOutboundCall.toString());
			
		} catch (IEMRException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertFalse(response.contains("\"allocatedUserID\":501"));
	}
	@Test
	public void allocateCallsTest()
	{
		AgentCallAllocationDetail agentCallAllocationDetail=new AgentCallAllocationDetail();
		MctsOutboundCall[] array=new MctsOutboundCall[1];
		MctsOutboundCall mctsOutboundCall=new MctsOutboundCall();
		mctsOutboundCall.setOutboundCallType("type");
		mctsOutboundCall.setAllocatedUserID(501);
		mctsOutboundCall.setObCallID(new Long("101"));
		array[0]=mctsOutboundCall;
		agentCallAllocationDetail.setMctsOutboundCalls(array);
		agentCallAllocationDetail.setAllocateNo(5);
		List<Integer> userID=Lists.newArrayList();
		userID.add(2);
		agentCallAllocationDetail.setUserID(userID);
		try {
			String response=mctsOutbondCallServiceImpl.allocateCalls(agentCallAllocationDetail.toString());
			assertTrue(response.contains("1"));
		} catch (IEMRException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Test
	public void allocateCallsTest1()
	{
		AgentCallAllocationDetail agentCallAllocationDetail=new AgentCallAllocationDetail();
		MctsOutboundCall[] array=new MctsOutboundCall[1];
		MctsOutboundCall mctsOutboundCall=new MctsOutboundCall();
		mctsOutboundCall.setOutboundCallType("type");
		mctsOutboundCall.setAllocatedUserID(501);
		mctsOutboundCall.setObCallID(new Long("101"));
		array[0]=mctsOutboundCall;
		agentCallAllocationDetail.setMctsOutboundCalls(array);
		agentCallAllocationDetail.setAllocateNo(5);
		List<Integer> userID=Lists.newArrayList();
		userID.add(2);
		agentCallAllocationDetail.setUserID(userID);
		doThrow(IEMRException.class).when(mctsOutboundCallRepository).allocateCall(Mockito.anyLong(),Mockito.anyInt());
		String response="";
		try {
			response=mctsOutbondCallServiceImpl.allocateCalls(agentCallAllocationDetail.toString());
			
		} catch (IEMRException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertFalse(response.contains("1"));
	}
	@Test
	public void getUnallocatedCallsTest()
	{
		MctsOutboundCall mctsOutboundCall=new MctsOutboundCall();
		mctsOutboundCall.setOutboundCallType("type");
		mctsOutboundCall.setMotherID(new Long("101"));
		mctsOutboundCall.setCallDateFrom(new Date(Calendar.getInstance().getTimeInMillis()));
		List<MctsOutboundCall> list=Lists.newArrayList();
		list.add(mctsOutboundCall);
		
		MctsOutboundCall mctsOutboundCall1=new MctsOutboundCall();
		mctsOutboundCall1.setOutboundCallType("type");
		mctsOutboundCall1.setChildID(new Long("201"));
		mctsOutboundCall1.setCallDateFrom(new Date(Calendar.getInstance().getTimeInMillis()));
		List<MctsOutboundCall> list1=Lists.newArrayList();
		list1.add(mctsOutboundCall1);
		
		doReturn(list).when(mctsOutboundCallRepository).getMotherUnAllocatedCalls(Mockito.any(Date.class), Mockito.any(Date.class), Mockito.anyLong());
		doReturn(list1).when(mctsOutboundCallRepository).getChildUnAllocatedCalls(Mockito.any(Date.class), Mockito.any(Date.class), Mockito.anyLong());
		try {
			String response=mctsOutbondCallServiceImpl.getUnallocatedCalls(mctsOutboundCall.toString());
			//assertTrue(response.contains("\"motherID\":101"));
			//assertTrue(response.contains("\"childID\":201"));
		} catch (IEMRException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void getUnallocatedCallsTest1()
	{
		MctsOutboundCall mctsOutboundCall=new MctsOutboundCall();
		mctsOutboundCall.setOutboundCallType("type");
		mctsOutboundCall.setMotherID(new Long("101"));
		mctsOutboundCall.setCallDateFrom(new Date(Calendar.getInstance().getTimeInMillis()));
		String response="";
		try {
			doThrow(IEMRException.class).when(mctsOutboundCallRepository).getMotherUnAllocatedCalls(Mockito.any(Date.class), Mockito.any(Date.class), Mockito.anyLong());
			response=mctsOutbondCallServiceImpl.getUnallocatedCalls(mctsOutboundCall.toString());
			
		} catch (IEMRException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertFalse(response.contains("\"motherID\":101"));
	}
	@Test
	public void getUnallocatedCallsTest2()
	{
		MctsOutboundCall mctsOutboundCall=new MctsOutboundCall();
		mctsOutboundCall.setOutboundCallType("type");
		mctsOutboundCall.setMotherID(new Long("101"));
		mctsOutboundCall.setCallDateFrom(new Date(Calendar.getInstance().getTimeInMillis()));
		String response="";
		try {
			doThrow(IEMRException.class).when(mctsOutboundCallRepository).getChildUnAllocatedCalls(Mockito.any(Date.class), Mockito.any(Date.class), Mockito.anyLong());
			response=mctsOutbondCallServiceImpl.getUnallocatedCalls(mctsOutboundCall.toString());
			
		} catch (IEMRException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertFalse(response.contains("\"childID\":101"));
	}
	@Test
	public void getUnallocatedCallsTest3()
	{
		MctsOutboundCall mctsOutboundCall=new MctsOutboundCall();
		mctsOutboundCall.setOutboundCallType("type");
		mctsOutboundCall.setMotherID(new Long("101"));
		List<MctsOutboundCall> list=Lists.newArrayList();
		list.add(mctsOutboundCall);
		
		doReturn(list).when(mctsOutboundCallRepository).getMotherUnallocatedCalls(Mockito.anyLong());
		try {
			String response=mctsOutbondCallServiceImpl.getUnallocatedCalls(mctsOutboundCall.toString());
			//assertTrue(response.contains("\"motherID\":101"));
		} catch (IEMRException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Test
	public void getUnallocatedCallsTest4()
	{
		MctsOutboundCall mctsOutboundCall1=new MctsOutboundCall();
		mctsOutboundCall1.setOutboundCallType("type");
		mctsOutboundCall1.setChildID(new Long("201"));
		List<MctsOutboundCall> list1=Lists.newArrayList();
		list1.add(mctsOutboundCall1);
		
		doReturn(list1).when(mctsOutboundCallRepository).getChildUnallocatedCalls(Mockito.anyLong());
		try {
			String response=mctsOutbondCallServiceImpl.getUnallocatedCalls(mctsOutboundCall1.toString());
			//assertTrue(response.contains("\"childID\":201"));
		} catch (IEMRException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Test
	public void getReallocateCallsTest()
	{
		ReallocationDataUtil reallocationDataUtil=new ReallocationDataUtil();
		reallocationDataUtil.setRecordType("recordType");
	}
	
	/*@Test
	public void moveCallsToBucketTest()
	{
		MctsOutboundCall mctsOutboundCall1=new MctsOutboundCall();
		mctsOutboundCall1.setOutboundCallType("type");
		mctsOutboundCall1.setChildID(new Long("201"));
		List<MctsOutboundCall> list1=Lists.newArrayList();
		list1.add(mctsOutboundCall1);
		doReturn(101).when(mctsOutboundCallRepository).moveToBucket(Mockito.anyLong());
		try {
			String response=mctsOutbondCallServiceImpl.moveCallsToBucket(list1.toString());
			assertTrue(response.contains("Data moved to bucket successfully"));
		} catch (IEMRException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}*/
	@Test
	public void getNextANC_PNCTest()
	{
		MctsOutboundCall mctsOutboundCall1=new MctsOutboundCall();
		mctsOutboundCall1.setOutboundCallType("1234");
		mctsOutboundCall1.setChildID(new Long("201"));
		try {
			String response=mctsOutbondCallServiceImpl.getNextANC_PNC(mctsOutboundCall1.toString());
			assertFalse(response.contains("2018-03-29"));
		} catch (IEMRException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Test
	public void getNextANC_PNCTest1()
	{
		MctsOutboundCall mctsOutboundCall1=new MctsOutboundCall();
		mctsOutboundCall1.setOutboundCallType("1234");
		//mctsOutboundCall1.setChildID(new Long("201"));
		mctsOutboundCall1.setCallDateFrom(new Date(Calendar.getInstance().getTimeInMillis()));
		//doReturn(mctsOutboundCall1).when(mctsOutboundCallRepository).getNextANC_PNC(Mockito.anyLong(),Mockito.anyString());
		try {
			String response=mctsOutbondCallServiceImpl.getNextANC_PNC(mctsOutboundCall1.toString());
			assertTrue(response.contains(""));
		} catch (IEMRException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
