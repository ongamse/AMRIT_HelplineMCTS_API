package com.iemr.mcts.data.supervisor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.google.gson.annotations.Expose;
import com.iemr.mcts.utils.mapper.OutputMapper;

@Entity
@Table(name="m_providerservicemapping")
public class ProviderServiceMapDetail {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ProviderServiceMapID")
	@Expose
	private Long providerServiceMapID;
	
	@Column(name="ServiceID")
	@Expose
	private Integer serviceID;
	
	@Column(name="StateID")
	@Expose
	private Integer stateID;

	@Column(name="Deleted")
	private boolean deleted;

	/**
	 * Default Constructor
	 */
	public ProviderServiceMapDetail() {
		super();
	}

	/**
	 * 
	 * @param serviceID
	 * @param stateID
	 */
	public ProviderServiceMapDetail(Integer serviceID, Integer stateID) {
		super();
		this.serviceID = serviceID;
		this.stateID = stateID;
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
	 * @return the serviceID
	 */
	public Integer getServiceID() {
		return serviceID;
	}

	/**
	 * @param serviceID the serviceID to set
	 */
	public void setServiceID(Integer serviceID) {
		this.serviceID = serviceID;
	}

	/**
	 * @return the stateID
	 */
	public Integer getStateID() {
		return stateID;
	}

	/**
	 * @param stateID the stateID to set
	 */
	public void setStateID(Integer stateID) {
		this.stateID = stateID;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return OutputMapper.gson().toJson(this);
	}

}
