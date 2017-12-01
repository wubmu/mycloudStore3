package com.wyb.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

/**
 * Created by 吴亚斌 on 2017/11/28.
 */
public class LogoutAction extends ActionSupport {
    @Override
    public String execute() throws Exception {
        ActionContext.getContext().getSession().clear();
        return SUCCESS;
    }
}
