package com.beehyv.algebra_services;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

import com.beehyv.algebra_services.User;

@Repository
public interface AlgebraServicesRepository extends JpaRepository<User, Long>{

	List<User> findByUserId(String userId);
}