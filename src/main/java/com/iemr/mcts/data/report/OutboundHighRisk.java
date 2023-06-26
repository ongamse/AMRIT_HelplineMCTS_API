package com.iemr.mcts.data.report;



import java.io.Serializable;
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

import lombok.Data;

@Entity
@Data
@Table(name = "db_reporting.fact_mctsoutboundcall", schema = "db_reporting")
public class OutboundHighRisk implements Serializable {

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
	@Column(name = "ProviderServiceMapID")
	private Long providerServiceMapID;
	
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "motherID", referencedColumnName = "MCTSID_no", insertable = false, updatable = false)
	private HighRisk highRisk;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "OutboundHighRisk")
	private List<HighRiskCall> highRiskCall;
	
	
}

