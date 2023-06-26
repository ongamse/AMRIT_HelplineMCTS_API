package com.iemr.mcts.data.supervisor;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.google.gson.annotations.Expose;

@Entity
@Table(name="m_filetype")
public class FileTypeDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Expose
	@Column(name="FileTypeID")
	private Integer fileTypeID;

	@Expose
	@Column(name="FileTypeName")
	private String fileTypeName;

	@Expose
	@Column(name="ReadFilePath")
	private String readFilePath;

	@Expose
	@Column(name="FileExtensionType")
	private String fileExtensionType;
	
	@Expose
	@Column(name="ProviderServiceMapID")
	private Long providerServiceMapID;
	
	@Expose
	@Column(name="Deleted")
	private Boolean deleted;

	@Expose
	@Column(name="CreatedBy")
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
