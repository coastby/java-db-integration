package com.dbexercise.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class LocalDeprecatedUserDaoImpl extends UserDaoAbstract_deprecated {
    @Override
    public Connection makeConnection() throws SQLException {
        //local db와 연결하는 단계
        Connection conn = DriverManager.getConnection("jdbc://mysql://localhost:3306/likelion-db", "root", "12345678");
        return conn;
    }
}
