package com.dbexercise.dao;


import com.dbexercise.domain.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public abstract class UserDaoAbstract {
    //makeConnection() 메소드의 구현체를 없앤다
    public abstract Connection makeConnection() throws SQLException;

    public void add(User user) throws SQLException {
        Connection conn = makeConnection();

        PreparedStatement ps = conn.prepareStatement("INSERT INTO Users(id, name, password) VALUES(?, ?, ?)");
        ps.setString(1, user.getId());
        ps.setString(2, user.getName());
        ps.setString(3, user.getPassword());

        //ctrl+enter
        ps.executeUpdate();
        ps.close();
        conn.close();
    }

    public User findById(String id) throws SQLException {
        Connection conn = makeConnection();
        //쿼리를 작성하는 코드
        PreparedStatement ps = conn.prepareStatement("SELECT id, name, password FROM Users WHERE id=?");
        ps.setString(1, id);

        ResultSet rs = ps.executeQuery();
        rs.next();
        User user = new User(rs.getString("id"), rs.getString("name"), rs.getString("password"));

        System.out.println("SELECT 완료");
        rs.close();
        ps.close();
        conn.close();

        return user;
    }
    public List<User> findAll() throws SQLException {
        Connection conn = makeConnection();
        //쿼리를 작성하는 코드
        PreparedStatement ps = conn.prepareStatement("SELECT * FROM Users");
        ResultSet rs = ps.executeQuery();
        List<User> userList = new ArrayList<>();
        while(rs.next()){
            User user = new User(rs.getString("id"), rs.getString("name"), rs.getString("password"));
            userList.add(user);
        }
        System.out.println("SELECT 완료");
        rs.close();
        ps.close();
        conn.close();

        return userList;
    }


}
