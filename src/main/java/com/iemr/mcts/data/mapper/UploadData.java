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
package com.iemr.mcts.data.mapper;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.ss.usermodel.Row;

import com.iemr.mcts.data.supervisor.ChildInvalidDataHandler;
import com.iemr.mcts.data.supervisor.ChildValidDataHandler;
import com.iemr.mcts.data.supervisor.FileManager;
import com.iemr.mcts.data.supervisor.MctsDataReaderDetail;
import com.iemr.mcts.data.supervisor.MctsInvalidDataReaderDetail;

import lombok.Data;

@Data
public class UploadData {

	Boolean ismotherdata;

	Boolean ischilddata;

	List<MctsDataReaderDetail> mothervalid;

	List<MctsInvalidDataReaderDetail> motherinvalid;

	List<ChildValidDataHandler> childvalid;

	List<ChildInvalidDataHandler> childinvalid;
	
	FileManager fileManager;
	
	String message;
	
	Iterator<Row> rowIterator;
	
	Map<String, String> fieldsMap;
	
	FormulaEvaluator evaluator;
}
