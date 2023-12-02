package com.nt.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nt.entity.Role;

public interface IRoleRepository extends JpaRepository<Role, Integer> {

}
