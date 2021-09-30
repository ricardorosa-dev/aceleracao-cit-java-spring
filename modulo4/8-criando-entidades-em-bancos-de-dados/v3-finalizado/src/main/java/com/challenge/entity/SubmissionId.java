package com.challenge.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Embeddable
public class SubmissionId implements Serializable{
	
	/**
	 * não sei porque ele pede isso = pesquisar
	 */
	private static final long serialVersionUID = 1L;

	@Column(name = "user_id")
	private int userId;
	
	@Column(name = "challenge_id")
	private int challengeId;
	
	
}
