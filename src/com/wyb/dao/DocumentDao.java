package com.wyb.dao;

import com.wyb.bean.Dir;

import java.util.List;

/**
 * Created by 吴亚斌 on 2017/11/21.
 */
public interface DocumentDao extends BaseDao<Dir> {
    public String getPath(int id);
    public List<Dir> getByParentPath(String parentPath);
    public Dir getDirByPath(String path);
}
