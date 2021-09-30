package com.challenge.entity;

import java.util.Collection;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

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
public class Challenge extends Auditable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(nullable = false, unique = true)
	private int id;
	
	@Column(nullable = false, length = 100)
	private String name;
	
	@Column(nullable = false, length = 50)
	private String slug;
	
	@OneToMany(mappedBy = "challengeId")
	private List<Acceleration> accelerations;
	
	@OneToMany(
			mappedBy = "challengeId",
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
