package com.iemr.mcts.utils.km;

public interface KMService
{
	String getDocumentRoot();
	
	String createDocument(String documentPath, String filepath);
}
