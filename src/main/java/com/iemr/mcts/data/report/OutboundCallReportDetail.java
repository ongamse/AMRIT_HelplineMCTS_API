package com.iemr.mcts.data.report;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;

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

import lombok.Data;

@Entity
@Data
@Table(name = "db_reporting.fact_mctsoutboundcall", schema = "db_reporting")
public class OutboundCallReportDetail implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
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
	@Column(name = "BeneficiaryRegID")
	private Long beneficiaryRegID;

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
	@Column(name = "CallDateFrom")
	private Date callDateFrom;

	@Expose
	@Column(name = "CallDateTo")
	private Date callDateTo;

	@Expose
	@Column(name = "PrefferedCallDate")
	private Date prefferedCallDate;

	@Expose
	@Column(name = "CallStatus")
	private String callStatus;

	@Expose
	@Column(name = "NoOfTrials")
	private Long NoofTry;

	@Expose
	@Column(name = "AllocationStatus")
	private String allocationStatus;

	@Expose
	@Column(name = "Deleted")
	private Boolean deleted;

	@Expose
	@Column(name = "CreatedBy")
	private String createdBy;

	@Expose
	@Column(name = "CreatedDate", insertable = false, updatable = false)
	private Timestamp createdDate;

	@Expose
	@Column(name = "ModifiedBy")
	private String modifiedBy;

	@Expose
	@Column(name = "LastModDate")
	private Date lastModDate;
	
	@Expose
	@Transient
	private Long callDetailID;
	
	@OneToOne
	@JoinColumn(name = "motherID", referencedColumnName = "MCTSID_no", insertable = false, updatable = false)
	private MotherDataReportDetail motherDataReportDetail;
	
	@OneToOne
	@JoinColumn(name = "childID", referencedColumnName = "MCTSID_no_Child_ID", insertable = false, updatable = false)
	private ChildDataReportDetail childDataReportDetail;

}
