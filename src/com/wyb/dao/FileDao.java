package com.wyb.dao;

import com.wyb.bean.FileMessage;

import java.util.List;


/**
 * Created by 吴亚斌 on 2017/11/19.
 */
public interface FileDao extends BaseDao<FileMessage> {
    public void deleteFile(String f);
    public List<FileMessage> selectByParent(String parent);
    public void deleteDir(String Parentpath);
    public List<FileMessage> selectByType(String contentType);

}
