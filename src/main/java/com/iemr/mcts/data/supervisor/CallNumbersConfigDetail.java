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
