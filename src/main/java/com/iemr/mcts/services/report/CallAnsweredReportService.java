package com.iemr.mcts.services.report;

public interface CallAnsweredReportService {

	String getCallAnsweredReport(String request) throws Exception;
	
	String getCallNotAnsweredReport(String request) throws Exception;
}
