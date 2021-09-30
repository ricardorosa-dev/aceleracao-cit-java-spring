package com.challenge.entity;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Builder
@Getter
@Setter
public class Submission extends Auditable{
	
	@EmbeddedId
	private SubmissionId id;
	
	@ManyToOne
	@MapsId("id")
	@JoinColumn(name = "user_id")
	private User userId;
	
	@ManyToOne
	@MapsId("id")
	@JoinColumn(name = "challenge_id")
	private Challenge challengeId;
	
	@Column(nullable = false)
	private float score;

}
