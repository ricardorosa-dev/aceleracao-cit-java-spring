package com.challenge.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.challenge.entity.Company;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Long>{
	
//	@Query(value = "SELECT * FROM company AS co "
//			+ "INNER JOIN candidate AS ca "
//			+ "ON co.id = ca.company_id "
//			+ "INNER JOIN acceleration AS ac "
//			+ "ON ac.id = ca.acceleration_id "
//			+ "WHERE ac.id = ?1", nativeQuery = true)
	@Query(value = "SELECT DISTINCT c FROM Company c "
			+ "JOIN c.candidates ca "
			+ "JOIN ca.id.acceleration ac "
			+ "WHERE ac.id = ?1")
	List<Company> findByAccelerationId(Long accelerationId);
	
//	@Query(value = "SELECT DISTINCT name FROM company AS co "
//			+ "INNER JOIN candidate AS ca "
//			+ "ON co.id = ca.company_id "
//			+ "WHERE ca.user_id = ?1", nativeQuery = true)
	@Query(value = "SELECT DISTINCT c FROM Company c "
			+ "JOIN c.candidates ca "
			+ "JOIN ca.id cid "
			+ "JOIN cid.user u "
			+ "WHERE u.id = ?1")
	List<Company> findByUserId(Long userId);

}
