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
@Table(name="m_congenitalanomalies")
public class CongenitalAnomaliesDetail {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Expose
	@Column(name="CongenitalAnomaliesID")
	private Integer congenitalAnomaliesID;
	
	@Expose 
	@Column(name="CongenitalAnomalies")
	private String congenitalAnomalies;
	
	@Expose 
	@Column(name="CongenitalAnomaliesDesc")
	private String congenitalAnomaliesDesc;
	
	@Expose 
	@Column(name="ServiceID")
	private Integer serviceID;
	 
	@Expose
	@Column(name = "Deleted")
	private Boolean deleted;

	@Expose
	@Column(name = "CreatedBy")
	private String createdBy;

	@Expose
	@Column(name = "CreatedDate", insertable = false, updatable = false)
	private Date createdDate;

	@Expose
	@Column(name = "ModifiedBy")
	private Boolean modifiedBy;

	@Expose
	@Column(name = "LastModDate")
	private Date lastModDate;
	
	/**
	 * Default Constructor
	 */
	public CongenitalAnomaliesDetail(){
		
	}
	
	/**
	 * Default Constructor
	 */
	public CongenitalAnomaliesDetail(Integer congenitalAnomaliesID, String congenitalAnomalies){
		
		this.congenitalAnomaliesID = congenitalAnomaliesID;
		this.congenitalAnomalies = congenitalAnomalies;
	}

	/**
	 * @return the congenitalAnomaliesID
	 */
	public Integer getCongenitalAnomaliesID() {
		return congenitalAnomaliesID;
	}

	/**
	 * @param congenitalAnomaliesID the congenitalAnomaliesID to set
	 */
	public void setCongenitalAnomaliesID(Integer congenitalAnomaliesID) {
		this.congenitalAnomaliesID = congenitalAnomaliesID;
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
	 * @return the congenitalAnomaliesDesc
	 */
	public String getCongenitalAnomaliesDesc() {
		return congenitalAnomaliesDesc;
	}

	/**
	 * @param congenitalAnomaliesDesc the congenitalAnomaliesDesc to set
	 */
	public void setCongenitalAnomaliesDesc(String congenitalAnomaliesDesc) {
		this.congenitalAnomaliesDesc = congenitalAnomaliesDesc;
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

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		
		return OutputMapper.gson().toJson(this);
	}
}
