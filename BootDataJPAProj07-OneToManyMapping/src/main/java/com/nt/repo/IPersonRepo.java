package com.nt.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nt.entity.Person;

public interface IPersonRepo extends JpaRepository<Person,Integer> {

}
