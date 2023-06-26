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
