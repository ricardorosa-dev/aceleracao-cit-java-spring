package com.challenge.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Submission {
	
	private float score;
	
	@Column(
			name = "created_at"
	)
	private Date createdAt = new Date();
	
}
