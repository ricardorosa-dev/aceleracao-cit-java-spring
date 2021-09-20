package com.challenge.entity;

import java.sql.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EntityListeners(AuditingEntityListener.class)
public class Company extends Auditable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(nullable = false, unique = true)
	private int id;
	
	@Column(nullable = false, length = 100)
	@NotNull
	@Size(max = 100)
	private String name;
	
	@Column(nullable = false, length = 50)
	@Size(max = 50)
	@NotNull
	private String slug;
	
	@Column(name = "created_at")
	@CreatedDate
	private Date createdAt;
	
	@OneToMany(
			mappedBy = "company",
			cascade = CascadeType.MERGE
	)
	private List<Candidate> candidates;

	public Company(String name, String slug) {
		super();
		this.name = name;
		this.slug = slug;
	}
	
	

}
