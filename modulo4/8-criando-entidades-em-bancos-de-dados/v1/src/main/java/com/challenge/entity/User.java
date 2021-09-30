package com.challenge.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.data.annotation.CreatedDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
	
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
	
//	@CreatedDate
//	@Column(name = "created_at", nullable = false)
//	private Date createdAt;
	
}
