package com.wyb.action;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.wyb.bean.User;
import com.wyb.dao.Impl.UserDaoImpl;

/**
 * Created by 吴亚斌 on 2017/11/20.
 */
public class UserAction extends ActionSupport implements ModelDriven<User> {
    private User user;
    UserDaoImpl dao = new UserDaoImpl();
    public String addUser() throws Exception {
            String rootPath = "F:/realPath/"+user.getUsername();
//            user.setRootFile(rootPath);
            dao.save(user);
            return SUCCESS;
    }
    public String login(){
        User u = dao.get(User.class,user.getUsername());

        if (user.getPassword().equals(u.getPassword()))
        return SUCCESS;
        else
            return LOGIN;
    }
    public String upload(){

        return "upload";
    }
    @Override
    public User getModel() {
        return user;
    }
}
