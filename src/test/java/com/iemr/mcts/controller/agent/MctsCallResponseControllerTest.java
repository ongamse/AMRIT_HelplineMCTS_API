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

import com.iemr.mcts.services.agent.MctsCallResponseService;
import com.iemr.mcts.utils.exception.IEMRException;

@RunWith(MockitoJUnitRunner.class)
public class MctsCallResponseControllerTest {

	@InjectMocks
	MctsCallResponseController mctsCallResponseController;
	
	@Mock
	MctsCallResponseService mctsCallResponseService;
	
	@Test
	public void saveMctsCallResponseTest()
	{
		String str=new String("Response have been added successfully");
		try {
			doReturn(str).when(mctsCallResponseService).saveMctsCallResponse(Mockito.anyString());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String res=mctsCallResponseController.putMctsCallResponse(Mockito.anyString());
		assertTrue(res.contains("\"response\":\"Response have been added successfully\""));
		
	}
	@Test
	public void saveMctsCallResponseExceptionTest()
	{
		try {
			doThrow(IEMRException.class).when(mctsCallResponseService).saveMctsCallResponse(Mockito.anyString());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String res=mctsCallResponseController.putMctsCallResponse(Mockito.anyString());
		assertFalse(res.contains("\"response\":\"Response have been added successfully\""));
		
	}
	@Test
	public void getMctsCallResponseTest()
	{
		String str=new String("get call response");
		try {
			doReturn(str).when(mctsCallResponseService).getMctsCallResponse(Mockito.anyString());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String res=mctsCallResponseController.getMctsCallResponse(Mockito.anyString());
		assertTrue(res.contains("\"response\":\"get call response\""));
		
	}
	@Test
	public void getMctsCallResponseExceptionTest()
	{
		try {
			doThrow(IEMRException.class).when(mctsCallResponseService).getMctsCallResponse(Mockito.anyString());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String res=mctsCallResponseController.getMctsCallResponse(Mockito.anyString());
		assertFalse(res.contains("\"response\":\"get call response\""));
		
	}
	@Test
	public void updateMctsCallResponseTest()
	{
		String str=new String("Updated answer successfully");
		try {
			doReturn(str).when(mctsCallResponseService).updateMctsCallResponse(Mockito.anyString());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String res=mctsCallResponseController.updateMctsCallResponse(Mockito.anyString());
		assertTrue(res.contains("\"response\":\"Updated answer successfully\""));
		
	}
	@Test
	public void updateMctsCallResponseExceptionTest()
	{
		try {
			doThrow(IEMRException.class).when(mctsCallResponseService).updateMctsCallResponse(Mockito.anyString());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String res=mctsCallResponseController.updateMctsCallResponse(Mockito.anyString());
		assertFalse(res.contains("\"response\":\"Updated answer successfully\""));
		
	}

}
