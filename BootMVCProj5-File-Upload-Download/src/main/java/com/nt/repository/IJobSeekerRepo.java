package com.nt.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nt.entity.JobSeekerInfo;

public interface IJobSeekerRepo extends JpaRepository<JobSeekerInfo,Integer>{
	
}
