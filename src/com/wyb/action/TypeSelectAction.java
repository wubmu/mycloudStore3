package com.wyb.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.wyb.bean.FileMessage;
import com.wyb.bean.User;
import com.wyb.dao.Impl.FileDaoImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by 吴亚斌 on 2017/11/25.
 */
public class TypeSelectAction extends ActionSupport {
    private String contentType;
    Map<String,Object> session=ActionContext.getContext().getSession();

    @Override
    public String execute() throws Exception {
        FileDaoImpl dao = new FileDaoImpl();
        User u = (User) session.get("user");
        List<FileMessage>  list = dao.selectByType(contentType);
        for (int i = 0 ; i < list.size();i++){
            FileMessage f = list.get(i);
            String[] ss = f.getFilePath().split("/");
            if (!ss[2].equals(u.getUsername()))
                list.remove(i);
        }
        session.remove("dirList");
        session.remove("fileList");
        session.put("fileList",list);
        return SUCCESS;
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }
}
