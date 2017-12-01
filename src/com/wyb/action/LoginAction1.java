package com.wyb.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.wyb.bean.User;
import com.wyb.dao.Impl.UserDaoImpl;

/**
 * Created by 吴亚斌 on 2017/11/21.
 */
public class LoginAction1 extends ActionSupport implements ModelDriven<User> {
    User user= new User();
    @Override
    public User getModel() {
        return user;
    }

    @Override
    public String execute() throws Exception {
        UserDaoImpl u = new UserDaoImpl();
        User user1 = u.get(User.class,user.getUsername());
        if (user1==null)
            return LOGIN;
         else if (user1.getPassword().equals(user.getPassword())) {
            ActionContext.getContext().getSession().put("user", user1);
            return SUCCESS;
        }
        return LOGIN;

    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
