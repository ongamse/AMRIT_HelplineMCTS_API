package com.iemr.mcts.repository.supervisor;

import java.util.Objects;
import java.util.Set;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

import com.iemr.mcts.data.domain.GovtIdentityType;

@Repository
@RestResource(exported = false)
public interface IdentityProofRepository extends CrudRepository<GovtIdentityType, Integer> {
	
	@Query("select identityType , govtIdentityTypeID from GovtIdentityType where deleted = false order by govtIdentityTypeID asc")
	public abstract Set<Objects[]> findIdentityProof();
	
	@Query("select giden  from GovtIdentityType giden where deleted = false and giden.identityType = :name order by govtIdentityTypeID asc")
	public abstract GovtIdentityType findIdentityProofbyName(@Param("name") String name);
}
