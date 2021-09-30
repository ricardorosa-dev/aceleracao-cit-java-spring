package com.challenge.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

@Embeddable
public class CandidateId implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@ManyToOne
//	@Column(name = "user_id")
	@NotNull
	private User user;	
	
	@ManyToOne
//	@Column(name = "acceleration_id")
	@NotNull
	private Acceleration acceleration;
	
	@ManyToOne
//	@Column(name = "company_id")
	@NotNull
	private Company company;

}
