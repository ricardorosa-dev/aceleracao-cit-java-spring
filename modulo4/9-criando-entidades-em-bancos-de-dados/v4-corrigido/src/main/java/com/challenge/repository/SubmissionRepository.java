package com.challenge.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.challenge.entity.Submission;
import com.challenge.entity.SubmissionId;

public interface SubmissionRepository extends JpaRepository<Submission, SubmissionId> {

}
