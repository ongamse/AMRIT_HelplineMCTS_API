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

import com.iemr.mcts.services.agent.MctsOutbondCallService;
import com.iemr.mcts.services.agent.MctsOutboundCallDetailService;
import com.iemr.mcts.utils.exception.IEMRException;

@RunWith(MockitoJUnitRunner.class)
public class OutboundCallControllerTest {

	@InjectMocks
	OutboundCallController outboundCallController;
	
	@Mock
	MctsOutbondCallService mctsOutbondCallService;
	
	@Mock
	MctsOutboundCallDetailService mctsOutboundCallDetailService;
	
/*	@Test
	public void getWorkListTest()
	{
		String str=new String("get worklist successfully");
		try {
			doReturn(str).when(mctsOutbondCallService).getOutbondCalls(Mockito.anyString());
		} catch (IEMRException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String res=outboundCallController.getWorkList(Mockito.anyString());
		assertTrue(res.contains("\"response\":\"get worklist successfully\""));
	}
	@Test
	public void getWorkListExceptionTest()
	{
		try {
			doThrow(IEMRException.class).when(mctsOutbondCallService).getOutbondCalls(Mockito.anyString());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String res=outboundCallController.getWorkList(Mockito.anyString());
		assertFalse(res.contains("\"response\":\"get worklist successfully\""));
	}*/
	@Test
	public void agentCallAllocationTest()
	{
		String str=new String("agent call allocated successfully");
		try {
			doReturn(str).when(mctsOutbondCallService).allocateCalls(Mockito.anyString());
		} catch (IEMRException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String res=outboundCallController.agentCallAllocation(Mockito.anyString());
		assertTrue(res.contains("\"response\":\"agent call allocated successfully\""));
	}
	@Test
	public void agentCallAllocationExceptionTest()
	{
		try {
			doThrow(IEMRException.class).when(mctsOutbondCallService).allocateCalls(Mockito.anyString());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String res=outboundCallController.agentCallAllocation(Mockito.anyString());
		assertFalse(res.contains("\"response\":\"agent call allocated successfully\""));
	}

	@Test
	public void getUnallocatedCallsTest()
	{
		String str=new String("get unallocated call successfully");
		try {
			doReturn(str).when(mctsOutbondCallService).getUnallocatedCalls(Mockito.anyString());
		} catch (IEMRException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String res=outboundCallController.getUnallocatedCalls(Mockito.anyString());
		assertTrue(res.contains("\"response\":\"get unallocated call successfully\""));
		
	}
	@Test
	public void getUnallocatedCallsExceptionTest()
	{
		try {
			doThrow(IEMRException.class).when(mctsOutbondCallService).getUnallocatedCalls(Mockito.anyString());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String res=outboundCallController.getUnallocatedCalls(Mockito.anyString());
		assertFalse(res.contains("\"response\":\"get unallocated call successfully\""));
		
	}
	@Test
	public void getReallocateCallsTest()
	{
		String str=new String("get reallocated call successfully");
		try {
			doReturn(str).when(mctsOutbondCallService).getReallocateCalls(Mockito.anyString());
		} catch (IEMRException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String res=outboundCallController.getReallocateCalls(Mockito.anyString());
		assertTrue(res.contains("\"response\":\"get reallocated call successfully\""));
		
	}
	@Test
	public void getReallocateCallsExceptionTest()
	{
		try {
			doThrow(IEMRException.class).when(mctsOutbondCallService).getReallocateCalls(Mockito.anyString());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String res=outboundCallController.getReallocateCalls(Mockito.anyString());
		assertFalse(res.contains("\"response\":\"get reallocated call successfully\""));
		
	}
	@Test
	public void moveToBucketTest()
	{
		String str=new String("Data have been moved to bucket successfully");
		try {
			doReturn(str).when(mctsOutbondCallService).moveCallsToBucket(Mockito.anyString());
		} catch (IEMRException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String res=outboundCallController.moveToBucket(Mockito.anyString());
		assertTrue(res.contains("\"response\":\"Data have been moved to bucket successfully\""));
		
	}
	@Test
	public void moveToBucketExceptionTest()
	{
		try {
			doThrow(IEMRException.class).when(mctsOutbondCallService).moveCallsToBucket(Mockito.anyString());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String res=outboundCallController.moveToBucket(Mockito.anyString());
		assertFalse(res.contains("\"response\":\"Data have been moved to bucket successfully\""));
		
	}
	@Test
	public void putCallHistoryTest()
	{
		String str=new String("Call closed successfully");
		try {
			doReturn(str).when(mctsOutboundCallDetailService).saveCallClosure(Mockito.anyString());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String res=outboundCallController.putCallHistory(Mockito.anyString());
		assertTrue(res.contains("\"response\":\"Call closed successfully\""));
		
	}
	@Test
	public void putCallHistoryExceptionTest()
	{
		try {
			doThrow(IEMRException.class).when(mctsOutboundCallDetailService).saveCallClosure(Mockito.anyString());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String res=outboundCallController.putCallHistory(Mockito.anyString());
		assertFalse(res.contains("\"response\":\"Call closed successfully\""));
		
	}
	
	@Test
	public void getCallHistoryTest()
	{
		String str=new String("get call history successfully");
		try {
			doReturn(str).when(mctsOutboundCallDetailService).getCallHistory(Mockito.anyString());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String res=outboundCallController.getCallHistory(Mockito.anyString());
		assertTrue(res.contains("\"response\":\"get call history successfully\""));
		
	}
	@Test
	public void getCallHistoryExceptionTest()
	{
		try {
			doThrow(IEMRException.class).when(mctsOutboundCallDetailService).getCallHistory(Mockito.anyString());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String res=outboundCallController.getCallHistory(Mockito.anyString());
		assertFalse(res.contains("\"response\":\"get call history successfully\""));
		
	}
	
	@Test
	public void getNextANC_PNCTest()
	{
		String str=new String("get next anc pnc successfully");
		try {
			doReturn(str).when(mctsOutbondCallService).getNextANC_PNC(Mockito.anyString());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String res=outboundCallController.getNextANC_PNC(Mockito.anyString());
		assertTrue(res.contains("\"response\":\"get next anc pnc successfully\""));

	}
	@Test
	public void getNextANC_PNCExceptionTest()
	{
		try {
			doThrow(IEMRException.class).when(mctsOutbondCallService).getNextANC_PNC(Mockito.anyString());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String res=outboundCallController.getNextANC_PNC(Mockito.anyString());
		assertFalse(res.contains("\"response\":\"get next anc pnc successfully\""));

	}

}
