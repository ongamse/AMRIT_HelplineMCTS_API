package com.iemr.mcts.data.agent;

import java.sql.Timestamp;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.google.gson.annotations.Expose;
import com.iemr.mcts.utils.mapper.OutputMapper;

@Entity
@Table(name = "m_designation")
public class Designation
{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "DesignationID")
	@Expose
	private Integer designationID;
	@Column(name = "DesignationName")
	@Expose
	private String designationName;
	@Column(name = "DesignationDesc")
	@Expose
	private String designationDesc;
	@Column(name = "Deleted", insertable = false, updatable = true)
	@Expose
	private Boolean deleted;
	@Column(name = "CreatedBy")
	@Expose
	private String createdBy;
	@Column(name = "CreatedDate")
	private Timestamp createdDate;
	@Column(name = "ModifiedBy")
	private String modifiedBy;
	@Column(name = "LastModDate")
	private Timestamp lastModDate;

	@OneToMany(mappedBy = "designation", fetch = FetchType.LAZY)
	@Transient
	@Expose
	private Set<FeedbackDetail> feedbackDetails;

	public Designation()
	{

	}

	public Integer getDesignationID()
	{
		return designationID;
	}

	public void setDesignationID(int designationID)
	{
		this.designationID = designationID;
	}

	public String getDesignationName()
	{
		return designationName;
	}

	public void setDesignationName(String designationName)
	{
		this.designationName = designationName;
	}

	public String getDesignationDesc()
	{
		return designationDesc;
	}

	public void setDesignationDesc(String designationDesc)
	{
		this.designationDesc = designationDesc;
	}

	public Boolean getDeleted()
	{
		return deleted;
	}

	public void setDeleted(Boolean deleted)
	{
		this.deleted = deleted;
	}

	public String getCreatedBy()
	{
		return createdBy;
	}

	public void setCreatedBy(String createdBy)
	{
		this.createdBy = createdBy;
	}

	public Timestamp getCreatedDate()
	{
		return createdDate;
	}

	public void setCreatedDate(Timestamp createdDate)
	{
		this.createdDate = createdDate;
	}

	public String getModifiedBy()
	{
		return modifiedBy;
	}

	public void setModifiedBy(String modifiedBy)
	{
		this.modifiedBy = modifiedBy;
	}

	public Timestamp getLastModDate()
	{
		return lastModDate;
	}

	public void setLastModDate(Timestamp lastModDate)
	{
		this.lastModDate = lastModDate;
	}

	@Transient
	OutputMapper mapper = new OutputMapper();

	@Override
	public String toString()
	{
		return mapper.gson().toJson(this);
	}
}
