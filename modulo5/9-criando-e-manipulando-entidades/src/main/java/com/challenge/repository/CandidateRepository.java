package com.challenge.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.challenge.entity.Candidate;
import com.challenge.entity.CandidateId;

@Repository
public interface CandidateRepository extends JpaRepository<Candidate, CandidateId>{
	
//	@Query(value = "")
	@Query(value = "SELECT * FROM candidate "
			+ "WHERE user_id = ?1 "
			+ "OR company_id = ?2 "
			+ "OR acceleration_id = ?3"
			+ "LIMIT 1", nativeQuery = true)
	java.util.Optional<Candidate> findById(Long userId, Long companyId, Long accelerationId);
	
	@Query(value = "SELECT * FROM candidate AS ca "
			+ "WHERE ca.company_id = ?1", nativeQuery = true)
	List<Candidate> findByCompanyId(Long companyId);
	
	@Query(value = "SELECT * FROM candidate AS ca \n"
			+ "INNER JOIN acceleration AS ac\n"
			+ "ON ca.acceleration_id = ac.id\n"
			+ "WHERE ac.id = ?1", nativeQuery = true)
	List<Candidate> findByAccelerationId(Long accelerationId);

}
