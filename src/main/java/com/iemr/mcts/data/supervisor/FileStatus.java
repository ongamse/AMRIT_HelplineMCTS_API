package com.iemr.mcts.data.supervisor;

import java.sql.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.google.gson.annotations.Expose;

import lombok.Data;

@Data
@Entity
@Table(name = "m_filestatus")
public class FileStatus {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Expose
	@Column(name="FileStatusID")
	private Long fileStatusID;
	
	@Expose
	@Column(name="FileStatus")
	private String fileStatus;
	
	@Expose
	@Column(name="FileStatusDesc")
	private String fileStatusDesc;
	
	@Expose
	@Column(name="Deleted")
	private boolean deleted;
	
	@Expose
	@Column(name="CreatedBy", insertable = true, updatable = false)
	private String createdBy;
	
	@Expose
	@Column(name = "CreatedDate", insertable = false, updatable = false)
	private Date createdDate;
	
	@Expose
	@Column(name="ModifiedBy")
	private String modifiedBy;
	
	@Expose
	@Column(name="LastModDate")
	private Date lastModDate;
}
