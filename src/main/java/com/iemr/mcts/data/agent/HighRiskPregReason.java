package com.iemr.mcts.data.agent;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.google.gson.annotations.Expose;

@Entity
@Table(name = "m_HighRiskPregReason")
public class HighRiskPregReason implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Expose
	@Column(name = "HighRiskPregReasonID")
	private Integer highRiskPregReasonID;

	@Expose
	@Column(name = "HighRiskPregReason")
	private String highRiskPregReason;
	
}
