package com.iemr.mcts.services.secondaryreport;

import java.io.ByteArrayInputStream;

public interface SecondaryDataReportService {
	ByteArrayInputStream getDataReport(String request, String filename) throws Exception;
	ByteArrayInputStream getCallDetailReport(String request, String filename) throws Exception;
	ByteArrayInputStream getCallDetailReportUnique(String request, String filename) throws Exception;
	ByteArrayInputStream getCallAnsweredReport(String request, String filename) throws Exception;
	ByteArrayInputStream getCallNotAnsweredReport(String request, String filename) throws Exception;
	ByteArrayInputStream getHighRiskReport(String request, String filename) throws Exception;
	ByteArrayInputStream getDailyReport(String request, String filename) throws Exception;
	ByteArrayInputStream getNHMReport(String request, String filename) throws Exception;
	ByteArrayInputStream getComplaintReport(String request, String filename) throws Exception;
	ByteArrayInputStream getInvalidRecordReport(String request, String filename) throws Exception;
	ByteArrayInputStream getCongenitalAnomaliesReport(String request, String filename) throws Exception;
}
