package com.iemr.mcts.data.report;


import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.google.gson.annotations.Expose;
import com.iemr.mcts.utils.mapper.OutputMapper;

import lombok.Data;

@Entity
@Data
@Table(name = "db_reporting.fact_mctsoutboundcall", schema = "db_reporting")
public class OBdetail implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Fact_MctsOutboundCallID")
	private Long Fact_MctsOutboundCallID;
	
	@Expose
	@Column(name = "OBCallID")
	private Long obCallID;
	
	@Expose
	@Column(name = "MotherID", insertable = false, updatable = false)
	private Long motherID;

	@Expose
	@Column(name = "ChildID")
	private Long childID;

	@Expose
	@Column(name = "AllocatedUserID", insertable = false, updatable = false)
	private Integer allocatedUserID;

	@Expose
	@Column(name = "ProviderServiceMapID")
	private Long providerServiceMapID;

	@Expose
	@Column(name = "OutboundCallType")
	private String outboundCallType;
	
	@Expose
	@Column(name = "DisplayOBCallType")
	private String displayOBCallType;

	@Expose
	@Column(name = "CreatedDate", insertable = false, updatable = false)
	private Timestamp createdDate;
	
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "motherID", referencedColumnName = "MCTSID_no", insertable = false, updatable = false)
	@Expose
	private MotherDetail motherDetail;
	
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "childID", referencedColumnName = "MCTSID_no_Child_ID", insertable = false, updatable = false)
	@Expose
	private ChildDetail childDetail;
	
//	@OneToMany(fetch = FetchType.EAGER)
//	@JoinColumn(name = "motherID", referencedColumnName = "motherID", insertable = false, updatable = false)
//	@Expose
//	private List<CallResponseReportDetail> callResponseReportDetail;
	
	
	@Expose
	@Column(name = "NoOfTrials")
	private Integer count;
	
	@Override
	public String toString() {

		return OutputMapper.gsonWithoutExposeRestriction().toJson(this);
	}


}
