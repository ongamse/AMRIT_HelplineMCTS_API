package com.iemr.mcts.data.agent;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.google.gson.annotations.Expose;

@Entity
@Table(name="m_servicemaster")
public class ServiceMasterDetail {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Expose 
	@Column(name="ServiceID")
	private Integer serviceID;
	
	@Expose 
	@Column(name="ServiceName")
	private String serviceName;
	
	@Expose 
	@Column(name="ServiceDesc")
	private String serviceDesc;
}
