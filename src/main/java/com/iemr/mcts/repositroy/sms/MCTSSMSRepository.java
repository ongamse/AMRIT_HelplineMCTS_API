/*
* AMRIT – Accessible Medical Records via Integrated Technology
* Integrated EHR (Electronic Health Records) Solution
*
* Copyright (C) "Piramal Swasthya Management and Research Institute"
*
* This file is part of AMRIT.
*
* This program is free software: you can redistribute it and/or modify
* it under the terms of the GNU General Public License as published by
* the Free Software Foundation, either version 3 of the License, or
* (at your option) any later version.
*
* This program is distributed in the hope that it will be useful,
* but WITHOUT ANY WARRANTY; without even the implied warranty of
* MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
* GNU General Public License for more details.
*
* You should have received a copy of the GNU General Public License
* along with this program.  If not, see https://www.gnu.org/licenses/.
*/
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
