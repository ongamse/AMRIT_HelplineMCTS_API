package com.iemr.mcts.data.supervisor;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.google.gson.annotations.Expose;
import com.iemr.mcts.utils.mapper.OutputMapper;

@Entity
@Table(name="m_MctsFieldsStatewise")
public class MctsStatewiseFieldsDetail {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Expose
	@Column(name="SlNo")
	private Integer slNo;
	
	@Expose
	@Column(name="StateID")
	private Integer stateID;
	
	@Expose
	@Column(name="DataFields")
	private String dataFields;
	
	@Expose
	@Column(name="FieldsFor")
	private String fieldFor;
	
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
	
	/**
	 * Default Constructor
	 */
	public MctsStatewiseFieldsDetail(){
		
	}
	
	/**
	 * Parameter Constructor
	 */
	public MctsStatewiseFieldsDetail(String dataFields, String fieldFor){
		
		this.dataFields = dataFields;
		this.fieldFor = fieldFor;
	}
	
	/**
	 * @return the providerServiceMapID
	 */
	public Long getProviderServiceMapID() {
		return providerServiceMapID;
	}

	/**
	 * @return the dataFields
	 */
	public String getDataFields() {
		return dataFields;
	}

	/**
	 * @return the fieldFor
	 */
	public String getFieldFor() {
		return fieldFor;
	}
	
	/**
	 * @param providerServiceMapID the providerServiceMapID to set
	 */
	public void setProviderServiceMapID(Long providerServiceMapID) {
		this.providerServiceMapID = providerServiceMapID;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return OutputMapper.gson().toJson(this);
	}
	
	
	
}
