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
