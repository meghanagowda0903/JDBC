package com.ripple.movies.model;

public class MovieList {
	
	private int id;
	private String movieName;
	private String directorName;
	private double amount;
	
	
	public MovieList(int id, String movieName, String directorName, double amount ){
		this.id=id;
		this.movieName=movieName;
		this.directorName=directorName;
		this.amount=amount;
		
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id=id;
	}
	public String getName() {
		return movieName;
	}
	public void setMovieName(String movieName) {
		this.movieName=movieName;
	}
	public String getDirectorName() {
		return directorName;
	}
	public void setDirectorName(String directorName) {
		this.directorName=directorName;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount=amount;
	}
	
	
    public String toString() {
        return "Movie [id=" + id + ", name=" + movieName + ", amount=" + amount + ", directorName=" + directorName + "]";
    }
}



