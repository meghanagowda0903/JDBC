package com.ripple.movies.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.*;
import com.ripple.movies.model.*;

public class MovieDAO {
	public void addMovie(MovieList movie) {
		try {
			Connection connection=DatabaseConfig.getConnection();
			String insertQuery="INSERT INTO movies(MovieName,DirectorName,Amount) VALUES(?,?,?)";
			PreparedStatement preparedStatement=connection.prepareStatement(insertQuery);
			preparedStatement.setString(1,movie.getName());
			preparedStatement.setString(2,movie.getDirectorName());
			preparedStatement.setDouble(3,movie.getAmount());
			preparedStatement.executeUpdate();
			preparedStatement.close();
			connection.close();
		}catch(SQLException e) {
			e.printStackTrace();
			}
		}
	public void updateMovie(MovieList movie) {
		try{
			Connection connection=DatabaseConfig.getConnection();
			String updateQuery="UPDATE movies SET MovieName=?, DirectorName=?, Amount=?";
			PreparedStatement preparedStatement=connection.prepareStatement(updateQuery);
				preparedStatement.setString(1,movie.getName());
				preparedStatement.setString(2,movie.getDirectorName());
				preparedStatement.setDouble(3, movie.getAmount());
				preparedStatement.executeUpdate();
				preparedStatement.close();
				connection.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	public void deleteMovie(int movieId) {
		try{
			Connection connection=DatabaseConfig.getConnection();
			String deleteQuery="DELETE FROM movies WHERE id=?";
			PreparedStatement preparedStatement=connection.prepareStatement(deleteQuery);
				preparedStatement.setInt(1, movieId);
				preparedStatement.executeUpdate();
				preparedStatement.close();
				connection.close();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	public MovieList getMovieById(int movieId) {
		MovieList movie=null;
		try{
			Connection connection=DatabaseConfig.getConnection();
			String selectQuery="SELECT * FROM movies WHERE id=?";
			PreparedStatement preparedStatement=connection.prepareStatement(selectQuery);
				preparedStatement.setInt(1, movieId);
			ResultSet resultSet=preparedStatement.executeQuery();
				if(resultSet.next()) {
					movie=new MovieList(
							resultSet.getInt("id"),
							resultSet.getString("movieName"),
							resultSet.getString("directorName"),
							resultSet.getDouble("Amount")
							);
				}
				resultSet.close();
				preparedStatement.close();
				connection.close();
				}catch(SQLException e) {
			e.printStackTrace();
		}
		return movie;
	}
	public List<MovieList> getAllMovies(){
		List<MovieList> movieList=new ArrayList<>();
		try{
			Connection connection=DatabaseConfig.getConnection();
			String selectQuery="SELECT * FROM movies";
			PreparedStatement preparedStatement=connection.prepareStatement(selectQuery);
			ResultSet resultSet=preparedStatement.executeQuery();
					while(resultSet.next()) {
						MovieList movie=new MovieList(
								resultSet.getInt("id"),
								resultSet.getString("movieName"),
								resultSet.getString("directorName"),
								resultSet.getDouble("Amount")
								);
						movieList.add(movie);
								
					}
					resultSet.close();
					preparedStatement.close();
					connection.close();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return movieList;
	}
	}


