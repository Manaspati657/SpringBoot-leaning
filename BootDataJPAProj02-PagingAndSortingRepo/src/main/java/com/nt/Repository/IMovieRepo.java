package com.nt.Repository;


import org.springframework.data.repository.PagingAndSortingRepository;

import com.nt.entity.Movie;

public interface IMovieRepo extends PagingAndSortingRepository<Movie, Integer> {

}
