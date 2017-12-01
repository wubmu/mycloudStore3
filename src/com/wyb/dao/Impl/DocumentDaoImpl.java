package com.wyb.dao.Impl;

import com.wyb.bean.Dir;
import com.wyb.dao.DocumentDao;
import org.hibernate.Transaction;

import javax.persistence.Query;
import java.util.List;

/**
 * Created by 吴亚斌 on 2017/11/21.
 */
public class DocumentDaoImpl extends BaseDaoImpl<Dir> implements DocumentDao {
        public List<Dir> getByParentPath(String parentPath){
        Transaction tx = session.beginTransaction();
        Query query = session.createQuery("from Dir where parentPath = ?");
        query.setParameter(0,parentPath);
        List<Dir> dirList = query.getResultList();
        tx.commit();
        return dirList;
    }
        public String getPath(int id){
              Dir dir= session.get(Dir.class,id);
               return dir.getPath();

        }
    public Dir getDirByPath(String path){
        Query query = session.createQuery("from Dir where path = ?");
        query.setParameter(0,path);
        Dir dir = (Dir) query.getSingleResult();
        return dir;

    }
}
