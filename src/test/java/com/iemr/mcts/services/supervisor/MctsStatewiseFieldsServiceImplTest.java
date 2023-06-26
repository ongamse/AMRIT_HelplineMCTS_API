package com.iemr.mcts.services.supervisor;

import static org.mockito.Mockito.doReturn;

import java.util.List;

import org.assertj.core.util.Lists;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.iemr.mcts.data.supervisor.MctsStatewiseFieldsDetail;
import com.iemr.mcts.repository.supervisor.MctsStatewiseFieldsRepository;
import com.iemr.mcts.utils.exception.IEMRException;

@RunWith(MockitoJUnitRunner.class)
public class MctsStatewiseFieldsServiceImplTest {

	@InjectMocks
	MctsStatewiseFieldsServiceImpl mctsStatewiseFieldsServiceImpl;
	
	@Mock
	MctsStatewiseFieldsRepository mctsStatewiseFieldsRepository;
	
	@Test
	public void getVariables()
	{
		/*List<MctsStatewiseFieldsDetail> list=Lists.newArrayList();
		MctsStatewiseFieldsDetail mctsStatewiseFieldsDetail=new MctsStatewiseFieldsDetail();
		mctsStatewiseFieldsDetail.setProviderServiceMapID(new Long("101"));
		list.add(mctsStatewiseFieldsDetail);
		doReturn(mctsStatewiseFieldsDetail).when(mctsStatewiseFieldsRepository).getAllFields(Mockito.anyLong(),Mockito.anyString());
		try {
			//mctsStatewiseFieldsServiceImpl.getVariables("{\"providerServiceMapID\":109, \"dataFields\":\"dataFields\", \"fieldFor\":\"fieldFor\"}");
			mctsStatewiseFieldsServiceImpl.getVariables(mctsStatewiseFieldsDetail.toString());
		} catch (IEMRException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
	}
}
