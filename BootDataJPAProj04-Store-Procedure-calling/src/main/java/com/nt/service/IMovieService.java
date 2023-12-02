package com.nt.service;

import java.util.List;

import com.nt.entity.Movie;

public interface IMovieService {
	public List<Movie> fetchMovieByYearRange(String year1,String year2);
}
