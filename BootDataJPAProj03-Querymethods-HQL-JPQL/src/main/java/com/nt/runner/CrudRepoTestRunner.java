package com.nt.runner;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nt.Repository.IMovieRepo;
import com.nt.entity.Movie;


@Component
public class CrudRepoTestRunner implements CommandLineRunner {
	
	@Autowired IMovieRepo repo;
	
	@Override
	public void run(String...args) throws Exception {
		
		
		try {
			System.out.println("---------------Query method execution (selecting all coloumns)-----------------------");
			
			List<Movie> list=repo.searchMoviesByIdRange(1, 3);
			list.forEach(System.out::println);
			System.out.println("--------------------------------------");
			List<Movie> list1=repo.searchMoviesByMnames("RRR","avatar 2","pathan");
			list1.forEach(System.out::println);

			System.out.println("---------------Query method execution with scalar Queries (selecting specific multiple coloumns)-----------------------");
		
			List<Object[]> list3= repo.fetchMovieDetailsByRatingAndYear(4.0f,"2020","2021","2022");
		    System.out.println(list3);
		    list3.forEach(row->{
				for(Object val:row)
					System.out.println(val+" ");
				System.out.println();
			});
		
			System.out.println("---------------Query method execution with scalar Queries (selecting specific single coloumn)-----------------------");
			
			List<String> list4= repo.fetchMoviesByYearRange("2020","2021");
			list4.forEach(System.out::println);
			
            System.out.println("---------------Query method execution with scalar Queries (selecting specific row only)-----------------------");
			Movie movie =repo.getById(3);
			if(movie != null) System.out.println("Movie details:: "+movie);
			else System.out.println("Movie not found");
			
			System.out.println("---------------=Aggregate functions using HQL/JPQ-----------------------");
			Object results[]=(Object[])repo.fetchAggregateDataOnMovies();
			System.out.println("Movie max rating:: "+results[0]);
			System.out.println("Movie min rating:: "+results[1]);
			System.out.println("Movie avg rating:: "+results[2]);
			System.out.println("Movies count:: "+results[3]);
			System.out.println("Movie avg year:: "+results[4]);
			System.out.println("Movie sum of rating:: "+results[5]);
			
			System.out.println("---------------sub queries using HQL/JPQ-----------------------");
			repo.fetchMaxRatingMovies().forEach(System.out::println);
			
			System.out.println("---------------Non select Query execution using HQL/JPQ-----------------------");
			
		    System.out.println("updating :: "+repo.updateRatingById(10.0f, 2));
		    System.out.println(repo.deleteMovieByYearRange("2000", "2012")+" movies are deleted.");
			
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
}
