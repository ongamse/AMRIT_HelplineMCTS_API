package com.iemr.mcts.data.report;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.google.gson.annotations.Expose;
import com.iemr.mcts.utils.mapper.OutputMapper;

import lombok.Data;

@Entity
@Table(name = "db_reporting.fact_bencall", schema = "db_reporting")
@Data
public class CallDetailReport implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="Fact_BenCallID")
	private Long callDetailID;
	
	@Column(name="ReceivedAgentID")
	@Expose
	private Long userID;
	
	@Column(name = "CallTime")
	@Expose
	private Timestamp callTime;
	
	@Column(name = "PhoneNo")
	@Expose
	private String phoneNumber = "";
	
	@Column(name = "CallClosureType")
	@Expose
	private String status;
	
	@Column(name = "Remarks")
	@Expose
	private String remarks;
	
	@Column(name = "ProviderServiceMapID")
	private Long providerServiceMapID;
	
	@Transient
	private Timestamp startDate = new Timestamp(0);

	@Transient
	private Timestamp endDate = new Timestamp(Calendar.getInstance().getTimeInMillis());
	
	@Column(name = "CreatedDate")
	private Timestamp createdDate;
	
	@Column(name = "OBCallID")
	private Long obCallID;
	
	@Column(name = "BenCallID")
	private Long benCallID;
	
	@Column(name = "CallTypeName")
	private String callTypeName; 
	
	@Transient
	private OutputMapper outputMapper = new OutputMapper();
	
	@OneToOne
	@JoinColumn(name = "obCallID", referencedColumnName = "OBCallID", insertable = false, updatable = false)
	private OutboundCallReportDetail outboundCallReportDetail;
	
	@Override
	public String toString()
	{
		return outputMapper.gson().toJson(this);
	}
	
	@Expose
	@Column(name = "IsMother")
	private Boolean isMother; 

}
