package com.ripple.movies.service;
import com.ripple.movies.model.MovieList;
import com.ripple.movies.dao.*;
import java.util.*;
import com.ripple.movies.exception.InvalidInputException;

public class MovieService {
	private final MovieDAO movieDAO=new MovieDAO();
	
	public void addMovie(MovieList movie) {
		
		movieDAO.addMovie(movie);
	}
	public void updateMovie(int id,String movieName,String directorName,double amount) {
		MovieList existingMovie=movieDAO.getMovieById(id);
		if(existingMovie==null) {
			throw new InvalidInputException("Movie with Id "+id+ " not found"); 
		}
		  if (!movieName.isEmpty()) {
	            existingMovie.setMovieName(movieName);
	        }
	        if (!directorName.isEmpty()) {
	            existingMovie.setDirectorName(directorName);
	        }
	        if (!Double.isNaN(amount)) {
	            existingMovie.setAmount(amount);
	        }
	        movieDAO.updateMovie(existingMovie);
	    }
	public void deleteMovie(int id) {
		MovieList existingMovie=movieDAO.getMovieById(id);
		if(existingMovie==null) {
			throw new InvalidInputException("Movie with Id "+id+ " not found"); 
		}
		movieDAO.deleteMovie(id);

		
	}
	 public MovieList getMovieById(int id) {
	        List<MovieList> movies = movieDAO.getAllMovies();

	        for (MovieList movie : movies) {
	            if (movie.getId() == id) {
	                return movie; 
	            }
	        }
	        return null;
	 }
	 public List<MovieList> getAllMovies(){
		return movieDAO.getAllMovies();
	}
	

	}


