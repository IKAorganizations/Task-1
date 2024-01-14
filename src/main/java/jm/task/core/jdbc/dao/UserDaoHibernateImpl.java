package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static jm.task.core.jdbc.util.Util.*;

public class UserDaoHibernateImpl implements UserDao {
    public UserDaoHibernateImpl() {

    }


    @Override
    public void createUsersTable() {
        try {
            Session session = getSession().openSession();
            session.beginTransaction();

            Query query = session.createSQLQuery(CREATE_TABLE).addEntity(User.class);

            query.executeUpdate();
            session.getTransaction().commit();

        } finally {
            getSession().close();
        }

    }

    @Override
    public void dropUsersTable() {
        Session session = getSession().openSession();
        session.beginTransaction();

        Query query = session.createSQLQuery(DROP_TABLE).addEntity(User.class);

        query.executeUpdate();
        session.getTransaction().commit();

    }

    @Override
    public void saveUser(String name, String lastName, byte age) {
    try{
        Session session = getSession().openSession();
        session.beginTransaction();

        User user = new User(name, lastName, age);
        session.save(user);

        session.getTransaction().commit();

        } finally {
        getSession().close();

    }

    }

    @Override
    public void removeUserById(long id) {
        try{
            Session session = getSession().openSession();
            session.beginTransaction();

            session.delete(session.get(User.class, id));

            session.getTransaction().commit();

        } finally {
            getSession().close();
        }

    }

    @Override
    public List<User> getAllUsers() {
        try(Session session = getSession().openSession()){
            Query<User> query = session.createQuery("from User", User.class);

            query.stream().forEach(e-> System.out.println(e));
            return query.list();
        }

    }

    @Override
    public void cleanUsersTable() {
        try(Session session = getSession().openSession()){
            Transaction transaction = session.beginTransaction();
            session.createQuery("delete from User").executeUpdate();

            transaction.commit();
        }

    }
}
