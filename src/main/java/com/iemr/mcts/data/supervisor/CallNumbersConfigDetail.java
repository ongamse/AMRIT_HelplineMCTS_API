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
package com.iemr.mcts.data.supervisor;

import java.sql.Date;

import com.google.gson.annotations.Expose;
import com.iemr.mcts.utils.mapper.OutputMapper;

public class CallNumbersConfigDetail {

	@Expose
	private Integer anc;
	
	@Expose
	private Integer pnc;
	
	@Expose
	private Long providerServiceMapID;
	
	@Expose
	private Date effectiveFrom;
	
	@Expose
	private Date effectiveUpto;
	
	@Expose
	private String createdBy;
	
	private static OutputMapper outputMapper = new OutputMapper();

	/**
	 * @return the anc
	 */
	public Integer getAnc() {
		return anc;
	}

	/**
	 * @param anc the anc to set
	 */
	public void setAnc(Integer anc) {
		this.anc = anc;
	}

	/**
	 * @return the pnc
	 */
	public Integer getPnc() {
		return pnc;
	}

	/**
	 * @param pnc the pnc to set
	 */
	public void setPnc(Integer pnc) {
		this.pnc = pnc;
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
	 * @return the effectiveFrom
	 */
	public Date getEffectiveFrom() {
		return effectiveFrom;
	}

	/**
	 * @param effectiveFrom the effectiveFrom to set
	 */
	public void setEffectiveFrom(Date effectiveFrom) {
		this.effectiveFrom = effectiveFrom;
	}

	/**
	 * @return the effectiveUpto
	 */
	public Date getEffectiveUpto() {
		return effectiveUpto;
	}

	/**
	 * @param effectiveUpto the effectiveUpto to set
	 */
	public void setEffectiveUpto(Date effectiveUpto) {
		this.effectiveUpto = effectiveUpto;
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

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		
		return outputMapper.gson().toJson(this);
	}	
}
