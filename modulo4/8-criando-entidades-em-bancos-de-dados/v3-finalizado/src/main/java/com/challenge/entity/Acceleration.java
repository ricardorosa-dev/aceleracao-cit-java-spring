package com.challenge.entity;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Acceleration extends Auditable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(nullable = false, unique = true)
	private int id;
	
	@Column(nullable = false, length = 100)
	private String name;
	
	@Column(nullable = false, length = 50)
	private String slug;
	
	@ManyToOne(
			fetch = FetchType.LAZY,
			cascade = CascadeType.MERGE
	)
	@JoinColumn(
			name = "challenge_id",
			referencedColumnName = "id"
	)
	private Challenge challengeId;
	
	@OneToMany(mappedBy = "acceleration")
	private Collection<Candidate> candidate = new ArrayList<>();

	public Acceleration(String name, String slug) {
		this.name = name;
		this.slug = slug;
	}
	
	public void addCandidate(Candidate candidate) {
		this.candidate.add(candidate);
	}
	

}
