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

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.core.MediaType;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.iemr.mcts.services.report.CallAnsweredReportService;
import com.iemr.mcts.services.report.CallDetailReportService;
import com.iemr.mcts.services.report.ComplaintReportService;
import com.iemr.mcts.services.report.CongenitalAnomaliesReportService;
import com.iemr.mcts.services.report.DailyReportService;
import com.iemr.mcts.services.report.DataReportService;
import com.iemr.mcts.services.report.HighRiskReportService;
import com.iemr.mcts.services.report.NHMReportService;
import com.iemr.mcts.utils.response.OutputResponse;

import io.swagger.annotations.ApiParam;

@RestController
@RequestMapping("/mctsReportController")
public class MctsReportController {

	Logger logger = LoggerFactory.getLogger(MctsReportController.class);
	
	/**
	 * MctsReportService service
	 */
	private ComplaintReportService complaintReportService;
	
	/**
	 * @param complaintReportService the complaintReportService to set
	 */
	@Autowired
	public void setComplaintReportService(ComplaintReportService complaintReportService) {
		this.complaintReportService = complaintReportService;
	}

	private DataReportService dataReportService;
	/**
	 * @param dataReportService the dataReportService to set
	 */
	@Autowired
	public void setDataReportService(DataReportService dataReportService) {
		this.dataReportService = dataReportService;
	}
	
	private CallDetailReportService callDetailReportService;
	/**
	 * @param callDetailReportService the callDetailReportService to set
	 */
	@Autowired
	public void setCallDetailReportService(CallDetailReportService callDetailReportService) {
		this.callDetailReportService = callDetailReportService;
	}
	
	private NHMReportService nhmReportService;
	/**
	 * @param nhmReportService the nhmReportService to set
	 */
	@Autowired
	public void setNhmReportService(NHMReportService nhmReportService) {
		this.nhmReportService = nhmReportService;
	}
	
	private CongenitalAnomaliesReportService congenitalAnomaliesReportService;

	/**
	 * @param congenitalAnomaliesReportService the congenitalAnomaliesReportService to set
	 */
	@Autowired
	public void setCongenitalAnomaliesReportService(CongenitalAnomaliesReportService congenitalAnomaliesReportService) {
		this.congenitalAnomaliesReportService = congenitalAnomaliesReportService;
	}

	private CallAnsweredReportService callAnsweredReportService;

	/**
	 * @param callAnsweredReportService the callAnsweredReportService to set
	 */
	@Autowired
	public void setCallAnsweredReportService(CallAnsweredReportService callAnsweredReportService) {
		this.callAnsweredReportService = callAnsweredReportService;
	}

	private HighRiskReportService highRiskReportService;

	/**
	 * @param highRiskReportService the highRiskReportService to set
	 */
	@Autowired
	public void setHighRiskReportService(HighRiskReportService highRiskReportService) {
		this.highRiskReportService = highRiskReportService;
	}
	
	private DailyReportService dailyReportService;
	
	/**
	 * @param dailyReportService the dailyReportService to set
	 */
	@Autowired
	public void setDailyReportService(DailyReportService dailyReportService) {
		this.dailyReportService = dailyReportService;
	}

	@Deprecated
	@CrossOrigin
	@RequestMapping(value = "/getComplaintReportDeprecated", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON,
			consumes = MediaType.APPLICATION_JSON, headers = "Authorization")
	public String getComplaintReport(@ApiParam("{\"startDate\":\"Timestamp\", \"endDate\":\"Timestamp\", \"providerServiceMapID\":\"Integer \", \"userID\":\"Integer\"}")
			@RequestBody String request, HttpServletRequest httpRequest)
	{
		OutputResponse response = new OutputResponse();
		logger.info("getComplaintReport request "+request);
		try
		{
			response.setResponse(complaintReportService.getComplaintReport(request));
		} catch (Exception e)
		{
			logger.error("getComplaintReport failed with error " + e.getMessage(), e);
			response.setError(e);
		}
		logger.info("getComplaintReport response " + response.toString());
		return response.toStringWithSerialization();
	}

    @Deprecated
	@CrossOrigin
	@RequestMapping(value = "/getDataReportDeprecated", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON,
			consumes = MediaType.APPLICATION_JSON, headers = "Authorization")
	public String getDataReport(@ApiParam("{\"startDate\":\"Timestamp\", \"endDate\":\"Timestamp\", \"providerServiceMapID\":\"Integer \", \"isMother\":\"Boolean\"}")
			@RequestBody String request, HttpServletRequest httpRequest)
	{
		OutputResponse response = new OutputResponse();
		logger.info("getDataReport request "+request);
		try
		{
			response.setResponse(dataReportService.getDataReport(request));
		} catch (Exception e)
		{
			logger.error("getDataReport failed with error " + e.getMessage(), e);
			response.setError(e);
		}
		logger.info("getDataReport response " + response.toString());
		return response.toStringWithSerialization();
	}
	
