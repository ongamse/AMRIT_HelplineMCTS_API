package com.iemr.mcts.controller.supervisor;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Matchers.anyObject;
import static org.mockito.Mockito.doReturn;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;

import com.beust.jcommander.internal.Lists;
import com.iemr.mcts.data.supervisor.CallConfigurationDetail;
import com.iemr.mcts.services.supervisor.CallConfigurationService;
import com.iemr.mcts.utils.exception.IEMRException;

@RunWith(MockitoJUnitRunner.class)
public class CallConfigurationControllerTest {

	@InjectMocks
	CallConfigurationController callConfigurationController;
	
	@Mock
	CallConfigurationService callConfigurationService;
	
	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void putConfigTest()
	{
		List<CallConfigurationDetail> callConfigurationDetailList=Lists.newArrayList();
		CallConfigurationDetail callConfigurationDetail=new CallConfigurationDetail();
		callConfigurationDetail.setMctsCallConfigID(new Integer("101"));
		callConfigurationDetailList.add(callConfigurationDetail);
		doReturn(callConfigurationDetailList).when(callConfigurationService).createCallNumberConfigurations(anyObject());
		String response=callConfigurationController.putConfig(Mockito.anyString());
		assertTrue(response.contains("\"mctsCallConfigID\":101"));
	}
	@Test
	public void putConfigTest1()
	{
		List<CallConfigurationDetail> callConfigurationDetailList=Lists.newArrayList();
		CallConfigurationDetail callConfigurationDetail=new CallConfigurationDetail();
		callConfigurationDetailList.add(callConfigurationDetail);
		doReturn(callConfigurationDetailList).when(callConfigurationService).createCallNumberConfigurations(anyObject());
		String response=callConfigurationController.putConfig(Mockito.anyString());
		assertFalse(response.contains("\"mctsCallConfigID\":101"));
	}
	@Test
	public void putConfigUpdateTest()
	{
		List<CallConfigurationDetail> callConfigurationDetailList=Lists.newArrayList();
		CallConfigurationDetail callConfigurationDetail=new CallConfigurationDetail();
		callConfigurationDetail.setMctsCallConfigID(new Integer("201"));
		callConfigurationDetailList.add(callConfigurationDetail);
		doReturn(callConfigurationDetailList).when(callConfigurationService).updateConfigurations(Mockito.anyListOf(CallConfigurationDetail.class));
		String response=callConfigurationController.putConfigUpdate(callConfigurationDetailList.toString());
		assertTrue(response.contains("\"mctsCallConfigID\":201"));
	}
	@Test
	public void putConfigUpdateTest1()
	{
		List<CallConfigurationDetail> callConfigurationDetailList=Lists.newArrayList();
		CallConfigurationDetail callConfigurationDetail=new CallConfigurationDetail();
		callConfigurationDetailList.add(callConfigurationDetail);
		doReturn(callConfigurationDetailList).when(callConfigurationService).updateConfigurations(Mockito.anyListOf(CallConfigurationDetail.class));
		String response=callConfigurationController.putConfigUpdate(callConfigurationDetailList.toString());
		assertFalse(response.contains("\"mctsCallConfigID\":201"));
	}
	@Test
	public void createConfigTest()
	{
		List<CallConfigurationDetail> callConfigurationDetailList=Lists.newArrayList();
		CallConfigurationDetail callConfigurationDetail=new CallConfigurationDetail();
		callConfigurationDetail.setMctsCallConfigID(new Integer("201"));
		callConfigurationDetailList.add(callConfigurationDetail);
		doReturn(callConfigurationDetailList).when(callConfigurationService).createConfigurations(Mockito.anyListOf(CallConfigurationDetail.class));
		String response=callConfigurationController.createConfig(callConfigurationDetailList.toString());
		assertTrue(response.contains("\"mctsCallConfigID\":201"));
	}
	@Test
	public void createConfigTest1()
	{
		List<CallConfigurationDetail> callConfigurationDetailList=Lists.newArrayList();
		CallConfigurationDetail callConfigurationDetail=new CallConfigurationDetail();
		callConfigurationDetailList.add(callConfigurationDetail);
		doReturn(callConfigurationDetailList).when(callConfigurationService).createConfigurations(Mockito.anyListOf(CallConfigurationDetail.class));
		String response=callConfigurationController.createConfig(callConfigurationDetailList.toString());
		assertFalse(response.contains("\"mctsCallConfigID\":201"));
	}
	@Test
	public void getOutboundCallTypesTest()
	{
		CallConfigurationDetail callConfigurationDetail=new CallConfigurationDetail();
		callConfigurationDetail.setMctsCallConfigID(new Integer("201"));
		try {
			doReturn(callConfigurationDetail.toString()).when(callConfigurationService).getOutBoundCallTypes(Mockito.anyString());
			String response=callConfigurationController.getOutboundCallTypes(callConfigurationDetail.toString());
			assertTrue(response.contains("\"mctsCallConfigID\":201"));
		} catch (IEMRException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		@Test
		public void getOutboundCallTypesTest1()
		{
			CallConfigurationDetail callConfigurationDetail=new CallConfigurationDetail();
			try {
				doReturn(callConfigurationDetail.toString()).when(callConfigurationService).getOutBoundCallTypes(Mockito.anyString());
				String response=callConfigurationController.getOutboundCallTypes(callConfigurationDetail.toString());
				assertFalse(response.contains("\"mctsCallConfigID\":201"));
			} catch (IEMRException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
/*		@Test
		public void getCallConfigurationListTest()
		{
			CallConfigurationDetail callConfigurationDetail=new CallConfigurationDetail();
			callConfigurationDetail.setProviderServiceMapID(new Long("201"));
			List<CallConfigurationDetail> list=Lists.newArrayList();
			list.add(callConfigurationDetail);
			try {
				doReturn(callConfigurationDetail.toString()).when(callConfigurationService).getCallConfigurationList(Mockito.anyString());
				String response=callConfigurationController.getCallConfigurationList(callConfigurationDetail.toString());
				assertTrue(response.contains("\"providerServiceMapID\":201"));
			} catch (IEMRException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}*/
			@Test
			public void getCallConfigurationListTest1()
			{
				CallConfigurationDetail callConfigurationDetail=new CallConfigurationDetail();
				List<CallConfigurationDetail> list=Lists.newArrayList();
				list.add(callConfigurationDetail);
				try {
					doReturn(callConfigurationDetail.toString()).when(callConfigurationService).getCallConfigurationList(Mockito.anyString());
					String response=callConfigurationController.getCallConfigurationList(callConfigurationDetail.toString());
					assertFalse(response.contains("\"providerServiceMapID\":201"));
				} catch (IEMRException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
			@Test
			public void putConfigurationUpdateTest()
			{
				List<CallConfigurationDetail> callConfigurationDetailList=Lists.newArrayList();
				CallConfigurationDetail callConfigurationDetail=new CallConfigurationDetail();
				callConfigurationDetail.setMctsCallConfigID(new Integer("201"));
				callConfigurationDetailList.add(callConfigurationDetail);
				try {
					doReturn(callConfigurationDetail.toString()).when(callConfigurationService).updateCallConfigurations(Mockito.anyString());
					String response=callConfigurationController.putConfigurationUpdate(callConfigurationDetailList.toString());
					assertTrue(response.contains("\"mctsCallConfigID\":201"));
				} catch (IEMRException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
			@Test
			public void putConfigurationUpdateTest1()
			{
				List<CallConfigurationDetail> callConfigurationDetailList=Lists.newArrayList();
				CallConfigurationDetail callConfigurationDetail=new CallConfigurationDetail();
				callConfigurationDetailList.add(callConfigurationDetail);
				try {
					doReturn(callConfigurationDetail.toString()).when(callConfigurationService).updateCallConfigurations(Mockito.anyString());
					String response=callConfigurationController.putConfigurationUpdate(callConfigurationDetailList.toString());
					assertFalse(response.contains("\"mctsCallConfigID\":201"));
				} catch (IEMRException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
}
