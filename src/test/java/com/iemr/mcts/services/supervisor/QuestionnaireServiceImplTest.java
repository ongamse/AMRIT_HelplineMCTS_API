package com.iemr.mcts.services.supervisor;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.assertj.core.util.Lists;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.iemr.mcts.data.supervisor.MctsQAMappingDetail;
import com.iemr.mcts.data.supervisor.QuestionnaireDetail;
import com.iemr.mcts.repository.supervisor.MctsQAMappingRepository;
import com.iemr.mcts.repository.supervisor.QuestionnaireRepository;
import com.iemr.mcts.utils.exception.IEMRException;

@RunWith(MockitoJUnitRunner.class)
public class QuestionnaireServiceImplTest {

	
	@InjectMocks
	QuestionnaireServiceImpl questionnaireServiceImpl;
	
	@Mock
	QuestionnaireRepository questionnaireRepository;
	
	@Mock
	MctsQAMappingRepository mctsQAMappingRepository;
	
	@Test
	public void createQuestionnaireTest()
	{
		QuestionnaireDetail questionnaireDetail=new QuestionnaireDetail();
		questionnaireDetail.setAnswerType("answerType");
		List<QuestionnaireDetail> list=Lists.newArrayList();
		list.add(questionnaireDetail);
		try {
			String response=questionnaireServiceImpl.createQuestionnaire(list.toString());
			assertTrue(response.contains("Inserted question successfully;"));
		} catch (IEMRException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void updateQuestionnaireTest()
	{
		MctsQAMappingDetail mctsQAMappingDetail=new MctsQAMappingDetail();
		mctsQAMappingDetail.setVariableName("variable");
		mctsQAMappingDetail.setQuestionID(101);
		QuestionnaireDetail questionnaireDetail=new QuestionnaireDetail();
		questionnaireDetail.setAnswerType("answerType");
		questionnaireDetail.setMctsQAMappingDetail(mctsQAMappingDetail);
		
	}
}
