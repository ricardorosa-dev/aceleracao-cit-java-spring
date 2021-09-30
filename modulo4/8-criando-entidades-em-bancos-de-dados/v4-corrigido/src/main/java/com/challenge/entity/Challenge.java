package com.challenge.entity;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class Challenge extends Auditable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(nullable = false, unique = true)
	private int id;
	
	@Column(nullable = false, length = 100)
	@Size(max = 100)
	@NotNull
	private String name;
	
	@Column(nullable = false, length = 50)
	@NotNull
	@Size(max = 50)
	private String slug;
	
	@Column(name = "created_at")
	@CreatedDate
	private Date createdAt;
	
	@OneToMany(mappedBy = "challengeId")
	private List<Acceleration> accelerations;
	
	@OneToMany(mappedBy = "challenge")
	private List<Submission> submissions = new ArrayList<>();
	
	public void addSubmission(Submission submission) {
		this.submissions.add(submission);
	}

	public Challenge(@Size(max = 100) @NotNull String name, @NotNull @Size(max = 50) String slug) {
		super();
		this.name = name;
		this.slug = slug;
	}
	
	
}
