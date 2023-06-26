package com.iemr.mcts.repositroy.sms;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

import com.iemr.mcts.data.sms.SMSTemplate;

@Repository
@RestResource(exported = false)
public interface MCTSSMSRepository extends CrudRepository<SMSTemplate, Integer>{

	@Query("select smsTemplate from SMSTemplate smsTemplate where "
			+ "smsTemplate.providerServiceMapID = :providerServiceMapID and "
			+ "smsTemplate.smsTypeID = 7 and smsTemplate.deleted = false ")
	public SMSTemplate getSMSTemplateByProviderServiceMapIDAndSMSTypeID(
			@Param("providerServiceMapID") Long providerServiceMapID);
	
	@Query("select smsTemplate from SMSTemplate smsTemplate where "
			+ "smsTemplate.providerServiceMapID = :providerServiceMapID and "
			+ "smsTemplate.smsTypeID = 14 and smsTemplate.deleted = false ")
	public SMSTemplate getPNCSMSTemplate(
			@Param("providerServiceMapID") Long providerServiceMapID);
	
	@Query("select smsTemplate from SMSTemplate smsTemplate where "
			+ "smsTemplate.providerServiceMapID = :providerServiceMapID and "
			+ "smsTemplate.smsTypeID = 13 and smsTemplate.deleted = false ")
	public SMSTemplate getANCSMSTemplate(
			@Param("providerServiceMapID") Long providerServiceMapID);

}