	@Deprecated
	@CrossOrigin
	@RequestMapping(value = "/getCallDetailReportDeprecated", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON,
			consumes = MediaType.APPLICATION_JSON, headers = "Authorization")
	public String getCallDetailReport(@ApiParam("{\"startDate\":\"Timestamp\", \"endDate\":\"Timestamp\", \"providerServiceMapID\":\"Integer \", \"userID\":\"Integer\"}")
			@RequestBody String request, HttpServletRequest httpRequest)
	{
		OutputResponse response = new OutputResponse();
		logger.info("getCallDetailReport request "+request);
		try
		{
			response.setResponse(callDetailReportService.getCallDetailReport(request));
		} catch (Exception e)
		{
			logger.error("getCallDetailReport failed with error " + e.getMessage(), e);
			response.setError(e);
		}
		logger.info("getCallDetailReport response " + response.toString());
		return response.toStringWithSerialization();
	}
	@Deprecated
	@CrossOrigin
	@RequestMapping(value = "/getNHMReportDeprecated", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON,
			consumes = MediaType.APPLICATION_JSON, headers = "Authorization")
	public String getNHMReport(@ApiParam("{\"startDate\":\"Timestamp\", \"endDate\":\"Timestamp\", \"providerServiceMapID\":\"Integer \", \"userID\":\"Integer\"}")
			@RequestBody String request, HttpServletRequest httpRequest)
	{
		OutputResponse response = new OutputResponse();
		logger.info("getNHMReport request "+request);
		try
		{
			response.setResponse(nhmReportService.getNHMReport(request));
		} catch (Exception e)
		{
			logger.error("getNHMReport failed with error " + e.getMessage(), e);
			response.setError(e);
		}
		logger.info("getNHMReport response " + response.toString());
		return response.toStringWithSerialization();
	}

	@Deprecated
	@CrossOrigin
	@RequestMapping(value = "/getCallDetailReportUniqueDeprecated", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON,
			consumes = MediaType.APPLICATION_JSON, headers = "Authorization")
	public String getCallDetailReportUnique(@ApiParam("{\"startDate\":\"Timestamp\", \"endDate\":\"Timestamp\", \"providerServiceMapID\":\"Integer \", \"userID\":\"Integer\"}")
			@RequestBody String request, HttpServletRequest httpRequest)
	{
		OutputResponse response = new OutputResponse();
		logger.info("getCallDetailReportUnique request "+request);
		try
		{
			response.setResponse(callDetailReportService.getCallDetailReportUnique(request));
		} catch (Exception e)
		{
			logger.error("getCallDetailReportUnique failed with error " + e.getMessage(), e);
			response.setError(e);
		}
		logger.info("getCallDetailReportUnique response " + response.toString());
		return response.toStringWithSerialization();
	}
	@Deprecated
	@CrossOrigin
	@RequestMapping(value = "/getInvalidRecordReportDeprecated", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON,
			consumes = MediaType.APPLICATION_JSON, headers = "Authorization")
	public String getInvalidRecordReport(@ApiParam("{\"startDate\":\"Timestamp\", \"endDate\":\"Timestamp\", \"providerServiceMapID\":\"Integer \", \"isMother\":\"Boolean\"}")
			@RequestBody String request, HttpServletRequest httpRequest)
	{
		OutputResponse response = new OutputResponse();
		logger.info("getInvalidRecordReport request "+request);
		try
		{
			response.setResponse(dataReportService.getInvalidRecordReport(request));
		} catch (Exception e)
		{
			logger.error("getInvalidRecordReport failed with error " + e.getMessage(), e);
			response.setError(e);
		}
		logger.info("getInvalidRecordReport response " + response.toString());
		return response.toStringWithSerialization();
	}
	
