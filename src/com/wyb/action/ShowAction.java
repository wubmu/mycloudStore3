package com.wyb.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.wyb.bean.Dir;
import com.wyb.bean.FileMessage;
import com.wyb.bean.User;
import com.wyb.service.DocumenService;
import com.wyb.dao.Impl.FileDaoImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by 吴亚斌 on 2017/11/18.
 */
public class ShowAction extends ActionSupport {
    private String filePath;
    Map<String, Object> session = ActionContext.getContext().getSession();
    User user = ((User) session.get("user"));
    DocumenService service = new DocumenService();
    @Override
    public String execute() throws Exception {

        if (filePath == null)
            filePath = user.getRootFile();
        System.out.println(filePath);

        List<Dir> dirList = service.showNextDir(filePath);
        List<FileMessage> list = new FileDaoImpl().selectByParent(filePath);
        for (FileMessage f : list) {
            System.out.println(f.toString());
        }
        for (Dir d : dirList)
            System.out.println(d.toString());

        session.put("dirList", dirList);
        session.put("fileList", list);
        session.put("filePath", filePath);
        session.put("bar",getBar());
        return SUCCESS;
    }

    public List<Dir> getBar() {
       List<Dir> oldBar = new ArrayList<Dir>();
       List<Dir> newBar =new ArrayList<Dir>();
//       newBar.add(service.getDirByPath(user.getRootFile()));
       oldBar.add(service.getDirByPath(user.getRootFile()));
        if (session.get("bar")!=null) {
            oldBar = (List<Dir>) session.get("bar");
            for (int i = 0 ; i<oldBar.size();i++){

                if (oldBar.get(i).getPath().equals(filePath)){
                    newBar.add(service.getDirByPath(filePath));
                    return newBar;
                }

                newBar.add(oldBar.get(i));
             }

            newBar.add(service.getDirByPath(filePath));
            return newBar;
        }
        return oldBar;

    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }
}
