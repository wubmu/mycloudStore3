package com.wyb.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.wyb.bean.Dir;
import com.wyb.service.DocumenService;
import com.wyb.dao.Impl.DocumentDaoImpl;

/**
 * Created by 吴亚斌 on 2017/11/20.
 */
public class CreateDocumentAction extends ActionSupport implements ModelDriven<Dir> {
    public Dir dir = new Dir();

    @Override
    public String execute() throws Exception {
        DocumenService service= new DocumenService();
        DocumentDaoImpl dao = new DocumentDaoImpl();
        String filePath = (String) ActionContext.getContext().getSession().get("filePath");
        String newfilePath = filePath+"/"+dir.getName();
        dir.setPath(newfilePath);
        dir.setParentPath(filePath);
        service.CreateDir(dir);
        return super.execute();
    }

    @Override
    public Dir getModel() {
        return dir;
    }
}
