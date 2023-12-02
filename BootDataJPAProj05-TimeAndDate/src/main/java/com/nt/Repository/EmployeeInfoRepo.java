package com.nt.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nt.entity.Employee;

public interface EmployeeInfoRepo extends JpaRepository<Employee,Integer> {

}
