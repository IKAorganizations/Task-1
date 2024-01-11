package jm.task.core.jdbc;

import jm.task.core.jdbc.dao.UserDaoJDBCImpl;


public class Main {
    public static void main(String[] args) {
        UserDaoJDBCImpl jdbc = new UserDaoJDBCImpl();

        jdbc.createUsersTable();

        jdbc.saveUser("Ivan", "Ivanov", (byte) 16);
        jdbc.saveUser("Petr", "Petrov", (byte) 24);
        jdbc.saveUser("Jim", "Kerry", (byte) 45);
        jdbc.saveUser("Jack", "Daniels", (byte) 18);

        jdbc.getAllUsers();

        jdbc.dropUsersTable();

        }
}
