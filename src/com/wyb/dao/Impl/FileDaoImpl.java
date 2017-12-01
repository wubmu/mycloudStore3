package com.wyb.dao.Impl;

import com.wyb.bean.FileMessage;
import com.wyb.dao.FileDao;
import com.wyb.util.Main;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.Query;
import java.util.List;

/**
 * Created by 吴亚斌 on 2017/11/19.
 */
public class FileDaoImpl extends BaseDaoImpl<FileMessage> implements FileDao {
    Session session = Main.getSession();
    public void deleteFile(String f){

        Transaction tx = session.beginTransaction();
        Query query = session.createQuery("delete from FileMessage where filePath = ?");
        query.setParameter(0,f);
        Query query1 = session.createQuery("delete from Dir where path = ?");
        query1.setParameter(0,f);
        query.executeUpdate();
        query1.executeUpdate();
        session.getTransaction().commit();
    }
    public List<FileMessage> selectByParent(String parent){
        Transaction tx = session.beginTransaction();
        Query query = session.createQuery("from FileMessage where parentPath = ?");
        query.setParameter(0,parent);
        List<FileMessage> list = query.getResultList();
        session.getTransaction().commit();
        return list;
    }


    public void deleteDir(String Parentpath){
        Transaction tx = session.beginTransaction();
        Query query = session.createQuery("delete Dir where path = ?");
        query.setParameter(0,Parentpath);
        query.executeUpdate();
        tx.commit();
    }

    public List<FileMessage> selectByType(String contentType){
        Transaction tx= session.getTransaction();
        Query query = session.createQuery("from FileMessage where contentType = ?");
        query.setParameter(0,contentType);
        List<FileMessage> f = query.getResultList();
        return f;
    }
    public List<FileMessage> selectByName(String name){
        Transaction tx = session.beginTransaction();
        Query query = session.createQuery("from FileMessage where fileName = ?");
        query.setParameter(0,name);
        List<FileMessage> list = query.getResultList();
        session.getTransaction().commit();
        return list;
    }
}
