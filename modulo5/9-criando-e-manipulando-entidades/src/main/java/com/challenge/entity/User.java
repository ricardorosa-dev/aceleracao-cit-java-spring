package com.challenge.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@EntityListeners(AuditingEntityListener.class)
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    @NotNull
    @Size(max = 100)
    private String fullName;

    @Column
    @Email
    @Size(max = 100)
    @NotNull
    private String email;

    @Column
    @NotNull
    @Size(max = 50)
    private String nickname;

    @Column
    @NotNull
    @Size(max = 255)
    private String password;

    @Column
    @CreatedDate
    private LocalDateTime createdAt;

    @OneToMany(mappedBy = "id.user")
    private List<Candidate> candidates;

    @OneToMany(mappedBy = "id.user")
    private List<Submission> submissions = new ArrayList<>();
    
    public void addCandidate(Candidate candidate) {
    	this.candidates.add(candidate);
    }
    
    public void addSubmission(Submission submission) {
    	this.submissions.add(submission);
    }

	public User(@NotNull @Size(max = 100) String fullName, @Email @Size(max = 100) @NotNull String email,
			@NotNull @Size(max = 50) String nickname, @NotNull @Size(max = 255) String password,
			LocalDateTime createdAt) {
		super();
		this.fullName = fullName;
		this.email = email;
		this.nickname = nickname;
		this.password = password;
		this.createdAt = createdAt;
	}


    
}
