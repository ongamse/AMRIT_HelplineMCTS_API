package com.iemr.mcts.data.report;


import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.List;

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

import lombok.Data;

@Entity
@Table(name = "db_reporting.fact_mothervalidrecord", schema = "db_reporting")
@Data
public class HighRisk implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Fact_MotherValidRecordID")
	private Long motherValidRecordID;

	@Expose
	@Column(name = "District_Name")
	private String districtName;
	
	@Expose
	@Column(name = "Taluka_Name")
	private String talukaName;
	
	@Expose
	@Column(name = "Block_Name")
	private String blockName;

	@Expose
	@Column(name = "PHC_ID")
	private String PHCID;

	@Expose
	@Column(name = "PHC_Name")
	private String PHCName;
	
	@Expose
	@Column(name = "SUBPHC_ID")
	private String SUBPHCID;
	
	@Expose
	@Column(name = "SUBPHC_Name")
	private String SUBPHCName;
	
	@Expose
	@Column(name = "MCTSID_no")
	private Long mctsIDNo;

	@Expose
	@Column(name = "Name")
	private String name;
	
	@Expose
	@Column(name = "Husband_Name")
	private String husbandName;

	@Expose
	@Column(name = "PhoneNo_Of_Whom")
	private String phoneNoOfWhom;

	@Expose
	@Column(name = "Whom_PhoneNo")
	private String whomPhoneNo;

	@Expose
	@Column(name = "Birth_Date")
	private Date birthDate;

	@Expose
	@Column(name = "Age")
	private Long age;
	
	@Expose
	@Column(name = "LMP_Date")
	private Date lmpDate;
	
	@Expose
	@Column(name = "Remarks")
	private String remarks;
	
	@Column(name = "ProviderServiceMapID")
	private Long providerServiceMapID;
	
	@Transient
	private Timestamp startDate = new Timestamp(0);

	@Transient
	private Timestamp endDate = new Timestamp(Calendar.getInstance().getTimeInMillis());
	
	@Column(name = "CreatedDate")
	private Timestamp createdDate;
	
	@Column(name = "BeneficiaryRegID")
	private Long beneficiaryRegID;
	
	@Expose
	@Column(name = "High_Risk")
	private Boolean HighRisk;
	
	@Expose
	@Column(name = "High_Risk_Reason")
	private String HighRiskReason;
	
	@Expose
	@Column(name = "EDD")
	private Date edd;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "highRisk")
	private List<OutboundHighRisk> outboundHighRisk;
	

	@Override
	public String toString()
	{
		return OutputMapper.gsonWithoutExposeRestriction().toJson(this);
	}
	
}
