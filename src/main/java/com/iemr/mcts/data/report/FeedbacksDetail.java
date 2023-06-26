package com.iemr.mcts.data.report;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.google.gson.annotations.Expose;
import com.iemr.mcts.utils.mapper.OutputMapper;

import lombok.Data;

@Entity
@Data
@Table(name = "db_reporting.fact_feedback", schema = "db_reporting")
public class FeedbacksDetail implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Fact_FeedbackID")
	private Long feedbackID;

	@Expose
	@Column(name = "FeedbackTypeID")
	private Integer feedbackTypeID;

	@Expose
	@Column(name = "FeedbackNatureID")
	private Integer feedbackNatureID;

	@Expose
	@Column(name = "DesignationID")
	private Integer designationID;
	
	@Expose
	@Column(name = "FeedbackTypeName")
	private String typeOfComplain = "";

	@Expose
	@Column(name = "FeedbackNatureName")
	private String natureOfComplaint;

	@Expose
	@Column(name = "InstitutionName")
	private String instituteName;

	@Expose
	@Column(name = "DesignationName")
	private String designation = "";

	@Expose
	@Column(name = "FeedbackAgainst")
	private String complaintAgainst = "";
	
	@Expose
	@Column(name = "Feedback")
	private String briefofComplaint = "";

	@Transient
	private Timestamp startDate = new Timestamp(0);

	@Transient
	private Timestamp endDate = new Timestamp(Calendar.getInstance().getTimeInMillis());

	@Expose
	@Column(name = "ProviderServiceMapID")
	private Long providerServiceMapID;

	@Expose
	@Column(name = "BenCallID")
	private Long benCallID;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "benCallID", referencedColumnName = "BenCallID", insertable = false, updatable = false)
	@Expose
	private BenCallDetail benCallDetails;
	
	@Expose
	@Transient
	private Boolean isMother;
	
	@Expose
	@Column(name = "CreatedDate")
	private Timestamp createdDate;
	
	@Transient
	private Integer userID;

	@Override
	public String toString()
	{
		return OutputMapper.gsonWithoutExposeRestriction().toJson(this);
	}

}
