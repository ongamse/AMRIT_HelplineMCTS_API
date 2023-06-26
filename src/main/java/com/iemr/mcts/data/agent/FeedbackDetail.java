package com.iemr.mcts.data.agent;

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
import javax.persistence.Transient;

import com.google.gson.annotations.Expose;
import com.iemr.mcts.utils.mapper.OutputMapper;

@Entity
@Table(name = "t_feedback")
public class FeedbackDetail
{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "FeedbackID")
	@Expose
	private Long feedbackID;

	@Column(name = "DesignationID")
	@Expose
	private Integer designationID;
	
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "DesignationID", insertable = false, updatable = false)
	@Expose
	private Designation designation;

	@Column(name = "FeedbackTypeID")
	@Expose
	private Integer feedbackTypeID;
	
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "FeedbackTypeID", insertable = false, updatable = false)
	@Expose
	private FeedbackType feedbackType;
	
	@Expose
	@Column(name = "FeedbackNatureID")
	private Integer feedbackNatureID;
	
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "FeedbackNatureID", insertable = false, updatable = false)
	@Expose
	private FeedBacknatureDetail feedBacknatureDetail;

	@Column(name = "BeneficiaryRegID")
	@Expose
	private Long beneficiaryRegID;

	@Column(name = "ProviderServiceMapID")
	@Expose
	private Long ProviderServiceMapID;
	
	@Column(name = "Deleted", insertable = false, updatable = true)
	@Expose
	private Boolean deleted;
	
	@Column(name = "CreatedBy")
	@Expose
	private String createdBy;
	
	@Column(name = "CreatedDate", insertable = false, updatable = false)
	@Expose
	private Timestamp createdDate;
	
	@Column(name = "ModifiedBy")
	@Expose
	private String modifiedBy;
	
	@Column(name = "LastModDate", insertable = false, updatable = false)
	@Expose
	private Timestamp lastModDate;

	@Column(name = "FeedbackStatusID")
	@Expose
	private Integer feedbackStatusID;

	@Column(name = "Feedback")
	@Expose
	private String feedback;

	@Transient
	@Expose
	private Integer subServiceID;

	public FeedbackDetail()
	{

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

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return OutputMapper.gson().toJson(this);
	}

	
}
