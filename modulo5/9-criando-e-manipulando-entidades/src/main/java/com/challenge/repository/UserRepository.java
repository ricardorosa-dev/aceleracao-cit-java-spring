package com.challenge.repository;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.challenge.entity.User;

import antlr.collections.impl.LList;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{
	
	@Query(value = "SELECT u.id, u.created_at, u.email, u.full_name, u.nickname, u.password\n"
			+ "FROM Users AS u\n"
			+ "   INNER JOIN\n"
			+ "   Candidate AS c\n"
			+ "   ON u.id = c.user_id\n"
			+ "   INNER JOIN\n"
			+ "   Acceleration AS a\n"
			+ "   ON a.id = c.acceleration_id\n"
			+ "   WHERE a.name = ?1", nativeQuery = true)
	List<User> findByAccelerationName(String acceleration);
	
	@Query(value = "SELECT * FROM users AS u "
			+ "INNER JOIN candidate AS c "
			+ "ON u.id = c.user_id "
			+ "INNER JOIN company AS co "
			+ "ON co.id = c.company_id "
			+ "WHERE co.id = ?1", nativeQuery = true)
	List<User> findByCompanyId(Long companyId);

}
