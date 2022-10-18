package com.dbexercise.dao;

import com.dbexercise.domain.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;

class UserDaoTest {
    @Test
    void addAndSelect () throws SQLException, ClassNotFoundException {
        AWSUserDaoImpl userDao = new AWSUserDaoImpl();
        String id = "7";
        User user = new User(id, "jo", "coconut");
        userDao.add(user);

        User user1 = userDao.findById(id);
        Assertions.assertEquals("jo", user1.getName());
    }

//        List<User> userList = userDao.findAll();
//        for (User user : userList) {
//            System.out.println(user.getName());
//         }
    @Test
    void deleteTest () throws SQLException {
        AWSUserDaoImpl userDao = new AWSUserDaoImpl();
        String id = "6";
        userDao.deleteById(id);

        User user1 = userDao.findById(id);
        Assertions.assertNull(user1);
    }
}