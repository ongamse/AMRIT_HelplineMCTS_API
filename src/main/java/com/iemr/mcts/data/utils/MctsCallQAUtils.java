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
