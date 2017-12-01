package com.wyb.dao;

import com.wyb.bean.User;

/**
 * Created by 吴亚斌 on 2017/11/18.
 */
public interface UserDao1 extends BaseDao<User> {
    public User findByUsername(User user);
}
