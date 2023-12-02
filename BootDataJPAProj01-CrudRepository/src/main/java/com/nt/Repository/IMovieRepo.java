package com.nt.Repository;

import org.springframework.data.repository.CrudRepository;

import com.nt.entity.Movie;

public interface IMovieRepo extends CrudRepository<Movie, Integer> {

}
