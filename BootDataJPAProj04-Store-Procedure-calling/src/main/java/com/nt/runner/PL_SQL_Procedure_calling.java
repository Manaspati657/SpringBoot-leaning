package com.nt.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nt.service.IMovieService;


@Component
public class PL_SQL_Procedure_calling implements CommandLineRunner {
	

	@Autowired IMovieService service;
	
	@Override
	public void run(String... args)throws Exception{
		
		service.fetchMovieByYearRange("2020", "2022").forEach(System.out::println);
		
	}

}

