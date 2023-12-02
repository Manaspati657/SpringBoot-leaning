package com.nt.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nt.entity.PhoneNumber;

public interface IPhoneNumberRepo extends JpaRepository<PhoneNumber,Integer> {

}
