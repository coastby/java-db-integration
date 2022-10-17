package com.dbexercise;


import java.sql.*;
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

    public void select() throws ClassNotFoundException, SQLException {
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
        PreparedStatement ps = conn.prepareStatement("SELECT name FROM Users WHERE id=?");
        ps.setString(1, "1");
        ResultSet rs = ps.executeQuery();

        while(rs.next()) {
            String name = rs.getString("name");
            System.out.println(name);
        }
        System.out.println("SELECT 완료");
        ps.close();
        conn.close();
    }

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
       UserDao userDao = new UserDao();
       userDao.select();
    }

}
