package com.iemr.mcts.repository.report;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

import com.iemr.mcts.data.report.MotherDataReportDetail;
@Repository
@RestResource(exported = false)
public interface MotherDataReportRepository extends CrudRepository<MotherDataReportDetail, Long>{

	
	@Query(value= "select motherDataReportDetail from MotherDataReportDetail motherDataReportDetail "
			+ "where motherDataReportDetail.createdDate >= :startDate and motherDataReportDetail.createdDate <= :endDate "
			+ "and motherDataReportDetail.providerServiceMapID = :providerServiceMapID ")
	List<MotherDataReportDetail> getMotherDataReportByAgent(@Param("startDate") Timestamp startDate, @Param("endDate") Timestamp endDate,
			@Param("providerServiceMapID") Long providerServiceMapID);

	
	@Query(value= "select motherDataReportDetail from MotherDataReportDetail motherDataReportDetail "
			+ "where motherDataReportDetail.createdDate >= :startDate and motherDataReportDetail.createdDate <= :endDate "
			+ "and motherDataReportDetail.providerServiceMapID = :providerServiceMapID ")
	List<MotherDataReportDetail> getMotherDataReport(@Param("startDate") Timestamp startDate, @Param("endDate") Timestamp endDate,
			@Param("providerServiceMapID") Long providerServiceMapID);

}
