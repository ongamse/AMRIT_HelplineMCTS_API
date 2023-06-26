package com.iemr.mcts.data.report;

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
@Table(name = "db_reporting.fact_bencall", schema = "db_reporting")
@Data
public class NHMDetail {

	
	@Id
	@Column(name="Fact_BenCallID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long nhmReportDetailID;
	
	@Expose
	@Column(name = "BenCallID")
	private String benCallID;
	
	@Expose
	@Column(name = "OBCallID")
	private Long obCallID;
	
	@Column(name = "CallTime")
	@Expose
	private Timestamp date;
	
	@Expose
	@Column(name = "Category")
	private String category;
	
	@Expose
	@Column(name = "PhoneNo")
	private String phoneNumber;
	
	@Expose
	@Column(name = "Remarks")
	private String remark;
	
	@Transient
	private Timestamp startDate = new Timestamp(0);

	@Transient
	private Timestamp endDate = new Timestamp(Calendar.getInstance().getTimeInMillis());
	
	@Transient
	private OutputMapper outputMapper = new OutputMapper();
	
	@Column(name = "ProviderServiceMapID")
	private Long providerServiceMapID;
	
	@Column(name = "CreatedDate")
	private Timestamp createdDate;

	@Override
	public String toString()
	{
		return outputMapper.gson().toJson(this);
	}
	
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "OBCallID", referencedColumnName = "OBCallID", insertable = false, updatable = false)
	@Expose
	private OBdetail obdetail;
	
	
	
	
}
