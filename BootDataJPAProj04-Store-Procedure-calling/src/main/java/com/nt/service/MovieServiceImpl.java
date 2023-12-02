package com.nt.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.entity.Movie;

@Service("movieService")
public class MovieServiceImpl implements IMovieService{
//  EntityManager object encapsulates the functionality of HB sessionFactory,
//	session objs and provides env...to perform multiple persistence operations
	@Autowired private EntityManager manager;
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Movie> fetchMovieByYearRange(String year1,String year2){
		
		//create stored procedure query object 
		StoredProcedureQuery query=manager.createStoredProcedureQuery("P_GET_MOVIES_BY_YEAR_RANGE",Movie.class);
		
		//register parameter with JDBC types
		query.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
		query.registerStoredProcedureParameter(2, String.class, ParameterMode.IN);
		
		//set value in IN parameter 
		query.setParameter(1, year1);
		query.setParameter(2, year2);
		
		//call the PL/sql procedure and get the result
		List<Movie> list =query.getResultList();
		
		return list;
		
	}
	

}
