package com.iemr.mcts.data.utils;

import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.iemr.mcts.data.supervisor.MctsOutboundCall;

public class ReallocationDataUtil {
	
	@SerializedName("mctsOutboundCall")
	@Expose
	private MctsOutboundCall mctsOutboundCall;
	
	@SerializedName("userIDs")
	@Expose
	private List<Integer> userIDs;
	
	@SerializedName("recordType")
	@Expose
	private String recordType;

	/**
	 * @return the mctsOutboundCall
	 */
	public MctsOutboundCall getMctsOutboundCall() {
		return mctsOutboundCall;
	}

	/**
	 * @param mctsOutboundCall the mctsOutboundCall to set
	 */
	public void setMctsOutboundCall(MctsOutboundCall mctsOutboundCall) {
		this.mctsOutboundCall = mctsOutboundCall;
	}

	/**
	 * @return the userIDs
	 */
	public List<Integer> getUserIDs() {
		return userIDs;
	}

	/**
	 * @param userIDs the userIDs to set
	 */
	public void setUserIDs(List<Integer> userIDs) {
		this.userIDs = userIDs;
	}

	/**
	 * @return the recordType
	 */
	public String getRecordType() {
		return recordType;
	}

	/**
	 * @param recordType the recordType to set
	 */
	public void setRecordType(String recordType) {
		this.recordType = recordType;
	}
}
