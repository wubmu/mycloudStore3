package com.wyb.dao.Impl;

import com.wyb.bean.User;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by 吴亚斌 on 2017/11/25.
 */
public class UserDaoImplTest {
    UserDaoImpl userDao = new UserDaoImpl();
    @Test
    public void findByUsername() throws Exception {
        User u=new User();
        u.setUsername("123");
        System.out.println(userDao.findByUsername(u));
    }

}