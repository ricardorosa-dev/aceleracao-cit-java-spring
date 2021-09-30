package com.challenge.repository;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.challenge.entity.Submission;
import com.challenge.entity.SubmissionId;

@Repository
public interface SubmissionRepository extends JpaRepository<Submission, SubmissionId>{
	
	@Query(value = "SELECT score FROM submission "
			+ "WHERE challenge_id = ?1 "
			+ "ORDER BY score "
			+ "DESC LIMIT 1", nativeQuery = true)
//	@Query(value = "SELECT s FROM Submission s "
//			+ "WHERE s.challenge_id = ?1 "
//			+ "ORDER BY s.score "
//			+ "DESC LIMIT 1") 
//	JPQL não tem LIMIT! Tem que fazer com paginação. Vou aprender mais tarde.
	BigDecimal findHigherScoreByChallengeId(Long challengeId);
	
//	@Query(value = "SELECT * FROM submission AS su "
//			+ "INNER JOIN challenge AS ch "
//			+ "ON ch.id = su.challenge_id "
//			+ "INNER JOIN acceleration AS ac "
//			+ "ON ch.id = ac.challenge_id "
//			+ "WHERE ch.id = ?1 "
//			+ "AND ac.id = ?2", nativeQuery = true)
	@Query(value = "SELECT s FROM Submission s "
			+ "JOIN s.id.challenge ch "
			+ "JOIN ch.accelerations ac "
			+ "WHERE ch.id = ?1 "
			+ "AND ac.id = ?2")
	List<Submission> findByChallengeIdAndAccelerationId(Long challengeId, Long accelerationId);

}
