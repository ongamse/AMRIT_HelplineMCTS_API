package com.iemr.mcts.data.agent;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.google.gson.annotations.Expose;
import com.iemr.mcts.utils.mapper.OutputMapper;

@Entity
@Table(name="t_childcongenitalanomalies")
public class ChildCongenitalAnomaliesDetail {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Expose
	@Column(name="ID")
	private Long id;
	
	@Expose
	@Column(name="BeneficiaryRegID")
	private Long beneficiaryRegID;
	
	@Expose
	@Column(name="MotherID")
	private Long motherID;
	
	@Expose
	@Column(name="ChildID")
	private Long childID;
	
	@Expose
	@Column(name="ProviderServiceMapID")
	private Long providerServiceMapID;
	
	@Expose
	@Column(name="BenCallID")
	private Long callDetailID;
	
	@Expose
	@Column(name="CongenitalAnomalies")
	private String congenitalAnomalies;
	
	@Expose
	@Column(name="CauseOfDefect")
	private String causeOfDefect;
	
	@Expose
	@Column(name="Remarks")
	private String remarks;
	
	@Expose
	@Column(name="Deleted")
	private boolean deleted;
	
	@Expose
	@Column(name="CreatedBy")
	private String createdBy;
	
	@Expose
	@Column(name = "CreatedDate", insertable = false, updatable = false)
	private Date createdDate;
	
	@Expose
	@Column(name="ModifiedBy")
	private String modifiedBy;
	
	@Expose
	@Column(name="LastModDate")
	private Date lastModDate;

	/**
	 * @return the childID
	 */
	public Long getChildID() {
		return childID;
	}

	/**
	 * @param childID the childID to set
	 */
	public void setChildID(Long childID) {
		this.childID = childID;
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

	/**
	 * @return the congenitalAnomalies
	 */
	public String getCongenitalAnomalies() {
		return congenitalAnomalies;
	}

	/**
	 * @param congenitalAnomalies the congenitalAnomalies to set
	 */
	public void setCongenitalAnomalies(String congenitalAnomalies) {
		this.congenitalAnomalies = congenitalAnomalies;
	}

	/**
	 * @return the causeOfDefect
	 */
	public String getCauseOfDefect() {
		return causeOfDefect;
	}

	/**
	 * @param causeOfDefect the causeOfDefect to set
	 */
	public void setCauseOfDefect(String causeOfDefect) {
		this.causeOfDefect = causeOfDefect;
	}
	
	/**
	 * @return the beneficiaryRegID
	 */
	public Long getBeneficiaryRegID() {
		return beneficiaryRegID;
	}

	/**
	 * @param beneficiaryRegID the beneficiaryRegID to set
	 */
	public void setBeneficiaryRegID(Long beneficiaryRegID) {
		this.beneficiaryRegID = beneficiaryRegID;
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
	 * @return the motherID
	 */
	public Long getMotherID() {
		return motherID;
	}

	/**
	 * @param motherID the motherID to set
	 */
	public void setMotherID(Long motherID) {
		this.motherID = motherID;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return OutputMapper.gson().toJson(this);
	}
}
