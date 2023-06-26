package com.iemr.mcts.data.agent;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.google.gson.annotations.Expose;

import lombok.Data;

@Entity
@Table(name = "m_districtblock")
@Data
public class DistrictBlock
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "BlockID")
	@Expose
	private Integer blockID;

	@Column(name = "DistrictID")
	@Expose
	private Integer districtID;
	
	@Column(name = "BlockName")
	@Expose
	private String blockName;
	
	@Column(name = "StateID")
	@Expose
	private Integer stateID;
	
	@Column(name = "Deleted", insertable = false, updatable = false)
	@Expose
	private Boolean deleted;



}
