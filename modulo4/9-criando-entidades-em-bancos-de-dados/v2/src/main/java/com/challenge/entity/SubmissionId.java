package com.challenge.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.Data;

@Embeddable
@Data
public class SubmissionId implements Serializable{
	
	@Column(name = "user_id")
	private int userId;
	
	@Column(name = "challenge_id")
	private int challengeId;
}
