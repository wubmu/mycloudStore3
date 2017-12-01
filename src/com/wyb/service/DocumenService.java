package com.wyb.service;

import com.wyb.bean.Dir;
import com.wyb.dao.Impl.DocumentDaoImpl;

import java.io.File;
import java.util.List;

/**
 * Created by 吴亚斌 on 2017/11/21.
 */
public class DocumenService {
    DocumentDaoImpl dao = new DocumentDaoImpl();
    public void CreateDir(Dir dir) throws Exception {
        File file = new File(dir.getPath());
        file.mkdir();
        dao.save(dir);
    }
    public void deleteDir(String path){
        File file = new File(path);
        file.delete();
    }
    public List<Dir> showNextDir(String parentPath){


        return dao.getByParentPath(parentPath);
    }
    public Dir getDirByPath(String path){
       return dao.getDirByPath(path);

    }
}
