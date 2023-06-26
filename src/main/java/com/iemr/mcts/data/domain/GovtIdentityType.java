package com.iemr.mcts.data.domain;

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

import lombok.Data;

@Data
@Entity
@Table(name = "m_govtidentitytype")
public class GovtIdentityType {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "GovtIdentityTypeID")
	@Expose
	private Integer govtIdentityTypeID;

	@Column(name = "IdentityType")
	@Expose
	private String identityType;

	@Column(name = "IsGovtID")
	@Expose
	private Boolean isGovtID;

	@Column(name = "Deleted", insertable = false, updatable = true)
	@Expose
	private Boolean deleted;
	@Column(name = "CreatedBy")
	@Expose
	private String createdBy;
	@Column(name = "CreatedDate", insertable = false, updatable = false)
	private Timestamp createdDate;
	@Column(name = "ModifiedBy")
	private String modifiedBy;
	@Column(name = "LastModDate", insertable = false, updatable = false)
	private Timestamp lastModDate;

	public GovtIdentityType() {

	}

	public GovtIdentityType(Integer govtIdentityTypeID, String identityType, Boolean isGovID) {
		this.identityType = identityType;
		this.govtIdentityTypeID = govtIdentityTypeID;
		this.isGovtID = isGovID;
	}

	@Transient
	private OutputMapper outputMapper = new OutputMapper();

	@Override
	public String toString() {
		return outputMapper.gson().toJson(this);
	}

}
