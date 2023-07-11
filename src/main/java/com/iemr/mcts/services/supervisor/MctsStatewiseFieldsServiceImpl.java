/*
* AMRIT – Accessible Medical Records via Integrated Technology
* Integrated EHR (Electronic Health Records) Solution
*
* Copyright (C) "Piramal Swasthya Management and Research Institute"
*
* This file is part of AMRIT.
*
* This program is free software: you can redistribute it and/or modify
* it under the terms of the GNU General Public License as published by
* the Free Software Foundation, either version 3 of the License, or
* (at your option) any later version.
*
* This program is distributed in the hope that it will be useful,
* but WITHOUT ANY WARRANTY; without even the implied warranty of
* MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
* GNU General Public License for more details.
*
* You should have received a copy of the GNU General Public License
* along with this program.  If not, see https://www.gnu.org/licenses/.
*/
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
