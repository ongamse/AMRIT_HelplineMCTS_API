package com.iemr.mcts.services.supervisor;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iemr.mcts.data.supervisor.DBExcelFieldName;
import com.iemr.mcts.data.supervisor.MctsStatewiseFieldsDetail;
import com.iemr.mcts.repository.supervisor.MctsStatewiseFieldsRepository;
import com.iemr.mcts.utils.exception.IEMRException;
import com.iemr.mcts.utils.mapper.InputMapper;

@Service
public class MctsStatewiseFieldsServiceImpl implements MctsStatewiseFieldsService {

	/**
	 * mcts statewise fields repository
	 */
	private MctsStatewiseFieldsRepository mctsStatewiseFieldsRepository;

	/**
	 * inject mcts statewise fields repository
	 */
	@Autowired
	public void setMctsStatewiseFieldsRepository(MctsStatewiseFieldsRepository mctsStatewiseFieldsRepository) {

		this.mctsStatewiseFieldsRepository = mctsStatewiseFieldsRepository;
	}

	@Override
	public String getVariables(String request) throws IEMRException {
		
		MctsStatewiseFieldsDetail mctsStatewiseFieldsDetail = InputMapper.gson().fromJson(request, MctsStatewiseFieldsDetail.class);
		
		List<DBExcelFieldName> variables = new ArrayList<DBExcelFieldName>();
		
		MctsStatewiseFieldsDetail detail = mctsStatewiseFieldsRepository
				.getAllFields(mctsStatewiseFieldsDetail.getProviderServiceMapID(),
						mctsStatewiseFieldsDetail.getFieldFor());
			DBExcelFieldName[] excelFieldNames = InputMapper.gson().fromJson(detail.getDataFields(),
				DBExcelFieldName[].class);
			
			DBExcelFieldName eedField = new DBExcelFieldName("EDD","EDD");
			for(DBExcelFieldName fieldName:excelFieldNames){
				
				if(!variables.contains(fieldName))
					variables.add(fieldName);
			}
			
			variables.add(eedField);
			
		Collections.sort(variables, DBExcelFieldName.getSortCompoByExcelFieldName());
		return variables.toString();
	}
}
