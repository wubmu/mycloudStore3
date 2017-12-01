package com.wyb.service;

import com.wyb.bean.Dir;
import com.wyb.bean.FileMessage;
import com.wyb.dao.DocumentDao;
import com.wyb.dao.Impl.FileDaoImpl;
import com.wyb.service.DocumenService;
import org.junit.Test;

import java.util.List;

/**
 * Created by 吴亚斌 on 2017/11/21.
 */
public class DocumenServiceTest {
    DocumenService service = new DocumenService();

    @Test
    public void deleteDir() throws Exception {

    }

    @Test
    public void showNextDir() throws Exception {
//       List<Dir> dirList=  service.showNextDir("f:\\realPath\\123");

    }

    @Test
    public void createDir() throws Exception {
       Dir dir= new Dir();
//       dir.setId(1);

       dir.setPath("f:/realPath/123");
       DocumenService service = new DocumenService();
       service.CreateDir(dir);

    }
    @Test
    public void getNameBypath(){
        DocumenService service = new DocumenService();
        System.out.println(service.getDirByPath("f:/realPath/123").toString());
    }
    @Test
    public void testD(){
        String s= "f:/realPath/123";
        String o = "f:/realPath/123";
        System.out.println(s.equals(o));
    }
    @Test
    public void  testSelectByType(){
        FileDaoImpl dao = new FileDaoImpl();
        String contentType = "image/";
        List<FileMessage> list = dao.selectByType(contentType);
        for (FileMessage f : list){
            System.out.println(f.toString());
        }
        for (int i = 0 ; i < list.size();i++){
            FileMessage f = list.get(i);
            String[] ss = f.getFilePath().split("/");
            System.out.println(ss[2]);
            if (!ss[2].equals("123"))
                list.remove(i);
        }
        for (FileMessage f : list){
            System.out.println(f.toString());
        }
    }
}