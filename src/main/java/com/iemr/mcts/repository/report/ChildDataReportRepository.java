package com.iemr.mcts.repository.report;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

import com.iemr.mcts.data.report.ChildDataReportDetail;

@Repository
@RestResource(exported = false)
public interface ChildDataReportRepository extends CrudRepository<ChildDataReportDetail, Long>{

	@Query(value= "select childDataReportDetail from ChildDataReportDetail childDataReportDetail  "
			+ "where childDataReportDetail.createdDate >= :startDate and childDataReportDetail.createdDate <= :endDate "
			+ "and childDataReportDetail.providerServiceMapID = :providerServiceMapID ")
	List<ChildDataReportDetail> getChildDataReportByAgent(@Param("startDate") Timestamp startDate, @Param("endDate") Timestamp endDate,
			@Param("providerServiceMapID") Long providerServiceMapID);

	
	@Query(value= "select childDataReportDetail from ChildDataReportDetail childDataReportDetail  "
			+ "where childDataReportDetail.createdDate >= :startDate and childDataReportDetail.createdDate <= :endDate "
			+ "and childDataReportDetail.providerServiceMapID = :providerServiceMapID ")
	List<ChildDataReportDetail> getChildDataReport(@Param("startDate") Timestamp startDate, @Param("endDate") Timestamp endDate, 
			@Param("providerServiceMapID") Long providerServiceMapID);

}

