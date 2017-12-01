package com.wyb.dao.Impl;

import com.wyb.bean.Dir;
import org.junit.Test;

import java.io.File;
import java.io.IOException;

import static org.junit.Assert.*;

/**
 * Created by 吴亚斌 on 2017/11/21.
 */
public class DocumentDaoImplTest {
    @Test
    public void getByParentPath() throws Exception {
        DocumentDaoImpl documentDao = new DocumentDaoImpl();
        java.util.List<Dir> list= documentDao.getByParentPath("");
        for (Dir d : list)
            System.out.println(d.getParentPath());
    }
    @Test
    public void  test() throws IOException {
        String s = "f:/realPath/123/82b209c9-ac8a-48f7-a6bd-3f1a2152c89d_中北大学邮箱测试报告.docx";
        String ss = s.replace("/","\\");
            System.out.println(s);
        File file = new File(s);
        System.out.println(file.exists());
        System.out.println(file.delete());


    }
    @Test
    public void testDeleteDir(){
        String path="f:/realPath/123/图片";
        FileDaoImpl dao = new FileDaoImpl();
        dao.deleteFile(path);
        dao.deleteDir(path);
    }
}