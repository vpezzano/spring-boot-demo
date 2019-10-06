package io.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.spring.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{
	User findByName(String name);
}
