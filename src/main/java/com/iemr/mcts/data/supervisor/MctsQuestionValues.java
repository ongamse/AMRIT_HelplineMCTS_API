package com.iemr.mcts.data.supervisor;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.google.gson.annotations.Expose;

@Entity
@Table(name = "m_questionnairevalues")
public class MctsQuestionValues {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Expose
	@Column(name = "QuestionValuesID")
	private Integer questionValuesID;
	
	@Expose
	@Column(name = "QuestionID")
	private Integer questionID;
	
	@Expose
	@Column(name = "QuestionValues")
	private String dropDownOptions;
	
	@Expose
	@Column(name = "ProviderServiceMapID")
	private Long providerServiceMapID;
	
	@Expose
	@Column(name = "Deleted")
	private Boolean deleted = false;

	@Expose
	@Column(name = "Processed", insertable = false, updatable = true)
	private String processed;

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
	
	@Transient
	@Expose
	private Boolean isDisabled;
	
	
//	@OneToMany(fetch = FetchType.LAZY, mappedBy = "mctsQuestionValues")
//	private QuestionnaireDetail questionnaireDetail;
	
//	@OneToOne(fetch = FetchType.LAZY, mappedBy = "mctsQuestionValues")
//	private MctsQAMappingDetail mctsQAMappingDetail;

	public Integer getQuestionValuesID() {
		return questionValuesID;
	}

	public void setQuestionValuesID(Integer questionValuesID) {
		this.questionValuesID = questionValuesID;
	}

	public Integer getQuestionID() {
		return questionID;
	}

	public void setQuestionID(Integer questionID) {
		this.questionID = questionID;
	}	

	public Boolean getDeleted() {
		return deleted;
	}

	public void setDeleted(Boolean deleted) {
		this.deleted = deleted;
	}

	public String getProcessed() {
		return processed;
	}

	public void setProcessed(String processed) {
		this.processed = processed;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Boolean getModifiedBy() {
		return modifiedBy;
	}

	public void setModifiedBy(Boolean modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	public Date getLastModDate() {
		return lastModDate;
	}

	public void setLastModDate(Date lastModDate) {
		this.lastModDate = lastModDate;
	}

	public String getDropDownOptions() {
		return dropDownOptions;
	}

	public void setDropDownOptions(String dropDownOptions) {
		this.dropDownOptions = dropDownOptions;
	}

//	public QuestionnaireDetail getQuestionnaireDetail() {
//		return questionnaireDetail;
//	}
//
//	public void setQuestionnaireDetail(QuestionnaireDetail questionnaireDetail) {
//		this.questionnaireDetail = questionnaireDetail;
//	}

	public Long getProviderServiceMapID() {
		return providerServiceMapID;
	}

	public void setProviderServiceMapID(Long providerServiceMapID) {
		this.providerServiceMapID = providerServiceMapID;
	}

	
	
	
}
