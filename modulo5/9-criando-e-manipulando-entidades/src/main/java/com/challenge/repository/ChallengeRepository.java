package com.challenge.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.challenge.entity.Challenge;

@Repository
public interface ChallengeRepository extends JpaRepository<Challenge, Long>{
	
//	@Query(value = "SELECT * FROM challenge AS ch "
//			+ "INNER JOIN acceleration AS ac "
//			+ "ON ch.id = ac.challenge_id "
//			+ "INNER JOIN candidate as ca "
//			+ "ON ac.id = ca.acceleration_id "
//			+ "WHERE ac.id = ?1 "
//			+ "AND ca.user_id = ?2", nativeQuery = true)
	@Query(value = "SELECT c FROM Challenge c "
			+ "JOIN c.accelerations ac "
			+ "JOIN ac.candidates ca "
			+ "WHERE ac.id = ?1 "
			+ "AND ca.id.user.id = ?2")
	List<Challenge> findByAccelerationIdAndUserId(Long accelerationId, Long userId);

}
