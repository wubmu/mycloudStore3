package com.wyb.dao.Impl;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by 吴亚斌 on 2017/11/27.
 */
public class FileDaoImplTest {
    @Test
    public void deleteDir() throws Exception {
        FileDaoImpl dao = new FileDaoImpl();
        dao.deleteDir("f:/realPath/123/e392bb75-bf9c-442e-b1ae-64cb867afd19_云盘数据库说明.xlsx");
    }

}