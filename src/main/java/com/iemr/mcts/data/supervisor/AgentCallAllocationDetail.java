package com.iemr.mcts.data.supervisor;

import java.util.List;

import javax.persistence.Transient;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.iemr.mcts.utils.mapper.OutputMapper;

public class AgentCallAllocationDetail {

	@SerializedName("allocateNo")
	@Expose
	private Integer allocateNo;
	
	@SerializedName("providerServiceMapID")
	@Expose
	private Long providerServiceMapID;
	
	@SerializedName("userID")
	@Expose
	private List<Integer> userID;
	
	@SerializedName("mctsOutboundCalls")
	@Expose
	private MctsOutboundCall[] mctsOutboundCalls;
	
	@SerializedName("createdBy")
	@Expose
	private String createdBy;

	/**
	 * @return the allocateNo
	 */
	public Integer getAllocateNo() {
		return allocateNo;
	}

	/**
	 * @param allocateNo the allocateNo to set
	 */
	public void setAllocateNo(Integer allocateNo) {
		this.allocateNo = allocateNo;
	}

	/**
	 * @return the providerServiceMapID
	 */
	public Long getProviderServiceMapID() {
		return providerServiceMapID;
	}

	/**
	 * @param providerServiceMapID the providerServiceMapID to set
	 */
	public void setProviderServiceMapID(Long providerServiceMapID) {
		this.providerServiceMapID = providerServiceMapID;
	}

	/**
	 * @return the userID
	 */
	public List<Integer> getUserID() {
		return userID;
	}

	/**
	 * @param userID the userID to set
	 */
	public void setUserID(List<Integer> userID) {
		this.userID = userID;
	}
	
	/**
	 * @return the mctsOutboundCalls
	 */
	public MctsOutboundCall[] getMctsOutboundCalls() {
		return mctsOutboundCalls;
	}

	/**
	 * @param mctsOutboundCalls the mctsOutboundCalls to set
	 */
	public void setMctsOutboundCalls(MctsOutboundCall[] mctsOutboundCalls) {
		this.mctsOutboundCalls = mctsOutboundCalls;
	}

	/**
	 * @return the createdBy
	 */
	public String getCreatedBy() {
		return createdBy;
	}

	/**
	 * @param createdBy the createdBy to set
	 */
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	/**
	 * custom OutMapper for json String
	 */
	@Transient
	private static OutputMapper outputMapper = new OutputMapper();

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		
		return outputMapper.gson().toJson(this);
	}
	
}
