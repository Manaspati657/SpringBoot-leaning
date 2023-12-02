package com.nt.Repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.nt.entity.Movie;


@Transactional
public interface IMovieRepo extends JpaRepository<Movie, Integer> {
	
//	================Selecting all coloumn value of db table =======================
	
//	@Query("from Movie where mid>=?1 and mid <=?2")
//	@Query("from Movie as m where m.mid>=?1 and m.mid <=?2")
//	@Query("from Movie where mid>=:min and mid <=:max")
//	public List<Movie> searchMoviesByIdRange(@Param("min") int start,@Param("max") int end);
	
//  if the names of method params and HQL and JPQL query are matching then no need of placing
//	@Param annotation to map named params of query with method params
	
	@Query("from Movie where mid>=:min and mid <=:max")  
	public List<Movie> searchMoviesByIdRange(int min,int max);
	
	@Query("from Movie where mname In(:name1,:name2,:name3) order by mname asc")
	public List<Movie> searchMoviesByMnames(String name1,String name2,String name3);
	
	
//	==============Scallar Queries : selecting specific multiple col values ===============
	
	@Query("select mid,mname,myear from Movie where rating >=:rat and myear in(:y1,:y2,:y3)")
	public List<Object[]> fetchMovieDetailsByRatingAndYear(float rat,String y1,String y2,String y3);
	
//	==============Scallar Queries : selecting specific single col values ===============
	
	@Query("select mname from Movie where myear>=:start and myear<=:end order by mname desc")
	public List<String> fetchMoviesByYearRange(String start,String end);
	
	
//	==============Scallar Queries : selecting single row only ===============
	
	@Query("from Movie where mid=:id")
	public Movie getById(int id);
	
//	===============Aggregate functions using HQL/JPQL========================
	
	@Query("select max(rating),min(rating),avg(rating),count(*),avg(myear),sum(rating) from Movie")
	public Object fetchAggregateDataOnMovies();
	
//	===============Sub Query using HQL/JPQL========================
	
	@Query("from Movie where rating=(select max(rating) from Movie)")
	public List<Movie> fetchMaxRatingMovies();
	
//	===============non select operation using HQL/JPQL========================
//	for non select query we have to use two other annotation @Modifying and @Transactional
//  @Modifying we have used with every @Query annotation and @Transactional we can add it 
//	globaly in top of interface or with every @Query annotation
	
	@Query("update Movie set rating=:newRating where mid=:id")
	@Modifying
//	@Transactional
	public int updateRatingById(float newRating,int id);
	
	@Query("delete from Movie where myear>=:start and myear <=:end")
	@Modifying
//	@Transactional
	public int deleteMovieByYearRange(String start,String end);
	
	
}



















