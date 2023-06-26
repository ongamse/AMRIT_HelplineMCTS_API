package com.iemr.mcts.data.mapper;

import java.util.List;

import org.mapstruct.DecoratedWith;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.iemr.mcts.data.domain.Identity;

@Mapper(componentModel = "spring")
@DecoratedWith(IdentityProofMapperDecorator.class)
public interface IdentityProofMapper {

	IdentityProofMapper INSTANCE = Mappers.getMapper(IdentityProofMapper.class);

	Identity getProofDetail(String aadharNo);

	@IterableMapping(elementTargetType = Identity.class)
	List<Identity> getProofDetail(List<String> aadharNo);
}
