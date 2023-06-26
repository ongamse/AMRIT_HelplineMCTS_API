package com.iemr.mcts.services.agent;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.doReturn;

import java.util.List;

import org.assertj.core.util.Lists;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.iemr.mcts.data.agent.FeedbackDetail;
import com.iemr.mcts.repository.agent.FeedbackRepository;
import com.iemr.mcts.utils.exception.IEMRException;

@RunWith(MockitoJUnitRunner.class)
public class FeedbackServiceImplTest {

	@InjectMocks
	FeedbackServiceImpl feedbackServiceImpl;
	
	@Mock
	FeedbackRepository feedbackRepository;
	
	@Test
	public void getFeedBackListTest()
	{
		FeedbackDetail feedbackDetail=new FeedbackDetail();
		feedbackDetail.setBeneficiaryRegID(new Long("101"));
		List<FeedbackDetail> list=Lists.newArrayList();
		list.add(feedbackDetail);
		doReturn(list).when(feedbackRepository).getBenificiaryComplaintList(Mockito.anyLong());
		
		try {
			String response=feedbackServiceImpl.getFeedBackList(feedbackDetail.toString());
			//assertTrue(response.contains("\"beneficiaryRegID\":101"));
		} catch (IEMRException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Test
	public void getFeedBackListTest1()
	{
		FeedbackDetail feedbackDetail=new FeedbackDetail();
		
		try {
			String response=feedbackServiceImpl.getFeedBackList(feedbackDetail.toString());
			assertFalse(response.contains("\"beneficiaryRegID\":101"));
		} catch (IEMRException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
}
}