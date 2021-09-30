package com.challenge.entity;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

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
public class User extends Auditable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(nullable = false, unique = true)
	private int id;
	
	@Column(name = "full_name", nullable = false, length = 100)
	private String fullName;
	
	@Column(nullable = false, length = 100)
	private String email;
	
	@Column(nullable = false, length = 50)
	private String nickname;
	
	@Column(nullable = false, length = 255)
	private String password;
	
	@OneToMany(mappedBy = "user")
	private List<Candidate> candidate = new ArrayList<>();
	
//	@ManyToMany
//	@JoinTable(
//			name = "submission2",
//			joinColumns = @JoinColumn(name = "user_id"),
//			inverseJoinColumns = @JoinColumn(name = "challenge_id")
//	)
//	private List<Challenge> challenges = new ArrayList<>();
	
//	public void addChallenge(Challenge challenge) {
//	this.challenges.add(challenge);
//}
	
	@OneToMany(mappedBy = "user")
	private List<Submission> submissions = new ArrayList<>();
	
	public void addSubmission(Submission submission) {
		this.submissions.add(submission);
	}
	
	
//	public Collection<Submission> getSubmissions() {
//		return submissions;
//	}
	
//	public void setSubmissions(Collection<Submission> submissions) {
//		this.submissions = submissions;
//	}
	
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
