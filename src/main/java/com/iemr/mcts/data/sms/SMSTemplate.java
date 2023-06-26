package com.iemr.mcts.data.sms;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.iemr.mcts.utils.mapper.OutputMapper;

import lombok.Data;

@Entity
@Table(name = "m_smstemplate")
@Data
public class SMSTemplate
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "SMSTemplateID")
	Integer smsTemplateID;
	@Column(name = "SMSTemplateName")
	String smsTemplateName;
	@Column(name = "SMSTemplate")
	String smsTemplate;
	@Column(name = "SMSSenderName")
	String smsSenderID;
	@Column(name = "SMSTypeID")
	Integer smsTypeID;
	@Column(name = "ProviderServiceMapID")
	Long providerServiceMapID;
	@Column(name = "Deleted", insertable = false, updatable = false)
	Boolean deleted;
	@Column(name = "CreatedBy", insertable = false, updatable = false)
	String createdBy;
	@Column(name = "CreatedDate", insertable = false, updatable = false)
	Timestamp createdDate;
	@Column(name = "ModifiedBy", insertable = false, updatable = false)
	String modifiedBy;
	@Column(name = "LastModDate", insertable = false, updatable = false)
	Timestamp lastModDate;

	@Override
	public String toString()
	{
		return OutputMapper.gsonWithoutExposeRestriction().toJson(this);
	}
}
