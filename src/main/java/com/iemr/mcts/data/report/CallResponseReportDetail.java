package com.iemr.mcts.data.report;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.google.gson.annotations.Expose;
import com.iemr.mcts.utils.mapper.OutputMapper;

import lombok.Data;

@Entity
@Table(name = "db_reporting.fact_mctscallresponse", schema = "db_reporting")
@Data
public class CallResponseReportDetail implements Serializable {

	public CallResponseReportDetail() {
		
	}
	public CallResponseReportDetail(String question, String answer) {
		this.question=question;
		this.answer=answer;
		
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Fact_MctsCallResponseID")
	private Long Fact_MctsCallResponseID;

	@Column(name = "BenCallID")
	private Long callDetailID;

	@Expose
	@Column(name = "Question")
	private String question;

	@Expose
	@Column(name = "Answer")
	private String answer;
	
	@Expose
	@Column(name = "MotherID")
	private Long motherID;

	@Transient
	private OutputMapper outputMapper = new OutputMapper();
	
	@Override
	public String toString()
	{
		return outputMapper.gson().toJson(this);
	}
	

}
