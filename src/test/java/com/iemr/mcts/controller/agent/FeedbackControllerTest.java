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

import com.iemr.mcts.services.agent.FeedbackService;
import com.iemr.mcts.utils.exception.IEMRException;

@RunWith(MockitoJUnitRunner.class)
public class FeedbackControllerTest {

	@InjectMocks
	FeedbackController feedbackController;
	
	@Mock
	FeedbackService feedbackService;
	
	@Test
	public void feedBackListTest()
	{
		String str=new String("complaint list");
		try {
			doReturn(str).when(feedbackService).getFeedBackList(Mockito.anyString());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String res=feedbackController.feedBackList(Mockito.anyString());
		assertTrue(res.contains("\"response\":\"complaint list\""));
	}
	@Test
	public void feedBackListExceptionTest()
	{
		try {
			doThrow(IEMRException.class).when(feedbackService).getFeedBackList(Mockito.anyString());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String res=feedbackController.feedBackList(Mockito.anyString());
		assertFalse(res.contains("\"response\":\"complaint list\""));
	}

}
