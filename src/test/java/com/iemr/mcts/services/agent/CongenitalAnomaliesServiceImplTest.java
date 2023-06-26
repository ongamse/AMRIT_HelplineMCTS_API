package com.iemr.mcts.services.agent;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.doReturn;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.beust.jcommander.internal.Lists;
import com.iemr.mcts.data.agent.CongenitalAnomaliesDetail;
import com.iemr.mcts.repository.agent.CongenitalAnomaliesRepository;

@RunWith(MockitoJUnitRunner.class)
public class CongenitalAnomaliesServiceImplTest {

	@InjectMocks
	CongenitalAnomaliesServiceImpl congenitalAnomaliesServiceImpl;
	
	@Mock
	CongenitalAnomaliesRepository congenitalAnomaliesRepository;
	
	@Test
	public void getCongenitalAnomalies()
	{
		
		List<CongenitalAnomaliesDetail>  congenitalAnomaliesDetails=Lists.newArrayList();
		CongenitalAnomaliesDetail congenitalAnomaliesDetail=new CongenitalAnomaliesDetail();
		congenitalAnomaliesDetail.setCongenitalAnomaliesDesc("abc");
		congenitalAnomaliesDetails.add(congenitalAnomaliesDetail);
		doReturn(congenitalAnomaliesDetails).when(congenitalAnomaliesRepository).getCongenitalAnomalies();
		String response=congenitalAnomaliesServiceImpl.getCongenitalAnomalies();
		assertTrue(response.contains("\"congenitalAnomaliesDesc\":\"abc\""));
	}
	@Test
	public void getCongenitalAnomalies1()
	{
		
		String response=congenitalAnomaliesServiceImpl.getCongenitalAnomalies();
		assertFalse(response.contains("\"congenitalAnomaliesDesc\":\"abc\""));
	}
}
