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

import com.iemr.mcts.data.report.CongenitalAnomalies;

@Repository
@RestResource(exported = false)
public interface CongenitalReportRepository extends CrudRepository<CongenitalAnomalies, Integer>{

	@Query("SELECT  congenital "
			+ "FROM CongenitalAnomalies congenital "
			+ "inner join congenital.benCallDetails benCall "
			+ "inner join benCall.obdetail ob "
			+ "inner join ob.childDetail child "
			+ "where congenital.createdDate >= :startDate and congenital.createdDate <= :endDate "
			+ "and congenital.providerServiceMapID = :providerServiceMapID "
			+ "and benCall.userID = :userID ")
	List<CongenitalAnomalies> getCongenitalAnomaliesReportByAgent(@Param("startDate") Timestamp startDate, @Param("endDate") Timestamp endDate, 
			@Param("providerServiceMapID") Long providerServiceMapID, @Param("userID") Integer userID);
	
	@Query("SELECT  congenital "
			+ "FROM CongenitalAnomalies congenital "
			+ "inner join congenital.benCallDetails benCall "
			+ "inner join benCall.obdetail ob "
			+ "inner join ob.childDetail child "
			+ "where congenital.createdDate >= :startDate and congenital.createdDate <= :endDate "
			+ "and congenital.providerServiceMapID = :providerServiceMapID ")
	List<CongenitalAnomalies> getCongenitalAnomaliesReport(@Param("startDate") Timestamp startDate, @Param("endDate") Timestamp endDate, 
			@Param("providerServiceMapID") Long providerServiceMapID);

	
}
