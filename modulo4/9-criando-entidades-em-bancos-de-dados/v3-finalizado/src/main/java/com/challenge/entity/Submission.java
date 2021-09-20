package com.challenge.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Submission extends Auditable{
	
	@EmbeddedId
	private SubmissionId id = new SubmissionId();
	
	@ManyToOne
	@MapsId("userId")
	private User user;
	
	@ManyToOne
	@MapsId("challengeId")
	private Challenge challenge;
	
	@Column(nullable = false)
	private float score;

	public Submission(User userId, Challenge challengeId, float score) {
		this.user = userId;
		this.challenge = challengeId;
		this.score = score;
	}
	
	

}
