package com.iemr.mcts.services.report;

public interface CallDetailReportService {

	String getCallDetailReport(String request) throws Exception;

	String getCallDetailReportUnique(String request) throws Exception;
}
