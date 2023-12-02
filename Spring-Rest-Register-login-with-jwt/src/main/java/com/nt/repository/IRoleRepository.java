package com.nt.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nt.entity.Role;

public interface IRoleRepository extends JpaRepository<Role, Long> {

	Optional<Role> findByName(String name);
}
