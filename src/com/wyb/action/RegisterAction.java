package com.wyb.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.wyb.bean.Dir;
import com.wyb.bean.User;
import com.wyb.dao.Impl.UserDaoImpl;
import com.wyb.service.DocumenService;

/**
 * Created by 吴亚斌 on 2017/11/25.
 */
public class RegisterAction extends ActionSupport implements ModelDriven<User> {
    User user = new User();
    UserDaoImpl userDao = new UserDaoImpl();

    @Override
    public String execute() throws Exception {
        if (userDao.findByUsername(user)==null) {
            user.setRootFile("f:/realPath/" + user.getUsername());
            userDao.save(user);
            ActionContext.getContext().getSession().put("user",user);
            DocumenService service = new DocumenService();
            Dir  dir = new Dir();
            dir.setName(user.getUsername()  );
            dir.setPath(user.getRootFile());
            service.CreateDir(dir);
            return SUCCESS;
        }
        else
            return LOGIN;
    }

    @Override
    public User getModel() {
        return user;
    }
}
