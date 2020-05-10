package com.doctorappointment.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.doctorappointment.domain.User;

public interface UserRepository extends JpaRepository<User, Integer>{
	
	@Query("SELECT u FROM user u WHERE u.email = ?1")
	Optional<User> findByEmail(String email);
}
