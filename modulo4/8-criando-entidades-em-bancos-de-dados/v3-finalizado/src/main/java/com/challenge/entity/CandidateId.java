package com.challenge.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class CandidateId implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Column(name = "user_id")
	private int userId;	
	
	@Column(name = "acceleration_id")
	private int accelerationId;
	
	@Column(name = "company_id")
	private int companyId;

}
