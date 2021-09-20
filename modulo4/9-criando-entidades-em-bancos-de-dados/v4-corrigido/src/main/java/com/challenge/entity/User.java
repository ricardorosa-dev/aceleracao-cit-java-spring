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
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class User{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(nullable = false, unique = true)
	private int id;
	
	@Column(name = "full_name", nullable = false, length = 100)
	@Size(max = 100)
	@NotNull
	private String fullName;
	
	@Column(nullable = false, length = 100)
	@Size(max = 100)
	@NotNull
	@Email(message = "O email deve ser válido.")
	private String email;
	
	@Column(nullable = false, length = 50)
	@Size(max = 50)
	@NotNull
	private String nickname;
	
	@Column(nullable = false, length = 255)
	@Size(max = 255)
	@NotNull
	private String password;
	
	@Column(name = "created_at")
	@CreatedDate
	private Date createdAt;
	
	@OneToMany(mappedBy = "user")
	private List<Candidate> candidate = new ArrayList<>();
	
	@OneToMany(mappedBy = "user")
	private List<Submission> submissions = new ArrayList<>();
	
	public void addSubmission(Submission submission) {
		this.submissions.add(submission);
	}
	
	public void addCandidate(Candidate candidate) {
		this.candidate.add(candidate);
	}

	public User(String fullName, String email, String nickname, String password) {
		this.fullName = fullName;
		this.email = email;
		this.nickname = nickname;
		this.password = password;
	}
	
	
	
}
