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
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.google.gson.annotations.Expose;
import com.iemr.mcts.utils.mapper.OutputMapper;

import lombok.Data;

@Entity
@Table(name = "db_reporting.fact_bencall", schema = "db_reporting")
@Data
public class HighRiskCall implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "BenCallID") 
	private Long callDetailID;

	@Column(name = "CallReceivedUserID") 
	private Integer allocatedUserID;
	
	@Column(name = "ReceivedAgentID")
	private Integer userID;
	
	@Expose
	@Column(name = "PhoneNo")
	private String phoneNo;

	@Column(name = "ProviderServiceMapID")
	private Long providerServiceMapID;

	@Expose
	@Column(name = "SubCategory")
	private String outboundCallType;

	@Expose
	@Column(name = "Remarks")
	private String remark;

	@Column(name = "CreatedDate")
	private Timestamp createdDate;

	@Expose
	@Column(name = "CallTypeName")
	private String callTypeName;  
	
	@Expose
	@Column(name = "CallSubTypeName")
	private String callSubTypeName;
	
	@Column(name = "OBCallID")
	private Timestamp obCallID;
	
	@Column(name = "IsMother")
	private Boolean isMother;

	@Transient
	private Timestamp startDate = new Timestamp(0);

	@Transient
	private Timestamp endDate = new Timestamp(Calendar.getInstance().getTimeInMillis());
	
	@Transient
	private OutputMapper outputMapper = new OutputMapper();
	
	@Override
	public String toString()
	{
		return outputMapper.gson().toJson(this);
	}
	
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "obCallID", referencedColumnName = "OBCallID", insertable = false, updatable = false)
	@Expose
	private OutboundHighRisk OutboundHighRisk;
}