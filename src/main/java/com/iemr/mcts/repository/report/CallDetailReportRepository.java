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

import com.iemr.mcts.data.report.BenCallDetail;

@Repository
@RestResource(exported = false)
public interface CallDetailReportRepository extends CrudRepository<BenCallDetail, Integer>{

	@Query("SELECT benCallDetail "
			+ "FROM BenCallDetail benCallDetail "
			+ "inner join benCallDetail.obdetail obdet "
			+ "inner join obdet.motherDetail mother  "
			+ "where benCallDetail.createdDate >= :startDate and benCallDetail.createdDate <= :endDate "
			+ "and benCallDetail.providerServiceMapID = :providerServiceMapID "
			+ "and benCallDetail.userID = :userID and benCallDetail.isMother = true ")
	List<BenCallDetail> getMotherCallReportByAgent(@Param("startDate") Timestamp startDate, @Param("endDate") Timestamp endDate, 
			@Param("providerServiceMapID") Long providerServiceMapID, @Param("userID") Integer userID);
	
	@Query("SELECT benCallDetail "
			+ "FROM BenCallDetail benCallDetail "
			+ "inner join benCallDetail.obdetail obdet "
			+ "inner join obdet.motherDetail mother  "
			+ "where benCallDetail.createdDate >= :startDate and benCallDetail.createdDate <= :endDate "
			+ "and benCallDetail.providerServiceMapID = :providerServiceMapID and benCallDetail.isMother = true ")
	List<BenCallDetail> getMotherCallReport(@Param("startDate") Timestamp startDate, @Param("endDate") Timestamp endDate, 
			@Param("providerServiceMapID") Long providerServiceMapID);
	
	@Query("SELECT benCallDetail "
			+ "FROM BenCallDetail benCallDetail "
			+ "inner join benCallDetail.obdetail obdet "
			+ "inner join obdet.childDetail child  "
			+ "where benCallDetail.createdDate >= :startDate and benCallDetail.createdDate <= :endDate "
			+ "and benCallDetail.providerServiceMapID = :providerServiceMapID "
			+ "and benCallDetail.userID = :userID and benCallDetail.isMother = false ")
	List<BenCallDetail> getChildCallReportByAgent(@Param("startDate") Timestamp startDate, @Param("endDate") Timestamp endDate, 
			@Param("providerServiceMapID") Long providerServiceMapID, @Param("userID") Integer userID);
	
	@Query("SELECT benCallDetail "
			+ "FROM BenCallDetail benCallDetail "
			+ "inner join benCallDetail.obdetail obdet "
			+ "inner join obdet.childDetail child  "
			+ "where benCallDetail.createdDate >= :startDate and benCallDetail.createdDate <= :endDate "
			+ "and benCallDetail.providerServiceMapID = :providerServiceMapID and benCallDetail.isMother = false ")
	List<BenCallDetail> getChildCallReport(@Param("startDate") Timestamp startDate, @Param("endDate") Timestamp endDate, 
			@Param("providerServiceMapID") Long providerServiceMapID);

	
	@Query("SELECT COUNT(benCallDetail.benCallID) "
			+ "FROM BenCallDetail benCallDetail "
			+ "inner join benCallDetail.obdetail obdet "
			+ "inner join obdet.childDetail child  "
			+ "where benCallDetail.obCallID = :obCallID "
			+ "and (benCallDetail.callTypeName = 'Answered' or child.phoneNoof = 'Self') " )
	Integer getAnsweredCountChild(
			 @Param("obCallID") Long obCallID);
	
	@Query("SELECT COUNT(benCallDetail.benCallID) "
			+ "FROM BenCallDetail benCallDetail "
			+ "inner join benCallDetail.obdetail obdet "
			+ "inner join obdet.motherDetail mother  "
			+ "where benCallDetail.obCallID = :obCallID "
			+ "and (benCallDetail.callTypeName = 'Answered' or mother.phoneNoOfWhom = 'Self') " )
	Integer getAnsweredCountMother(
			 @Param("obCallID") Long obCallID);
	
	@Query("SELECT COUNT(benCallDetail.benCallID) "
			+ "FROM BenCallDetail benCallDetail "
			+ "where benCallDetail.obCallID = :obCallID and benCallDetail.isVerified = true ")
	Integer getCountVerified(
			 @Param("obCallID") Long obCallID);
}
