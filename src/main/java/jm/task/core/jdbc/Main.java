package jm.task.core.jdbc;


import jm.task.core.jdbc.dao.UserDaoHibernateImpl;
import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import static jm.task.core.jdbc.util.Util.CREATE_TABLE;
import static jm.task.core.jdbc.util.Util.getSession;


public class Main {
    public static void main(String[] args) {
        UserService userService = new UserServiceImpl();

        userService.createUsersTable();

        userService.saveUser("Ivan", "Ivanov", (byte) 16);
        userService.saveUser("Petr", "Petrov", (byte) 24);
        userService.saveUser("Jim", "Kerry", (byte) 45);
        userService.saveUser("Jack", "Daniels", (byte) 18);

        userService.getAllUsers();

        userService.dropUsersTable();





        }
}
