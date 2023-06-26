package com.iemr.mcts.controller.agent;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;

import javax.servlet.http.HttpServletRequest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.iemr.mcts.services.agent.MctsOutboundCallDetailService;
import com.iemr.mcts.utils.exception.IEMRException;

@RunWith(MockitoJUnitRunner.class)
public class MctsOutboundCallDetailControllerTest {

	@InjectMocks
	MctsOutboundCallDetailController mctsOutboundCallDetailController;
	
	@Mock
	MctsOutboundCallDetailService mctsOutboundCallDetailService;
	
	@Test
	public void getBeneficiaryDetailsTest()
	{
		String str=new String("get beneficiary successfully");
		HttpServletRequest servletRequest=mock(HttpServletRequest.class);
		try {
			doReturn(str).when(mctsOutboundCallDetailService).getBeneficiaryDetails(str,servletRequest);
		} catch (IEMRException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String res=mctsOutboundCallDetailController.getBeneficiaryDetails(str,servletRequest);
		assertTrue(res.contains("\"response\":\"get beneficiary successfully\""));
	}
	@Test
	public void getBeneficiaryDetailsExceptionTest()
	{
		String str=new String("get beneficiary successfully");
		HttpServletRequest servletRequest=mock(HttpServletRequest.class);
		try {
			doThrow(IEMRException.class).when(mctsOutboundCallDetailService).getBeneficiaryDetails(str,servletRequest);
		} catch (IEMRException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String res=mctsOutboundCallDetailController.getBeneficiaryDetails(str,servletRequest);
		assertFalse(res.contains("\"response\":\"get beneficiary successfully\""));
	}
	@Test
	public void getVariablesTest()
	{
		String str=new String("put call history successfully");
		try {
			doReturn(str).when(mctsOutboundCallDetailService).createCallHistory(Mockito.anyString());
		} catch (IEMRException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String res=mctsOutboundCallDetailController.getVariables(Mockito.anyString());
		assertTrue(res.contains("\"response\":\"put call history successfully\""));
		
	}
	@Test
	public void getVariablesExceptionTest()
	{
		try {
			doThrow(IEMRException.class).when(mctsOutboundCallDetailService).createCallHistory(Mockito.anyString());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String res=mctsOutboundCallDetailController.getVariables(Mockito.anyString());
		assertFalse(res.contains("\"response\":\"put call history successfully\""));
		
	}
	@Test
	public void sendSmsAdviseTest()
	{
		String str=new String("SMS sent successfully");
		try {
			doReturn(str).when(mctsOutboundCallDetailService).sendSmsAdvice(Mockito.anyString());
		} catch (IEMRException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String res=mctsOutboundCallDetailController.sendSmsAdvise(Mockito.anyString());
		assertTrue(res.contains("\"response\":\"SMS sent successfully\""));
		
	}
	@Test
	public void sendSmsAdviseExceptionTest()
	{
		try {
			doThrow(IEMRException.class).when(mctsOutboundCallDetailService).sendSmsAdvice(Mockito.anyString());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String res=mctsOutboundCallDetailController.sendSmsAdvise(Mockito.anyString());
		assertFalse(res.contains("\"response\":\"SMS sent successfully\""));
		
	}
	@Test
	public void getSmsAdviseTest()
	{
		String str=new String("get sms advise");
		try {
			doReturn(str).when(mctsOutboundCallDetailService).getSmsAdvice(Mockito.anyString());
		} catch (IEMRException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String res=mctsOutboundCallDetailController.getSmsAdvise(Mockito.anyString());
		assertTrue(res.contains("\"response\":\"get sms advise\""));
		
	}
	@Test
	public void getSmsAdviseExceptionTest()
	{
		try {
			doThrow(IEMRException.class).when(mctsOutboundCallDetailService).getSmsAdvice(Mockito.anyString());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String res=mctsOutboundCallDetailController.getSmsAdvise(Mockito.anyString());
		assertFalse(res.contains("\"response\":\"get sms advise\""));
		
	}

}
