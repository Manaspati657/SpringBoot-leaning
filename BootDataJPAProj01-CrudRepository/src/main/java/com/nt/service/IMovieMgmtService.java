package com.nt.service;

import java.util.List;
import java.util.Optional;

import com.nt.entity.Movie;

public interface IMovieMgmtService {

	public String registerMovie(Movie movie);
	
	public long fetchMovieCount();
	
	public boolean existById(Integer id);
	
	public Optional<Movie> getById(Integer id);
	
	public Iterable<Movie> getAllMovies();
	
	public Iterable<Movie> getAllMoviesByIds(List<Integer> ids);
	
	public String registerGroupOfMovies(List<Movie> movieList);

	public String updateMovie(Movie movie);
	
	public String deleteById(Integer id);
}
