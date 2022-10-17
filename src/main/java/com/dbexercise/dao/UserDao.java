package com.dbexercise.dao;


import com.dbexercise.domain.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class UserDao {
    public void add() throws ClassNotFoundException, SQLException {
        //environment variable에서 정보를 가져온다
        //소스코드에 직접적인 정보를 안 넣을 수 있다.
        Map<String, String> env = System.getenv();
        String dbHost = env.get("DB_HOST");
        String dbUser = env.get("DB_USER");
        String dbPassword = env.get("DB_PASSWORD");

        Class.forName("com.mysql.cj.jdbc.Driver");

        //db와 연결하는 단계
        Connection conn = DriverManager.getConnection(dbHost, dbUser, dbPassword); //db연결
        PreparedStatement ps = conn.prepareStatement("INSERT INTO Users(id, name, password) VALUES(?, ?, ?)");
        ps.setString(1, "2");
        ps.setString(2, "Hwang");
        ps.setString(3, "0111");


        //ctrl+enter
        ps.executeUpdate();
        ps.close();
        conn.close();
    }

    public User get(String id) throws ClassNotFoundException, SQLException {
        //environment variable에서 정보를 가져온다
        //소스코드에 직접적인 정보를 안 넣을 수 있다.
        Map<String, String> env = System.getenv();
        String dbHost = env.get("DB_HOST");
        String dbUser = env.get("DB_USER");
        String dbPassword = env.get("DB_PASSWORD");

        Class.forName("com.mysql.cj.jdbc.Driver");

        //db와 연결하는 단계
        Connection conn = DriverManager.getConnection(dbHost, dbUser, dbPassword); //db연결
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
    public List<User> findAll() throws ClassNotFoundException, SQLException {
        //environment variable에서 정보를 가져온다
        //소스코드에 직접적인 정보를 안 넣을 수 있다.
        Map<String, String> env = System.getenv();
        String dbHost = env.get("DB_HOST");
        String dbUser = env.get("DB_USER");
        String dbPassword = env.get("DB_PASSWORD");

        Class.forName("com.mysql.cj.jdbc.Driver");

        //db와 연결하는 단계
        Connection conn = DriverManager.getConnection(dbHost, dbUser, dbPassword); //db연결
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

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
       UserDao userDao = new UserDao();
       //get method 확인
       // User user1 = userDao.get("2");
        // System.out.println(user1.getName());

        List<User> userList = userDao.findAll();
        for (User user : userList) {
            System.out.println(user.getName());
         }


    }

}
