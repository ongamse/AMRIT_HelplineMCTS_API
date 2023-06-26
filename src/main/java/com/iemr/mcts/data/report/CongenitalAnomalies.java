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
@Table(name = "db_reporting.fact_childcongenitalanomalies", schema = "db_reporting")
@Data
public class CongenitalAnomalies implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="Fact_ChildCongenitalAnomaliesID")
	private Integer congenitalAnomaliesID;
	
	@Expose 
	@Column(name="MotherID")
	private Long motherID;
	
	@Expose 
	@Column(name="ChildID")
	private Long childID;
	
	@Expose 
	@Column(name="CongenitalAnomalies")
	private String congenitalAnomalies;
	
	@Expose 
	@Column(name="CauseOfDefect")
	private String causeOfDefect;
	
	@Expose 
	@Column(name="Remarks")
	private String remarks;
	
	@Column(name = "CreatedDate", insertable = false, updatable = false)
	private Timestamp createdDate;

	@Transient
	private Timestamp startDate = new Timestamp(0);

	@Transient
	private Timestamp endDate = new Timestamp(Calendar.getInstance().getTimeInMillis());
	
	@Transient
	private OutputMapper outputMapper = new OutputMapper();
	
	@Column(name = "ProviderServiceMapID")
	private Long providerServiceMapID;
	
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "benCallID", referencedColumnName = "BenCallID", insertable = false, updatable = false)
	@Expose
	private BenCallDetail benCallDetails;
	
	@Column(name = "BenCallID")
	private Long benCallID;
	
	@Transient
	private Integer userID;
	
	@Override
	public String toString()
	{
		return outputMapper.gson().toJson(this);
	}
	

}
