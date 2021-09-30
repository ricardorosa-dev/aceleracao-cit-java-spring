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
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

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
@EntityListeners(AuditingEntityListener.class)
public class Submission{
	
	@EmbeddedId
	private SubmissionId submissionId = new SubmissionId();
	
//	@ManyToOne
//	@MapsId("userId")
//	private User user;
//	
//	@ManyToOne
//	@MapsId("challengeId")
//	private Challenge challenge;
	
	@Column(nullable = false)
	@NotNull
	private float score;
	
	@Column(name = "created_at")
	@CreatedDate
	private Date createdAt;

	public Submission(User userId, Challenge challengeId, float score) {
//		this.user = userId;
//		this.challenge = challengeId;
		this.score = score;
	}
	
	

}
