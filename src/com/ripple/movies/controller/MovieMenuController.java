package com.ripple.movies.controller;
import com.ripple.movies.model.MovieList;
import com.ripple.movies.exception.InvalidInputException;
import com.ripple.movies.validation.FieldValidation;
import com.ripple.movies.service.MovieService;

import java.util.List;
import java.util.Scanner;

public class MovieMenuController {
	private final MovieService movieService=new MovieService();
	private final Scanner sc;
	
	public MovieMenuController(Scanner sc) {
		this.sc=sc;
	}
	public void handleMenuChoice(int choice) {
		switch(choice) {
		case 1:
			String movieName,directorName,amountstr;
			double amount=0.0;
			while(true) {
			System.out.println("Enter the Movie Name: ");
			movieName=sc.nextLine();
			boolean isDuplicate = false;
			    for (MovieList existingMovie : movieService.getAllMovies()) {
			        if (existingMovie.getName().equalsIgnoreCase(movieName)) {
			            isDuplicate = true;
			            break;
			        }
			    }

			    if (isDuplicate) {
			        System.out.println("A movie with the same name already exists.");
			        continue; 
			    }

			    if (!FieldValidation.isValidationString(movieName)) {
			        System.out.println("Name should be a String");
			        continue;
			    } else {
			        break;
			    }
			}
		
			
			while(true) {
			System.out.println("Enter the Director Name: ");
			directorName=sc.nextLine();
			if(!FieldValidation.isValidationString(directorName)) {
				System.out.println("Director Name should be a String");
				continue;
			}else {
				break;
			}
			}
			while(true) {
			System.out.println("Enter the Amount: ");
			amountstr=sc.nextLine();
			try {
				if(!FieldValidation.isValidationInteger(amountstr)) {
					System.out.println("Please enter valid Integer");
					continue;
				}
				 amount=Double.parseDouble(amountstr);
				break;
			}catch(InvalidInputException e) {
				System.out.println(e.getMessage());
				continue;
			}
			}
				MovieList list= new MovieList(movieService.getAllMovies().size() + 1, movieName,directorName,amount);
				movieService.addMovie(list);
				System.out.println("Movie Added Successfully!!!");
				 
                break;
		case 2:
			System.out.print("Enter the ID of the movie: ");
            int updatedId = sc.nextInt();
            sc.nextLine(); 
            MovieList existingMovie = movieService.getMovieById(updatedId);
            if (existingMovie == null) {
                System.out.println("Movie not found.");
            } else {
                System.out.println("Movie ID: " + existingMovie.getId());
            
            
            System.out.println("Movie Name: " + existingMovie.getName());
			System.out.println("Enter the Updated Movie Name: ");
			String updatedMovieName=sc.nextLine();
			if(!updatedMovieName.isEmpty()) {
				existingMovie.setMovieName(updatedMovieName);
			}
			else {
				 updatedMovieName=existingMovie.getName();
			}
			System.out.println("Director Name: " + existingMovie.getDirectorName());
			System.out.println("Modify the Director Name: ");
			String updatedDirectorName=sc.nextLine();
			if(!updatedDirectorName.isEmpty()) {
				existingMovie.setDirectorName(updatedDirectorName);
			}
			else {
				 updatedDirectorName=existingMovie.getDirectorName();
			}
			System.out.println("Amount: " + existingMovie.getAmount());
			System.out.println("Modify the Amount: ");
			String updatedAmountStr=sc.nextLine();
			double updatedAmount=0.0;
			if(!updatedAmountStr.isEmpty()) {
				if (FieldValidation.isValidationInteger(updatedAmountStr)) {
                     updatedAmount = Double.parseDouble(updatedAmountStr);
                    existingMovie.setAmount(updatedAmount);
                } else {
                    System.out.println("Invalid input for amount. Movie not updated.");
                	
                }
			}
				else {
					updatedAmount=existingMovie.getAmount();
				}
			
			movieService.updateMovie(updatedId,updatedMovieName,updatedDirectorName,updatedAmount);
			System.out.println("Movie updated Successfully!!");
            }
            break;
            
			
		case 3:
			System.out.println("Enter the Movie Id which has to be deleted: ");
			int deleteId=sc.nextInt();
			MovieList existingMovie1 = movieService.getMovieById(deleteId);
			if (existingMovie1 == null) {
			    System.out.println("Movie not found.");
			} else {
			    movieService.deleteMovie(deleteId);
			    System.out.println("Movie Deleted Successfully!!");
			}
			break;
			
		case 4:
			List<MovieList> allmovies=movieService.getAllMovies();
			for(MovieList m:allmovies) {
				System.out.println(m);
			}
            break;
			
		
		case 5:
			System.out.println("Enter the Id to get the Movie Details: ");
			int movieId=sc.nextInt();
			MovieList retrievedMovie=movieService.getMovieById(movieId);
			if(retrievedMovie!=null) {
				System.out.println(retrievedMovie);
			}
			else{
				System.out.println("Movie Not Found");
			}
			
            break;
            
		default:
			System.out.println("Invalid Choice");
			break;
		
				
		}
	}

}
