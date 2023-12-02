package com.nt.service;

import org.springframework.data.domain.Page;

import com.nt.entity.Movie;

public interface IMovieMgmtService {

	public Iterable<Movie> displayMovieByOrder(boolean asc,String... prop);
	
	public Page<Movie> displyMovieWithPaginationNdOrder(Integer pageNo,Integer pageSize,boolean asc,String... prop);
}
