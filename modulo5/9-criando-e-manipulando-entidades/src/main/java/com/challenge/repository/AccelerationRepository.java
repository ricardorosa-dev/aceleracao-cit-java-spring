package com.challenge.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.challenge.entity.Acceleration;

@Repository
public interface AccelerationRepository extends JpaRepository<Acceleration, Long>{
	
	@Query(value = "SELECT * FROM acceleration AS ac "
			+ "INNER JOIN candidate AS ca "
			+ "ON ac.id = ca.acceleration_id "
			+ "WHERE ca.company_id = ?1", nativeQuery = true)
	List<Acceleration> findByCompanyId(Long CompanyId);

}
