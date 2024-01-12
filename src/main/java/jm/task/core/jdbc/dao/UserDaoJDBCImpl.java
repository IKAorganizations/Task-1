package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import org.hibernate.boot.model.source.spi.SingularAttributeSourceToOne;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.SortedMap;

import static jm.task.core.jdbc.util.Util.*;
import static jm.task.core.jdbc.util.Util.CREATE_TABLE;

public class UserDaoJDBCImpl implements UserDao {

    public UserDaoJDBCImpl() {

    }

    public void createUsersTable() {
        try (Statement stmnt = getConn().createStatement()){
            stmnt.executeUpdate(CREATE_TABLE);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void dropUsersTable() {
        try (Statement stmnt = getConn().createStatement()){
            stmnt.executeUpdate(DROP_TABLE);

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void saveUser(String name, String lastName, byte age) {
        try (PreparedStatement pstmt = getConn().prepareStatement(INSERT_INTO)){
            pstmt.setString(1, name);
            pstmt.setString(2, lastName);
            pstmt.setByte(3, age);

            pstmt.executeUpdate();
            System.out.println("User с именем - " + name + " добавлен в базу данных");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void removeUserById(long id) {
        try (PreparedStatement pstmt = getConn().prepareStatement(DELETE_FROM)){
            pstmt.setLong(1, id);
            pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public List<User> getAllUsers() {
        List <User> list = new ArrayList<>();

        try (ResultSet rs = getConn().createStatement().executeQuery("SELECT * FROM users")){

            while(rs.next()){
                String name = rs.getString(2);
                String lastName = rs.getString(3);
                byte age = rs.getByte(4);

                User user = new User(name, lastName, age);
                list.add(user);
            }

            for(User user : list){
                System.out.println(user);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }

    public void cleanUsersTable() {
        try (Statement stmnt = getConn().createStatement()){
            stmnt.executeUpdate(CLEAN);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
