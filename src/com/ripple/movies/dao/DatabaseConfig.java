package com.ripple.movies.dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConfig {
	private static final String JDBC_URL = "jdbc:mysql://localhost:3306/movie";
    private static final String JDBC_USERNAME = "root";
    private static final String JDBC_PASSWORD = "#Travel5";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(JDBC_URL, JDBC_USERNAME, JDBC_PASSWORD);
    }
}


