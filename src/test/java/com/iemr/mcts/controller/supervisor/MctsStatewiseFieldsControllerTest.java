package com.iemr.mcts.controller.supervisor;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.doThrow;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;

import com.iemr.mcts.services.supervisor.MctsStatewiseFieldsService;
import com.iemr.mcts.utils.exception.IEMRException;

@RunWith(MockitoJUnitRunner.class)
public class MctsStatewiseFieldsControllerTest {

	@InjectMocks
	MctsStatewiseFieldsController mctsStatewiseFieldsController;
	
	@Mock
	MctsStatewiseFieldsService mctsStatewiseFieldsService;
	
	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void getVariablesTest()
	{
		String str=new String("abc");
		try {
			doReturn(str).when(mctsStatewiseFieldsService).getVariables(Mockito.anyString());
		} catch (IEMRException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String res=mctsStatewiseFieldsController.getVariables(Mockito.anyString());
		assertTrue(res.contains("\"response\":\"abc\""));
	}
	@Test
	public void getVariablesExceptionTest()
	{
		
		try {
			doThrow(Exception.class).when(mctsStatewiseFieldsService).getVariables(Mockito.anyString());
		} catch (IEMRException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String res=mctsStatewiseFieldsController.getVariables(Mockito.anyString());
		assertFalse(res.contains("\"response\":\"abc\""));
	}

}
