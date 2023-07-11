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
import com.iemr.mcts.data.supervisor.ChildValidDataHandler;
import com.iemr.mcts.data.supervisor.MctsDataReaderDetail;

public class MctsBenificairyUpdateUtils {

	@SerializedName("fieldFor")
	@Expose
	private String fieldFor;
	
	@SerializedName("childValidDataHandler")
	@Expose
	private ChildValidDataHandler childValidDataHandler;
	
	@SerializedName("mctsDataReaderDetail")
	@Expose
	private MctsDataReaderDetail mctsDataReaderDetail;

	/**
	 * @return the fieldFor
	 */
	public String getFieldFor() {
		return fieldFor;
	}

	/**
	 * @param fieldFor the fieldFor to set
	 */
	public void setFieldFor(String fieldFor) {
		this.fieldFor = fieldFor;
	}

	/**
	 * @return the childValidDataHandler
	 */
	public ChildValidDataHandler getChildValidDataHandler() {
		return childValidDataHandler;
	}

	/**
	 * @param childValidDataHandler the childValidDataHandler to set
	 */
	public void setChildValidDataHandler(ChildValidDataHandler childValidDataHandler) {
		this.childValidDataHandler = childValidDataHandler;
	}

	/**
	 * @return the mctsDataReaderDetail
	 */
	public MctsDataReaderDetail getMctsDataReaderDetail() {
		return mctsDataReaderDetail;
	}

	/**
	 * @param mctsDataReaderDetail the mctsDataReaderDetail to set
	 */
	public void setMctsDataReaderDetail(MctsDataReaderDetail mctsDataReaderDetail) {
		this.mctsDataReaderDetail = mctsDataReaderDetail;
	}
	
}
