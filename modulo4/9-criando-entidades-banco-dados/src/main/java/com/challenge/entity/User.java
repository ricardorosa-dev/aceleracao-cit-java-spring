package com.challenge.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.transaction.annotation.Transactional;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User {
	
	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@SequenceGenerator(
			allocationSize=1, 
			schema="codenation-9",  
			name="MySequenceGenerator", 
			sequenceName = "mysequence")
	@GeneratedValue(
			strategy= GenerationType.SEQUENCE, 
			generator="MySequenceGenerator")
	private int id;
	
	@Column(
		name = "full_name",
		length = 100,
		nullable = false
	)
	private String fullName;
	
	@Column(
		length = 100,
		nullable = false
	)
	private String email;
	
	@Column(
		length = 50,
		nullable = false
	)
	private String nickname;
	
	@Column(
		length = 255,
		nullable = false
	)
	private String password;
	
	@Column(
			name = "created_at",
			nullable = false
	)
	private final Date createdAt = new Date();

}
