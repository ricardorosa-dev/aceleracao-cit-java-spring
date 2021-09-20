package com.challenge.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Candidate extends Auditable{
	
	@EmbeddedId
	private CandidateId id = new CandidateId();
	
	@ManyToOne(cascade = CascadeType.ALL)
	@MapsId("userId")
//	@JoinColumn(name = "user_id")
	private User user;
	
	@ManyToOne(cascade = CascadeType.MERGE)
	@MapsId("accelerationId")
//	@JoinColumn(name = "acceleration_id")
	private Acceleration acceleration;
	
	@ManyToOne(cascade = CascadeType.MERGE)
	@MapsId("companyId")
//	@JoinColumn(
//			name = "company_id",
//			referencedColumnName = "id"
//	)
	private Company company;
	
	@Column(nullable = false)
	private int status;

	public Candidate(User user, Acceleration acceleration, Company company, int status) {
		super();
		this.user = user;
		this.acceleration = acceleration;
		this.company = company;
		this.status = status;
	}

	

}
