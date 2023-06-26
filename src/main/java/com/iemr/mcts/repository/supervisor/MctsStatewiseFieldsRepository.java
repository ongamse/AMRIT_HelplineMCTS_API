package com.iemr.mcts.repository.supervisor;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

import com.iemr.mcts.data.supervisor.MctsStatewiseFieldsDetail;

@Repository
@RestResource(exported = false)
public interface MctsStatewiseFieldsRepository extends CrudRepository<MctsStatewiseFieldsDetail, Integer> {

	@Query("select ms from MctsStatewiseFieldsDetail ms where ms.providerServiceMapID = :providerServiceMapID "
			+ "and ms.fieldFor in (select fileTypeName from FileTypeDetails where fileTypeId = :fileTypeId)")
	public MctsStatewiseFieldsDetail getStatewiseFields(
			@Param("providerServiceMapID") Long providerServiceMapID,
			@Param("fileTypeId") Long fileTypeId);
	
	@Query("select ms from MctsStatewiseFieldsDetail ms where ms.providerServiceMapID = :providerServiceMapID and ms.fieldFor = :fieldFor")
	MctsStatewiseFieldsDetail getAllFields(@Param("providerServiceMapID") Long providerServiceMapID, 
				@Param("fieldFor") String fieldFor);
}
