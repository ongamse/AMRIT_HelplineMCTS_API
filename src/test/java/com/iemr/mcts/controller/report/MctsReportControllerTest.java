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

