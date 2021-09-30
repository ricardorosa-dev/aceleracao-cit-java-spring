package com.challenge.entity;

import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class Candidate{
	
	@EmbeddedId
	private CandidateId candidateId = new CandidateId();
	
//	@ManyToOne(cascade = CascadeType.ALL)
//	@MapsId("userId")
//	private User user;
//	
//	@ManyToOne(cascade = CascadeType.MERGE)
//	@MapsId("accelerationId")
//	private Acceleration acceleration;
//	
//	@ManyToOne(cascade = CascadeType.MERGE)
//	@MapsId("companyId")
//	private Company company;
	
	@Column(name = "created_at")
	@CreatedDate
	private Date CreatedAt;
	
	@Column(nullable = false)
	@NotNull
	private int status;

	public Candidate(User user, Acceleration acceleration, Company company, int status) {
		super();
//		this.user = user;
//		this.acceleration = acceleration;
//		this.company = company;
		this.status = status;
	}

	

}
