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

import com.iemr.mcts.services.agent.MctsDataTransactionService;
import com.iemr.mcts.utils.exception.IEMRException;

@RunWith(MockitoJUnitRunner.class)
public class MctsDataTransactionControllerTest {

	@InjectMocks
	MctsDataTransactionController mctsDataTransactionController;
	
	@Mock
	MctsDataTransactionService mctsDataTransactionService;
	
	@Test
	public void updateDataTest()
	{
		String str=new String("update mctsdata successfully");
		try {
			//doReturn(str).when(mctsDataTransactionService).updateData(Mockito.anyString());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//String res=mctsDataTransactionController.updateData(Mockito.anyString());
		//assertTrue(res.contains("\"response\":\"update mctsdata successfully\""));
	}
	@Test
	public void updateDataExceptionTest()
	{
		try {
			//doThrow(IEMRException.class).when(mctsDataTransactionService).updateData(Mockito.anyString());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//String res=mctsDataTransactionController.updateData(Mockito.anyString());
		//assertFalse(res.contains("\"response\":\"update mctsdata successfully\""));
	}

}
