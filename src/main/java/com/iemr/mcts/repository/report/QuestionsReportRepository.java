package com.iemr.mcts.repository.report;

import java.util.List;
import java.util.Objects;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

import com.iemr.mcts.data.report.CallResponseReportDetail;

@Repository
@RestResource(exported = false)
public interface QuestionsReportRepository extends CrudRepository<CallResponseReportDetail, Long>{

	@Query(value= "select callResponseReportDetail.question, callResponseReportDetail.answer " 
			+ "from CallResponseReportDetail callResponseReportDetail "
			+ "where callResponseReportDetail.callDetailID = :callDetailID  ")
	List<Objects[]> getQuestions(@Param("callDetailID") Long callDetailID);

}
