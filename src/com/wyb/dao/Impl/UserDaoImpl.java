package com.wyb.dao.Impl;

import com.wyb.bean.User;
import com.wyb.dao.UserDao1;
import org.hibernate.Transaction;

import javax.persistence.Query;
import java.util.List;

/**
 * Created by 吴亚斌 on 2017/11/18.
 */
public class UserDaoImpl extends BaseDaoImpl<User> implements UserDao1 {
    public User findByUsername(User user){
//        Transaction tx = session.beginTransaction();
        Query query = session.createQuery("from User where username = ?");
        query.setParameter(0,user.getUsername());
        List<User> list =query.getResultList();
        if (list.size()==0)
            return null;
        return list.get(0);
    }

}
