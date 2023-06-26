package com.iemr.mcts.data.utils;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.iemr.mcts.data.supervisor.MctsOutboundCall;
import com.iemr.mcts.data.supervisor.MctsQAMappingDetail;

public class MctsCallQAUtils {

	@SerializedName("mctsQAMappingDetail")
	@Expose
	private MctsQAMappingDetail mctsQAMappingDetail; 
	
	@SerializedName("mctsOutboundCall")
	@Expose
	private MctsOutboundCall mctsOutboundCall;
	
	@SerializedName("callDetailID")
	@Expose
	private Long callDetailID;

	/**
	 * @return the mctsQAMappingDetail
	 */
	public MctsQAMappingDetail getMctsQAMappingDetail() {
		return mctsQAMappingDetail;
	}

	/**
	 * @param mctsQAMappingDetail the mctsQAMappingDetail to set
	 */
	public void setMctsQAMappingDetail(MctsQAMappingDetail mctsQAMappingDetail) {
		this.mctsQAMappingDetail = mctsQAMappingDetail;
	}

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
	 * @return the callDetailID
	 */
	public Long getCallDetailID() {
		return callDetailID;
	}

	/**
	 * @param callDetailID the callDetailID to set
	 */
	public void setCallDetailID(Long callDetailID) {
		this.callDetailID = callDetailID;
	}
	
}
