package com.iemr.mcts.data.agent;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.google.gson.annotations.Expose;
import com.iemr.mcts.utils.mapper.OutputMapper;

@Entity
@Table(name="m_District")
public class District {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Expose
	@Column(name="DistrictID")
	private Integer districtID;
	@Expose
	@Column(name="DistrictName")
	private String districtName;
	@Expose
	@Column(name="StateID")
	private Integer stateID;
	@Expose
	@Column(name="Deleted", insertable = false, updatable = true)
	private Boolean deleted;
	@Expose
	@Column(name="CreatedBy")
	private String createdBy;
	@Expose
	@Column(name="CreatedDate", insertable = false, updatable = false)
	private Timestamp createdDate;
	@Expose
	@Column(name="ModifiedBy")
	private String modifiedBy;
	@Expose
	@Column(name="LastModDate", insertable = false, updatable = false)
	private Timestamp lastModDate;
	
	
	public Integer getDistrictID() {
		return districtID;
	}



	public void setDistrictID(Integer districtID) {
		this.districtID = districtID;
	}



	public String getDistrictName() {
		return districtName;
	}



	public void setDistrictName(String districtName) {
		this.districtName = districtName;
	}



	public Integer getStateID() {
		return stateID;
	}



	public void setStateID(Integer stateID) {
		this.stateID = stateID;
	}



	public Boolean getDeleted() {
		return deleted;
	}



	public void setDeleted(Boolean deleted) {
		this.deleted = deleted;
	}



	public String getCreatedBy() {
		return createdBy;
	}



	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}



	



	public String getModifiedBy() {
		return modifiedBy;
	}



	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}



	
	
	
	public Timestamp getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Timestamp createdDate) {
		this.createdDate = createdDate;
	}

	public Timestamp getLastModDate() {
		return lastModDate;
	}

	public void setLastModDate(Timestamp lastModDate) {
		this.lastModDate = lastModDate;
	}






	@Transient
	private OutputMapper outputMapper = new OutputMapper();

	@Override
	public String toString() {
		return outputMapper.gson().toJson(this);
	}
	
	

}
