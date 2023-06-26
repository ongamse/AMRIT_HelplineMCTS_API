package com.iemr.mcts.controller.report;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Matchers.anyObject;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;

import javax.servlet.http.HttpServletRequest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.iemr.mcts.services.report.ComplaintReportService;


@RunWith(MockitoJUnitRunner.class)
public class MctsReportControllerTest {

	@InjectMocks
	MctsReportController mctsReportController;
	
	@Mock
	ComplaintReportService mctsReportService;
	
	@Test
	public void getComplaintReportBydateTest()
	{
		String str=new String("getComplaintReportBydate successfully");
		try {
			doReturn(str).when(mctsReportService).getComplaintReport(anyObject());
		} catch (Exception e) {
			e.printStackTrace();
		}
		HttpServletRequest httpRequest=mock(HttpServletRequest.class);
		String res=mctsReportController.getComplaintReport(anyObject(),httpRequest);
		assertTrue(res.contains("\"response\":\"getComplaintReportBydate successfully\""));
	}

	@Test
	public void getComplaintReportBydateExceptionTest()
	{
		try {
			doThrow(Exception.class).when(mctsReportService).getComplaintReport(anyObject());
		} catch (Exception e) {
			e.printStackTrace();
		}
		HttpServletRequest httpRequest=mock(HttpServletRequest.class);
		String res=mctsReportController.getComplaintReport(anyObject(),httpRequest);
		assertFalse(res.contains("\"response\":\"getComplaintReportBydate successfully\""));
	}

	}

