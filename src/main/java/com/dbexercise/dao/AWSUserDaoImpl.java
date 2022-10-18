package com.dbexercise.dao;

import com.dbexercise.domain.User;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public class AWSUserDaoImpl extends UserDaoAbstract{
    @Override
    public Connection makeConnection() throws SQLException {
        Map<String, String> env = System.getenv();
        String dbHost = env.get("DB_HOST");
        String dbUser = env.get("DB_USER");
        String dbPassword = env.get("DB_PASSWORD");

        //db와 연결하는 단계
        Connection conn = DriverManager.getConnection(dbHost, dbUser, dbPassword); //db연결
        return conn;
    }
}
