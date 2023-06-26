package com.iemr.mcts.services.report;

public interface DataReportService {

	String getDataReport(String request) throws Exception;

	String getInvalidRecordReport(String request) throws Exception;
}
