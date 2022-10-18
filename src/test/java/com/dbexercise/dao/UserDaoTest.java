package com.dbexercise.dao;

import com.dbexercise.domain.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;

class UserDaoTest {
    @Test
    void addAndSelect () throws SQLException, ClassNotFoundException {
        UserDao userDao = new UserDao(new AwsConnectionMaker());
        String id = "8";
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
        UserDao userDao = new UserDao(new AwsConnectionMaker());
        String id = "8";
        userDao.deleteById(id);

        User user1 = userDao.findById(id);
        Assertions.assertNull(user1);
    }
}