package com.iemr.mcts.repository.supervisor;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

import com.iemr.mcts.data.supervisor.MctsInvalidDataReaderDetail;

@Repository
@RestResource(exported = false)
public interface MctsInvalidDataRepository extends CrudRepository<MctsInvalidDataReaderDetail, Long> {

	@Query("select count(*) from MctsInvalidDataReaderDetail m where m.FileID = :fileID")
	public long invalidCount(@Param("fileID") Long fileID);
}
