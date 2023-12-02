package com.nt.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.nt.Repository.IMovieRepo;
import com.nt.entity.Movie;

@Service("movieService")
public class MovieMgmtServiceImpl implements IMovieMgmtService {

	@Autowired private IMovieRepo movieRepo;
	
	@Override
	public Iterable<Movie> displayMovieByOrder(boolean asc,String... prop){
		//create a sort object
		Sort sort=Sort.by(asc?Direction.ASC:Direction.DESC,prop);
		return movieRepo.findAll(sort);
	}
	
	@Override
	public Page<Movie> displyMovieWithPaginationNdOrder(Integer pageNo,Integer pageSize,boolean asc,String... prop){
		//create a Pageable object
		Pageable pageable=PageRequest.of(pageNo-1, pageSize,Sort.by(asc?Direction.ASC:Direction.DESC,prop));
		Page<Movie> page=movieRepo.findAll(pageable);
		return page;
		
	}
}
