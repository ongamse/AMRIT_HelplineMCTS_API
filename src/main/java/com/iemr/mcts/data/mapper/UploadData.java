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
