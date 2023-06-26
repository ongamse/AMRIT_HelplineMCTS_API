package com.iemr.mcts.repository.supervisor;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

import com.iemr.mcts.data.supervisor.MctsQuestionValues;

@Repository
@RestResource(exported = false)
public interface MctsQuestionValuesRepository extends CrudRepository<MctsQuestionValues, Long> {

	@Transactional
	@Modifying(clearAutomatically = true)
	@Query("update MctsQuestionValues m set m.dropDownOptions = :questionValue, m.deleted = :deletedStatus "
			+ "where m.questionID = :questionID and m.questionValuesID = :questionValueID ")
	public int updateQuestionValues(@Param("questionValue") String questionValue,@Param("deletedStatus") Boolean deletedStatus,
			@Param("questionID") Integer questionID, @Param("questionValueID") Integer questionValueID);
	
	@Transactional
	@Modifying(clearAutomatically = true)
	@Query("update MctsQuestionValues m set m.deleted = true "
			+ "where m.questionID = :questionID ")
	public int deleteQuestionValues(@Param("questionID") Integer questionID);
}
