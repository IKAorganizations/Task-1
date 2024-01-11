package jm.task.core.jdbc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Util {
    // реализуйте настройку соеденения с БД
        public static final String DB = "Task-1";
        public static final String URL = "jdbc:postgresql://localhost:5432/"+DB;
        public static final String USER = "postgres";
        public static final String PASSWORD = "rootroot";

        public static final String CREATE_TABLE = "CREATE TABLE IF NOT EXISTS users (id SERIAL PRIMARY KEY, name VARCHAR, lastName varchar, age INT)";
        public static final String DROP_TABLE = "DROP TABLE IF EXISTS users";
        public static final String INSERT_INTO = "INSERT INTO users (name, lastname, age) VALUES (?, ?, ?)";
        public static final String DELETE_FROM = "DELETE FROM users WHERE id = ?";
        public static final String CLEAN = "DELETE FROM users";


        public static Connection getConn () throws SQLException {
                Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
                return conn;
        }
}
