package com.wyb.action;

import com.opensymphony.xwork2.ActionSupport;
import com.wyb.dao.Impl.FileDaoImpl;

import java.io.File;

/**
 * Created by 吴亚斌 on 2017/11/20.
 */
public class DeleteFileAction extends ActionSupport {
    private String[] selectAll;
    FileDaoImpl dao = new FileDaoImpl();

    public String execute() throws Exception {
        System.out.println(selectAll.length+selectAll[0]);
        for (int i =0;i<selectAll.length;i++){

            File file = new File(selectAll[i]);
            dao.deleteFile(selectAll[i]);
            System.out.println(selectAll[i]);
            if (file.isFile() && file.exists()) {// 路径为文件且不为空则进行删除
                System.out.println(file);
                System.out.println(selectAll[i]);
                file.delete();// 文件删除

            }

        }
        return SUCCESS;
    }

    public String[] getSelectAll() {
        return selectAll;
    }

    public void setSelectAll(String[] selectAll) {
        this.selectAll = selectAll;
    }
}
