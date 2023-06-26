package com.iemr.mcts.data.supervisor;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.google.gson.annotations.Expose;
import com.iemr.mcts.utils.mapper.OutputMapper;

@Entity
@Table(name = "t_benCall")
public class OutboundCallAnsweredCountDetail {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Expose
	@Column(name = "BenCallID")
	private Long benCallID;

	@Expose
	@Column(name = "CalledServiceID")
	private Long providerServiceMapID;

	@Expose
	@Column(name = "CreatedDate", insertable = false, updatable = false)
	private Timestamp createdDate;
	
	@Expose
	@Column(name = "ReceivedAgentID")
	private Long agentID;
	
	@Expose
	@Column(name = "IsVerified")
	private Boolean isVerified;
	
	@Expose
	@Column(name = "CallTypeID")
	private Long callTypeID;
	
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "callTypeID", referencedColumnName = "CallTypeID", insertable = false, updatable = false)
	@Expose
	private CallType callType;

	
	private static OutputMapper outputMapper = new OutputMapper();


	/**
	 * Default Constructor
	 */
	public OutboundCallAnsweredCountDetail() {

	}

	@Override
	public String toString() {

		return outputMapper.gson().toJson(this);
	}


	public Long getProviderServiceMapID() {
		return providerServiceMapID;
	}

	public void setProviderServiceMapID(Long providerServiceMapID) {
		this.providerServiceMapID = providerServiceMapID;
	}

	public Timestamp getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Timestamp createdDate) {
		this.createdDate = createdDate;
	}

	/**
	 * @return the agentID
	 */
	public Long getAgentID() {
		return agentID;
	}

	/**
	 * @param agentID the agentID to set
	 */
	public void setAgentID(Long agentID) {
		this.agentID = agentID;
	}
	
}
