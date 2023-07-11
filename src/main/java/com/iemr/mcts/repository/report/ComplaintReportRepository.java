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
package com.iemr.mcts.repository.report;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

import com.iemr.mcts.data.report.FeedbacksDetail;

@Repository
@RestResource(exported = false)
public interface ComplaintReportRepository extends CrudRepository<FeedbacksDetail, Integer>{
	


	@Query("SELECT feedbackDetail FROM FeedbacksDetail feedbackDetail "
			+ "inner join feedbackDetail.benCallDetails benCallDetail "
			+ "inner join benCallDetail.obdetail obdet "
			+ "inner join obdet.motherDetail mother  "
			+ "inner join mother.identityDetail identity "
			+ "where feedbackDetail.createdDate >= :startDate and feedbackDetail.createdDate <= :endDate "
			+ "and feedbackDetail.providerServiceMapID = :providerServiceMapID and benCallDetail.isMother = true ")
	List<FeedbacksDetail> getMotherComplaint(@Param("startDate") Timestamp startDate, @Param("endDate") Timestamp endDate,
			 @Param("providerServiceMapID") Long providerServiceMapID);


	@Query("SELECT feedbackDetail FROM FeedbacksDetail feedbackDetail "
			+ "inner join feedbackDetail.benCallDetails benCallDetail "
			+ "inner join benCallDetail.obdetail obdet "
			+ "inner join obdet.childDetail child  "
			+ "inner join child.identityDetail identity "
			+ "where feedbackDetail.createdDate >= :startDate and feedbackDetail.createdDate <= :endDate "
			+ "and feedbackDetail.providerServiceMapID = :providerServiceMapID and benCallDetail.isMother = false ")
	List<FeedbacksDetail> getChildComplaint(@Param("startDate") Timestamp startDate, @Param("endDate") Timestamp endDate,
			 @Param("providerServiceMapID") Long providerServiceMapID);

	@Query("SELECT feedbackDetail FROM FeedbacksDetail feedbackDetail "
			+ "inner join feedbackDetail.benCallDetails benCallDetail "
			+ "inner join benCallDetail.obdetail obdet "
			+ "inner join obdet.motherDetail mother  "
			+ "inner join mother.identityDetail identity "
			+ "where feedbackDetail.createdDate >= :startDate and feedbackDetail.createdDate <= :endDate "
			+ "and feedbackDetail.providerServiceMapID = :providerServiceMapID and benCallDetail.isMother = true and benCallDetail.userID = :userID ")
	List<FeedbacksDetail> getMotherComplaintByAgent(@Param("startDate") Timestamp startDate, @Param("endDate") Timestamp endDate,
			 @Param("providerServiceMapID") Long providerServiceMapID, @Param("userID") Integer userID);


	@Query("SELECT feedbackDetail FROM FeedbacksDetail feedbackDetail "
			+ "inner join feedbackDetail.benCallDetails benCallDetail "
			+ "inner join benCallDetail.obdetail obdet "
			+ "inner join obdet.childDetail child  "
			+ "inner join child.identityDetail identity "
			+ "where feedbackDetail.createdDate >= :startDate and feedbackDetail.createdDate <= :endDate "
			+ "and feedbackDetail.providerServiceMapID = :providerServiceMapID and benCallDetail.isMother = false and benCallDetail.userID = :userID ")
	List<FeedbacksDetail> getChildComplaintByAgent(@Param("startDate") Timestamp startDate, @Param("endDate") Timestamp endDate,
			 @Param("providerServiceMapID") Long providerServiceMapID,  @Param("userID") Integer userID);


}
