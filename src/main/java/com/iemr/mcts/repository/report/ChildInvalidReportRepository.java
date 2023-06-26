package com.iemr.mcts.repository.report;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

import com.iemr.mcts.data.report.ChildInvalidRecordDetail;

@Repository
@RestResource(exported = false)
public interface ChildInvalidReportRepository extends CrudRepository<ChildInvalidRecordDetail, Integer>{

	@Query(value= "select report "
			+ "from ChildInvalidRecordDetail report  "
			+ "where report.DateofUpload >= :startDate and report.DateofUpload <= :endDate "
			+ "and report.providerServiceMapID = :providerServiceMapID ")
	List<ChildInvalidRecordDetail> getChildInvalidReport(@Param("startDate") Timestamp startDate, @Param("endDate") Timestamp endDate, 
			@Param("providerServiceMapID") Long providerServiceMapID);

}
