package com.iemr.mcts.services.agent;

import static org.mockito.Mockito.doReturn;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import org.assertj.core.util.Lists;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.iemr.mcts.data.supervisor.DBExcelFieldName;
import com.iemr.mcts.data.supervisor.MctsDataReaderDetail;
import com.iemr.mcts.data.supervisor.MctsOutboundCall;
import com.iemr.mcts.data.supervisor.MctsStatewiseFieldsDetail;
import com.iemr.mcts.repository.supervisor.MctsDataHandlerRepository;
import com.iemr.mcts.repository.supervisor.MctsStatewiseFieldsRepository;
import com.iemr.mcts.utils.exception.IEMRException;

@RunWith(MockitoJUnitRunner.class)
public class MctsDataTransactionServiceImplTest {

	@InjectMocks
	MctsDataTransactionServiceImpl mctsDataTransactionServiceImpl;
	
	@Mock
	MctsDataHandlerRepository mctsDataHandlerRepository;
	
	@Mock
	MctsStatewiseFieldsRepository mctsStatewiseFieldsRepository;
	
	@Test
	public void updateDataTest()
	{
		MctsOutboundCall mctsOutboundCall=new MctsOutboundCall();
		mctsOutboundCall.setOutboundCallType("type");
		mctsOutboundCall.setProviderServiceMapID(new Long("301"));
		MctsDataReaderDetail mctsDataReaderDetail=new MctsDataReaderDetail();
		mctsDataReaderDetail.setMotherValidRecordID(new Long("101"));
		mctsOutboundCall.setMctsDataReaderDetail(mctsDataReaderDetail);
		MctsDataReaderDetail mctsDataReaderDetail1=new MctsDataReaderDetail();
		
		MctsStatewiseFieldsDetail mctsStatewiseFieldsDetail=new MctsStatewiseFieldsDetail();
		mctsStatewiseFieldsDetail.setProviderServiceMapID(new Long("501"));
		
		doReturn(mctsStatewiseFieldsDetail).when(mctsStatewiseFieldsRepository).getAllFields(Mockito.anyLong(),Mockito.anyString());
		
		doReturn(mctsDataReaderDetail1).when(mctsDataHandlerRepository).findOne(Mockito.anyLong());
		
		List<DBExcelFieldName> list=Lists.newArrayList();
		DBExcelFieldName dBExcelFieldName=new DBExcelFieldName();
		dBExcelFieldName.setDbColumnName("db");
		list.add(dBExcelFieldName);
		
	/*	try {
			String response=mctsDataTransactionServiceImpl.updateData(mctsOutboundCall.toString());
			System.out.println(response);
		} catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException | IEMRException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
	}
	@Test
	public void updateData1Test()
	{
		MctsOutboundCall mctsOutboundCall=new MctsOutboundCall();
		mctsOutboundCall.setOutboundCallType("type");
		MctsDataReaderDetail mctsDataReaderDetail=new MctsDataReaderDetail();
		mctsOutboundCall.setMctsDataReaderDetail(mctsDataReaderDetail);
		doReturn(mctsDataReaderDetail).when(mctsDataHandlerRepository).findOne(Mockito.anyLong());
		/*try {
			//String response=mctsDataTransactionServiceImpl.updateData(mctsOutboundCall.toString());
			//System.out.println(response);
		} catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException | IEMRException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
	}
}
