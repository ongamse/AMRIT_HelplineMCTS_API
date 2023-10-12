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

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.doReturn;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.beust.jcommander.internal.Lists;
import com.iemr.mcts.data.supervisor.CallConfigurationDetail;
import com.iemr.mcts.data.supervisor.CallNumbersConfigDetail;
import com.iemr.mcts.repository.supervisor.CallConfigurationRepository;
import com.iemr.mcts.utils.exception.IEMRException;

@RunWith(MockitoJUnitRunner.class)
public class CallConfigurationServiceImplTest {

	@InjectMocks
	CallConfigurationServiceImpl callConfigurationServiceImpl;
	
	@Mock
	CallConfigurationRepository callConfigurationRepository;
	
	@SuppressWarnings("unlikely-arg-type")
	@Test
	public void createConfigurations()
	{
		List<CallConfigurationDetail> callConfigurationDetailList=Lists.newArrayList();
		CallConfigurationDetail callConfigurationDetail=new CallConfigurationDetail();
		callConfigurationDetail.setMctsCallConfigID(101);
		CallConfigurationDetail callConfigurationDetail1=new CallConfigurationDetail();
		callConfigurationDetail1.setMctsCallConfigID(201);
		callConfigurationDetailList.add(callConfigurationDetail);
		doReturn(callConfigurationDetail1).when(callConfigurationRepository).save(callConfigurationDetail);
		List<CallConfigurationDetail> list=callConfigurationServiceImpl.createConfigurations(callConfigurationDetailList);
		for(CallConfigurationDetail call:list)
		{
			assertTrue(call.getMctsCallConfigID()==201);
		}
		
		
	}
	@SuppressWarnings("unlikely-arg-type")
	@Test
	public void createConfigurations1()
	{
		List<CallConfigurationDetail> callConfigurationDetailList=Lists.newArrayList();
		CallConfigurationDetail callConfigurationDetail=new CallConfigurationDetail();
		callConfigurationDetailList.add(callConfigurationDetail);
		doReturn(callConfigurationDetail).when(callConfigurationRepository).save(callConfigurationDetail);
		List<CallConfigurationDetail> list=callConfigurationServiceImpl.createConfigurations(callConfigurationDetailList);
		for(CallConfigurationDetail call:list)
		{
			assertTrue(call.getMctsCallConfigID()==null);
		}
	}
	@Test
	public void createCallNumberConfigurationsTest()
	{
		CallNumbersConfigDetail callNumbersConfigDetail=new CallNumbersConfigDetail();
		callNumbersConfigDetail.setAnc(2);
		callNumbersConfigDetail.setProviderServiceMapID(new Long("101"));
		callNumbersConfigDetail.setPnc(2);
		
		List<CallConfigurationDetail> callConfigurationDetailList=Lists.newArrayList();
		CallConfigurationDetail callConfigurationDetail=new CallConfigurationDetail();
		callConfigurationDetail.setMctsCallConfigID(101);
		
		CallConfigurationDetail callConfigurationDetail1=new CallConfigurationDetail();
		callConfigurationDetail1.setMctsCallConfigID(201);
		callConfigurationDetailList.add(callConfigurationDetail);
		
		doReturn(callConfigurationDetail1).when(callConfigurationRepository).save(Mockito.mock(CallConfigurationDetail.class));
		
		List<CallConfigurationDetail> list=callConfigurationServiceImpl.createCallNumberConfigurations(callNumbersConfigDetail);
		//assertTrue(list.toString().contains("\"anc\":2"));
	}
	@Test
	public void updateConfigurationsTest()
	{
		List<CallConfigurationDetail> callConfigurationDetails=Lists.newArrayList();
		CallConfigurationDetail callConfigurationDetail=new CallConfigurationDetail();
		callConfigurationDetail.setMctsCallConfigID(101);
		callConfigurationDetails.add(callConfigurationDetail);
		List<CallConfigurationDetail> list=callConfigurationServiceImpl.updateConfigurations(callConfigurationDetails);
		assertTrue(list.size()==0);
	}
	@Test
	public void getOutBoundCallTypesTest()
	{
		CallConfigurationDetail callConfigurationDetail=new CallConfigurationDetail();
		callConfigurationDetail.setProviderServiceMapID(new Long("101"));
		List<CallConfigurationDetail> list=Lists.newArrayList();
		list.add(callConfigurationDetail);
		doReturn(list).when(callConfigurationRepository).getConfigTerms(Mockito.anyLong());
		try {
			String response=callConfigurationServiceImpl.getOutBoundCallTypes(callConfigurationDetail.toString());
			//assertTrue(response.contains("\"providerServiceMapID\":101"));
		} catch (IEMRException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Test
	public void getOutBoundCallTypesTest1()
	{
		CallConfigurationDetail callConfigurationDetail=new CallConfigurationDetail();
		List<CallConfigurationDetail> list=Lists.newArrayList();
		list.add(callConfigurationDetail);
		doReturn(list).when(callConfigurationRepository).getConfigTerms(Mockito.anyLong());
		try {
			String response=callConfigurationServiceImpl.getOutBoundCallTypes(callConfigurationDetail.toString());
			assertFalse(response.contains("\"providerServiceMapID\":101"));
		} catch (IEMRException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Test
	public void getCallConfigurationListTest()
	{
		CallConfigurationDetail callConfigurationDetail=new CallConfigurationDetail();
		callConfigurationDetail.setProviderServiceMapID(new Long("101"));
		callConfigurationDetail.setEffectiveFrom(new Date(Calendar.getInstance().getTimeInMillis()));
		List<CallConfigurationDetail> list=Lists.newArrayList();
		list.add(callConfigurationDetail);
		doReturn(list).when(callConfigurationRepository).getConfigurations(Mockito.anyLong());
		try {
			String response=callConfigurationServiceImpl.getCallConfigurationList(callConfigurationDetail.toString());
			//assertTrue(response.contains("\"providerServiceMapID\":101"));
		} catch (IEMRException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Test
	public void getCallConfigurationListTest1()
	{
		CallConfigurationDetail callConfigurationDetail=new CallConfigurationDetail();
		callConfigurationDetail.setEffectiveFrom(new Date(Calendar.getInstance().getTimeInMillis()));
		List<CallConfigurationDetail> list=Lists.newArrayList();
		list.add(callConfigurationDetail);
		doReturn(list).when(callConfigurationRepository).getConfigurations(Mockito.anyLong());
		try {
			String response=callConfigurationServiceImpl.getCallConfigurationList(callConfigurationDetail.toString());
			assertFalse(response.contains("\"providerServiceMapID\":101"));
		} catch (IEMRException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Test
	public void updateCallConfigurationsTest()
	{
		CallConfigurationDetail callConfigurationDetail=new CallConfigurationDetail();
		callConfigurationDetail.setProviderServiceMapID(new Long("101"));
		List<CallConfigurationDetail> list=Lists.newArrayList();
		list.add(callConfigurationDetail); 
		String response = "";
		try {
			response = callConfigurationServiceImpl.updateCallConfigurations(list.toString());
		} catch (IEMRException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertTrue(response.contains("Call configuration updated successfully"));
	}
}
