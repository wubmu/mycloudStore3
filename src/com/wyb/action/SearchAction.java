package com.wyb.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.wyb.bean.FileMessage;
import com.wyb.dao.Impl.FileDaoImpl;

import java.util.List;

/**
 * Created by 吴亚斌 on 2017/11/28.
 */
public class SearchAction extends ActionSupport {
    private String search;

    @Override
    public String execute() throws Exception {
        FileDaoImpl dao = new FileDaoImpl();
        List<FileMessage> list=dao.selectByName(search);
        ActionContext.getContext().getSession().remove("dirList");
        ActionContext.getContext().getSession().put("fileList",list);
        return SUCCESS;
    }
}
