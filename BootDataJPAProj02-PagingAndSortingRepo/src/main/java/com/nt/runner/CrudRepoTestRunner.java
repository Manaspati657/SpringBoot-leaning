package com.nt.runner;




import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import com.nt.entity.Movie;
import com.nt.service.IMovieMgmtService;


@Component
public class CrudRepoTestRunner implements CommandLineRunner {

	@Autowired IMovieMgmtService movieService;
	
	@Override
	public void run(String...args) throws Exception {
		
		try {
			System.out.println("---------------sorting by name-----------------------");
			
			Iterable<Movie> list=movieService.displayMovieByOrder(true,"mname");
			list.forEach(System.out::println);

			System.out.println("----------------pagiantion data------page 1----------------");
			
			Page<Movie> page=movieService.displyMovieWithPaginationNdOrder(1, 3,true,"mname");
			
			System.out.println("Page Number::"+page.getNumber());
			System.out.println("Page count::"+page.getTotalPages());
			System.out.println("is it first Page::"+page.isFirst());
			System.out.println("is it last Page::"+page.isLast());
			System.out.println("Page size::"+page.getSize());
			System.out.println("Page Element Count::"+page.getNumberOfElements());
			
			if(!page.isEmpty()) {
				List<Movie> list1=page.getContent();
				list1.forEach(System.out::println);
			}
            
			System.out.println("----------------pagiantion data----page 2------------------");
			
			Page<Movie> page2=movieService.displyMovieWithPaginationNdOrder(2, 3,true,"mname");
			
			System.out.println("Page Number::"+page2.getNumber());
			System.out.println("Page count::"+page2.getTotalPages());
			System.out.println("is it first Page::"+page2.isFirst());
			System.out.println("is it last Page::"+page2.isLast());
			System.out.println("Page size::"+page2.getSize());
			System.out.println("Page Element Count::"+page2.getNumberOfElements());
			
			if(!page2.isEmpty()) {
				List<Movie> list2=page.getContent();
				list2.forEach(System.out::println);
			}

			
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
}
