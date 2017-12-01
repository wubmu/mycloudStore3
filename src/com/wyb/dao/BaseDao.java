package com.wyb.dao;

import org.hibernate.Session;

import java.io.Serializable;
import java.util.List;

/**
 * Created by 吴亚斌 on 2017/11/18.
 */
public interface BaseDao<T> {
    T get( Class<T> tClass, Serializable id);

    Serializable save( T entity) throws Exception;

    void delete( Class<T> tClass, Serializable id);
    List<T> findAll( Class<T> tClass);

}
