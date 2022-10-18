package com.dbexercise.dao;

import com.dbexercise.domain.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;

class UserDaoTest {
    @Test
    void addAndSelect () throws SQLException, ClassNotFoundException {
        AWSUserDaoImpl userDao = new AWSUserDaoImpl();
        User user = new User("6", "jo", "coconut");
        userDao.add(user);

        User user1 = userDao.findById("4");
        Assertions.assertEquals("jo", user1.getName());
    }

//        List<User> userList = userDao.findAll();
//        for (User user : userList) {
//            System.out.println(user.getName());
//         }

}