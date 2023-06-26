package com.iemr.mcts.repository.supervisor;

import java.util.ArrayList;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

import com.iemr.mcts.data.supervisor.QuestionnaireDetail;

@Repository
@RestResource(exported = false)
public interface QuestionnaireRepository extends CrudRepository<QuestionnaireDetail, Integer> {

	@Query("select new QuestionnaireDetail (qn.questionID, qn.question, qn.questionDesc) from QuestionnaireDetail qn")
	public ArrayList<QuestionnaireDetail> getQuestionnaireList();

	@Query("select qn from QuestionnaireDetail qn") // where qn.questionID = :questionID")
	public ArrayList<QuestionnaireDetail> getOne();// (@Param("questionID") Integer questionID);

	@Transactional
	@Modifying(clearAutomatically = true)
	@Query("update QuestionnaireDetail q set q.question = :question, q.triggerFeedback = :triggerFeedback, "
			+ "q.triggerFeedbackFor = :triggerFeedbackFor, q.showText = :showText, q.showTextFor = :showTextFor, "
			+ "q.questionRank = :questionRank, q.isMandatory = :isMandatory, q.interaction = :interaction "
			+ "where :question is not null and :answerType is not null and "
			+ "q.questionID = :questionID")
	public int updateQuestionnaire(@Param("questionID") Integer questionID, @Param("question") String question,
			@Param("answerType") String answerType, @Param("triggerFeedback") Boolean triggerFeedback,
			@Param("triggerFeedbackFor") String triggerFeedbackFor, @Param("showText") Boolean showText,
			@Param("showTextFor") String showTextFor, @Param("questionRank") Integer questionRank,
			@Param("isMandatory") Boolean isMandatory,@Param("interaction") String interaction);

	@Transactional
	@Modifying(clearAutomatically = true)
	@Query("update QuestionnaireDetail q set q.parentQuestionID = :parentQuestionID, q.parentAnswer = :parentAnswer, q.isChild = true "
			+ "where q.questionID = :questionID and q.providerServiceMapID = :providerServiceMapID")
	public int updateDeriveQuestion(@Param("parentQuestionID") Integer parentQuestionID,
			@Param("parentAnswer") String parentAnswer, @Param("questionID") Integer questionID,
			@Param("providerServiceMapID") Long providerServiceMapID);

//	@Query("select qn from QuestionnaireDetail qn where qn.questionRank = : questionRank and qn.")
//	public QuestionnaireDetail checkRank(@Param("questionRank") Integer questionRank,
//			@Param("outboundCallType") Integer outboundCallType,@Param("providerServiceMapID") Integer providerServiceMapID);
}
