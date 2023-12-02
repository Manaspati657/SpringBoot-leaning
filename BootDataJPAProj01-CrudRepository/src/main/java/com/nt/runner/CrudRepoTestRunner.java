package com.nt.runner;




import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nt.entity.Movie;
import com.nt.service.IMovieMgmtService;


@Component
public class CrudRepoTestRunner implements CommandLineRunner {

	@Autowired IMovieMgmtService movieService;
	
	@Override
	public void run(String...args) throws Exception {
		Movie movie=new Movie();
		movie.setMname("avatar");
		movie.setMyear("2023");
		movie.setRating(5.0f);
		try {
//			System.out.println(movieService.registerMovie(movie));
			System.out.println("--------------------------------------");
			
//			String result=movieService.registerGroupOfMovies(List.of(new Movie("pathan","2023",5.6f),new Movie("money heist","2016",9.9f)));
//			System.out.println(result);
			
			System.out.println("--------------------------------------");
			
			System.out.println(movieService.fetchMovieCount());
			System.out.println(movieService.existById(1));
			System.out.println(movieService.existById(9));
			
			System.out.println("--------------------------------------");
			
			System.out.println("1 movie is :: "+movieService.getById(1));
			System.out.println("99 movie is :: "+movieService.getById(99)); //this line throw exception or we handle and send new empty obj
			
			System.out.println("--------------------------------------");
			Iterable<Movie> mlist=movieService.getAllMovies();
			
//			for(Movie movies:mlist) {  //enhanced for loop
//				System.out.println(movies);
//			}
			
			mlist.forEach(movie1-> System.out.println(movie1)); //forEach() method
			
//			mlist.forEach(System.out::println); //foreach() method + static method reference
			System.out.println("--------------------------------------");
			
			List<Integer> idsList=new ArrayList();
			idsList.add(1);idsList.add(2);
			
			System.out.println("moviees are::"+movieService.getAllMoviesByIds(idsList));
			System.out.println("--------------------------------------");
			//java 9 
			System.out.println("moviees are::"+movieService.getAllMoviesByIds(List.of(1,2)));
			System.out.println("--------------------------------------");
//			
//			Movie movie2=new Movie();
//			movie2.setMid(2);
//			movie2.setMname("Avatar 2");
//			movie2.setMyear("2022");
//			movie2.setRating(9.9f);
//			System.out.println("update-----::"+movieService.updateMovie(movie2));
			System.out.println("--------------------------------------");
			
//			System.out.println("delete:::--------"+movieService.deleteById(5));
			
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
}
