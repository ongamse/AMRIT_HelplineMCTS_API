package com.iemr.mcts.data.agent;

import java.sql.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.google.gson.annotations.Expose;
import com.iemr.mcts.utils.mapper.OutputMapper;

@Entity
@Table(name="m_feedbacknature")
public class FeedBacknatureDetail {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Expose
	@Column(name = "FeedbackNatureID")
	private Integer feedbackNatureID;
	
	@Expose
	@Column(name = "FeedbackNature")
	private String feedbackNature;
	
	@Expose
	@Column(name = "FeedbackNatureDesc")
	private String feedbackNatureDesc;
	
	@Expose
	@Column(name = "FeedbackTypeID")
	private Integer feedbackTypeID;
	
	@Expose
	@Column(name = "Deleted",insertable=false,updatable=true)
	private Boolean deleted;
	
	@Expose
	@Column(name = "CreatedBy")
	private String createdBy;
	
	@Expose
	@Column(name = "CreatedDate",insertable=false,updatable=false)
	private Date createdDate;
	
	@Expose
	@Column(name = "ModifiedBy")
	private String modifiedBy; 
	
	@Expose
	@Column(name = "LastModDate",insertable=false,updatable=false)
	private Date lastModDate; 
	
	@Expose
	@Column(name = "FeedbackTypeName")
	private String feedbackTypeName;
	
	@OneToMany(mappedBy = "feedBacknatureDetail", fetch = FetchType.LAZY)
	@Expose
	private Set<FeedbackDetail> feedbackDetails;

	/**
	 * @return the feedbackNatureID
	 */
	public Integer getFeedbackNatureID() {
		return feedbackNatureID;
	}

	/**
	 * @param feedbackNatureID the feedbackNatureID to set
	 */
	public void setFeedbackNatureID(Integer feedbackNatureID) {
		this.feedbackNatureID = feedbackNatureID;
	}

	/**
	 * @return the feedbackNature
	 */
	public String getFeedbackNature() {
		return feedbackNature;
	}

	/**
	 * @param feedbackNature the feedbackNature to set
	 */
	public void setFeedbackNature(String feedbackNature) {
		this.feedbackNature = feedbackNature;
	}

	/**
	 * @return the feedbackNatureDesc
	 */
	public String getFeedbackNatureDesc() {
		return feedbackNatureDesc;
	}

	/**
	 * @param feedbackNatureDesc the feedbackNatureDesc to set
	 */
	public void setFeedbackNatureDesc(String feedbackNatureDesc) {
		this.feedbackNatureDesc = feedbackNatureDesc;
	}

	/**
	 * @return the feedbackTypeID
	 */
	public Integer getFeedbackTypeID() {
		return feedbackTypeID;
	}

	/**
	 * @param feedbackTypeID the feedbackTypeID to set
	 */
	public void setFeedbackTypeID(Integer feedbackTypeID) {
		this.feedbackTypeID = feedbackTypeID;
	}

	/**
	 * @return the deleted
	 */
	public Boolean getDeleted() {
		return deleted;
	}

	/**
	 * @param deleted the deleted to set
	 */
	public void setDeleted(Boolean deleted) {
		this.deleted = deleted;
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
	 * @return the createdDate
	 */
	public Date getCreatedDate() {
		return createdDate;
	}

	/**
	 * @param createdDate the createdDate to set
	 */
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	/**
	 * @return the modifiedBy
	 */
	public String getModifiedBy() {
		return modifiedBy;
	}

	/**
	 * @param modifiedBy the modifiedBy to set
	 */
	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	/**
	 * @return the lastModDate
	 */
	public Date getLastModDate() {
		return lastModDate;
	}

	/**
	 * @param lastModDate the lastModDate to set
	 */
	public void setLastModDate(Date lastModDate) {
		this.lastModDate = lastModDate;
	}

	/**
	 * @return the feedbackTypeName
	 */
	public String getFeedbackTypeName() {
		return feedbackTypeName;
	}

	/**
	 * @param feedbackTypeName the feedbackTypeName to set
	 */
	public void setFeedbackTypeName(String feedbackTypeName) {
		this.feedbackTypeName = feedbackTypeName;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		
		return OutputMapper.gson().toJson(this);
	}

	
}
