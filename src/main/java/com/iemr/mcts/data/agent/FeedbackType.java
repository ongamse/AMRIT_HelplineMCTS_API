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
@Table(name = "m_feedbacktype")
public class FeedbackType {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "FeedbackTypeID")
	@Expose
	private Integer feedbackTypeID;
	@Transient
	@OneToMany(mappedBy = "feedbackType", fetch=FetchType.LAZY)
	private Set<FeedbackDetail> feedbacks;
	

	
	@Column(name = "FeedbackTypeName")
	@Expose
	private String feedbackTypeName;
	@Column(name = "FeedbackDesc")
	@Expose
	private String feedbackDesc;
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

	public FeedbackType() {

	}

	public FeedbackType(Integer feedbackTypeID, String feedbackTypeName) {
		this.feedbackTypeID = feedbackTypeID;
		this.feedbackTypeName = feedbackTypeName;
	}

	public String getFeedbackTypeName()
	{
		return feedbackTypeName;
	}
	
	@Transient
	private OutputMapper outputMapper = new OutputMapper();

	@Override
	public String toString() {
		return outputMapper.gson().toJson(this);
	}
}
