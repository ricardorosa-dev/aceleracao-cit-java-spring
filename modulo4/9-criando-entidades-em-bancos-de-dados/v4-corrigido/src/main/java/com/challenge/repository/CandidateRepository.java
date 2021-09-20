package com.challenge.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.challenge.entity.Candidate;
import com.challenge.entity.CandidateId;

@Repository
public interface CandidateRepository extends JpaRepository<Candidate, CandidateId>{

}
