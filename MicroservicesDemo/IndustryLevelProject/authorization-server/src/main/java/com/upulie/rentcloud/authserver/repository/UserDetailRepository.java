package com.upulie.rentcloud.authserver.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.upulie.rentcloud.authserver.model.User;

public interface UserDetailRepository extends JpaRepository<User, Integer>{
	Optional<User> findByUsername(String name);
}
