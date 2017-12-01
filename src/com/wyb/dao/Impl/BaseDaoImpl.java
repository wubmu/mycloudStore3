package com.wyb.dao.Impl;

import com.wyb.dao.BaseDao;
import com.wyb.util.Main;
import org.hibernate.Session;

import java.io.Serializable;
import java.util.List;

/**
 * Created by 吴亚斌 on 2017/11/18.
 */
public class BaseDaoImpl<T> implements BaseDao<T> {
    Session session = Main.getSession();
    @Override
    public T get( Class<T> tClass, Serializable id) {
        return (T) session.get(tClass,id);
    }

    @Override
    public Serializable save( T entity) throws Exception {

        session.save(entity);
        session.beginTransaction().commit();
      return null;
    }

    @Override
    public void delete( Class<T> tClass, Serializable id) {
            session.delete(get(tClass,id));
            session.beginTransaction().commit();
    }

    @Override
    public List<T> findAll( Class<T> tClass) {
        return (List<T>) session.createQuery("from " +tClass.getSimpleName()).list();
    }


}
