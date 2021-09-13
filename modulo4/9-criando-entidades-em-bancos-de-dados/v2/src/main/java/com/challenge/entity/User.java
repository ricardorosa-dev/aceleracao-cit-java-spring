package com.challenge.entity;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
	
	@OneToMany(
			mappedBy = "userId",
			cascade = CascadeType.ALL
	)
	private Collection<Submission> submissions;
	
	
	public Collection<Submission> getSubmissions() {
		return submissions;
	}
	
	public void setSubmissions(Collection<Submission> submissions) {
		this.submissions = submissions;
	}
	
}
