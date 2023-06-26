package com.iemr.mcts.repository.supervisor;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

import com.iemr.mcts.data.supervisor.I_Beneficiary;


/**
 * @author VI314759
 *
 */
@Repository
@RestResource(exported = false)
public interface BeneficiaryRepository extends CrudRepository<I_Beneficiary, Long> {

}
