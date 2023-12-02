package com.nt.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.Repository.IMovieRepo;
import com.nt.entity.Movie;

@Service("movieService")
public class MovieMgmtServiceImpl implements IMovieMgmtService {

	@Autowired private IMovieRepo movieRepo;
	
	@Override
	public String registerMovie(Movie movie) {
		
		System.out.println("inMemory proxy class name :: "+movieRepo.getClass()+"........."+Arrays.toString(movieRepo.getClass().getInterfaces()));
		
		System.out.println("Before saving movie:: "+movie);
		
		Movie movie1=movieRepo.save(movie);
		
		System.out.println("After saving movie :: "+movie1);
		
		
		return "Movie is register with id value :"+movie1.getMid();
	}


	@Override
	public long fetchMovieCount() {
		return movieRepo.count();
	}
	
	@Override
	public boolean existById(Integer id) {
		return movieRepo.existsById(id);
	}
	
	@Override
	public Optional<Movie> getById(Integer id) {
//		public Movie getById(Integer id) {
		
		
//		if our return type in Optional<Movie> then we can take this approach
		Optional<Movie> movieById=movieRepo.findById(id);
		return movieById.isEmpty() ? Optional.empty() : movieById ;
		
		//in one line handle exception
//		return movieRepo.findById(id).orElse(new Movie());
		
		
		//we can throw exception if not find or we can send empty obj
//		Optional<Movie> movieById=movieRepo.findById(id);
		
//		if(movieById.isPresent()) {
//			return movieById.get();
//		}else {
////			throw new IllegalArgumentException("Record not found");
//		}
	}
	
	@Override
	public Iterable<Movie> getAllMovies(){
		return movieRepo.findAll();
	}
	
	@Override
	public Iterable<Movie> getAllMoviesByIds(List<Integer> ids){
		return movieRepo.findAllById(ids);
	}

	@Override
	public String registerGroupOfMovies(List<Movie> moviesList) {
		
		Iterable<Movie> savedMovies=movieRepo.saveAll(moviesList);
		List<Integer> listIds=new ArrayList();
		if(savedMovies != null && ((List<Movie>)savedMovies).size()> 0) {
			savedMovies.forEach(m-> listIds.add(m.getMid()));
		}
		return listIds.toString()+" movies are saved";
	}
	
	@Override
	public String updateMovie(Movie movie) {
		
		System.out.println("inMemory proxy class name :: "+movieRepo.getClass()+"........."+Arrays.toString(movieRepo.getClass().getInterfaces()));
		
		System.out.println("Before update movie:: "+movieRepo.findById(movie.getMid()));
		
		Movie movie1=movieRepo.save(movie);
		
		System.out.println("After update movie :: "+movie1);
		
		
		return "Movie is updated with id value :"+movie1.getMid();
	}

	
	@Override
	public String deleteById(Integer id) {
		
		movieRepo.deleteById(id);
		return "movie deleted id::"+id;
	}
}