	@Deprecated
	@CrossOrigin
	@RequestMapping(value = "/getCongenitalAnomaliesReportDeprecated", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON,
			consumes = MediaType.APPLICATION_JSON, headers = "Authorization")
	public String getCongenitalAnomaliesReport(@ApiParam("{\"startDate\":\"Timestamp\", \"endDate\":\"Timestamp\", \"providerServiceMapID\":\"Integer \", \"userID\":\"Integer\"}")
			@RequestBody String request, HttpServletRequest httpRequest)
	{
		OutputResponse response = new OutputResponse();
		logger.info("getCongenitalAnomaliesReport request "+request);
		try
		{
			response.setResponse(congenitalAnomaliesReportService.getCongenitalAnomaliesReport(request));
		} catch (Exception e)
		{
			logger.error("getCongenitalAnomaliesReport failed with error " + e.getMessage(), e);
			response.setError(e);
		}
		logger.info("getCongenitalAnomaliesReport response " + response.toString());
		return response.toStringWithSerialization();
	}

	@CrossOrigin
	@Deprecated
	@RequestMapping(value = "/getCallAnsweredReportDeprecated", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON,
			consumes = MediaType.APPLICATION_JSON, headers = "Authorization")
	public String getCallAnsweredReport(@ApiParam("{\"startDate\":\"Timestamp\", \"endDate\":\"Timestamp\", \"providerServiceMapID\":\"Integer \", "
			+ "\"userID\":\"Integer\", \"callTypeName\":\"Answered or Not Answered\"}")
			@RequestBody String request, HttpServletRequest httpRequest)
	{
		OutputResponse response = new OutputResponse();
		logger.info("getCallAnsweredCount request "+request);
		try
		{
			response.setResponse(callAnsweredReportService.getCallAnsweredReport(request));
		} catch (Exception e)
		{
			logger.error("getCallAnsweredCount failed with error " + e.getMessage(), e);
			response.setError(e);
		}
		logger.info("getCallAnsweredCount response " + response.toString());
		return response.toStringWithSerialization();
	}
    @Deprecated
	@CrossOrigin
	@RequestMapping(value = "/getHighRiskReportDeprecated", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON,
			consumes = MediaType.APPLICATION_JSON, headers = "Authorization")
	public String getHighRiskReport(@ApiParam("{\"startDate\":\"Timestamp\", \"endDate\":\"Timestamp\", \"providerServiceMapID\":\"Integer \", \"userID\":\"Integer\"}")
			@RequestBody String request, HttpServletRequest httpRequest)
	{
		OutputResponse response = new OutputResponse();
		logger.info("getHighRiskReport request "+request);
		try
		{
			response.setResponse(highRiskReportService.getHighRiskReport(request));
		} catch (Exception e)
		{
			logger.error("getHighRiskReport failed with error " + e.getMessage(), e);
			response.setError(e);
		}
		logger.info("getHighRiskReport response " + response.toString());
		return response.toStringWithSerialization();
	}
	@Deprecated
	@CrossOrigin
	@RequestMapping(value = "/getDailyReportDeprecated", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON,
			consumes = MediaType.APPLICATION_JSON, headers = "Authorization")
	public String getDailyReport(@ApiParam("{\"startDate\":\"Timestamp\", \"endDate\":\"Timestamp\", \"providerServiceMapID\":\"Integer \", "
			+ "\"userID\":\"Integer\", \"isMother\":\"Boolean\"}")
			@RequestBody String request, HttpServletRequest httpRequest)
	{
		OutputResponse response = new OutputResponse();
		logger.info("getDailyReport request "+request);
		try
		{
			response.setResponse(dailyReportService.getDailyReport(request));
		} catch (Exception e)
		{
			logger.error("getDailyReport failed with error " + e.getMessage(), e);
			response.setError(e);
		}
		logger.info("getDailyReport response " + response.toString());
		return response.toStringWithSerialization();
	}
	
	@Deprecated
	@CrossOrigin
	@RequestMapping(value = "/getCallNotAnsweredReportDeprecated", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON,
			consumes = MediaType.APPLICATION_JSON, headers = "Authorization")
	public String getCallNotAnsweredReport(@ApiParam("{\"startDate\":\"Timestamp\", \"endDate\":\"Timestamp\", \"providerServiceMapID\":\"Integer \", "
			+ "\"userID\":\"Integer\", \"callTypeName\":\"Answered or Not Answered\"}")
			@RequestBody String request, HttpServletRequest httpRequest)
	{
		OutputResponse response = new OutputResponse();
		logger.info("getCallAnsweredCount request "+request);
		try
		{
			response.setResponse(callAnsweredReportService.getCallNotAnsweredReport(request));
		} catch (Exception e)
		{
			logger.error("getCallAnsweredCount failed with error " + e.getMessage(), e);
			response.setError(e);
		}
		logger.info("getCallAnsweredCount response " + response.toString());
		return response.toStringWithSerialization();
	}

	
}
