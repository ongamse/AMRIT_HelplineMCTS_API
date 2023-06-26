package com.iemr.mcts.repository.supervisor;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

import com.iemr.mcts.data.supervisor.ChildInvalidDataHandler;

@Repository
@RestResource(exported = false)
public interface ChildInvalidDataRepository extends CrudRepository<ChildInvalidDataHandler, Long> {

	@Query("select count(*) from ChildInvalidDataHandler c where c.FileID = :fileID")
	public long invalidCount(@Param("fileID") Long fileID);
}
