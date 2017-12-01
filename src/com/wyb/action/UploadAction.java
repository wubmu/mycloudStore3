package com.wyb.action;

import com.opensymphony.xwork2.ActionSupport;
import com.wyb.bean.Dir;
import com.wyb.bean.FileMessage;
import com.wyb.dao.Impl.UserDaoImpl;
import com.wyb.util.Main;
import com.wyb.service.DocumenService;
import org.hibernate.Session;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Arrays;
import java.util.UUID;

/**
 * Created by 吴亚斌 on 2017/11/17.
 */
public class UploadAction extends ActionSupport {
    private File[] upload;
    private String[] uploadContentType;
    private String[] uploadFileName;
    private String savePath;
//    private String parentPath;
    @Override
    public String execute() throws Exception {

        for (int i = 0; i < upload.length; i++) {
            UserDaoImpl userdao = new UserDaoImpl();
            Session session = Main.getSession();
            String newFileName = UUID.randomUUID() + "_" + uploadFileName[i];
            FileInputStream fis = new FileInputStream(upload[i]);
            FileOutputStream fos = new FileOutputStream(savePath + "/" + newFileName);
            byte[] b = new byte[1024];
            int len = 0;
            FileMessage message = new FileMessage();
            message.setContentType(uploadContentType[i]);
            message.setFileName(uploadFileName[i]);
            message.setParentPath(savePath);
            Dir dir= new DocumenService().getDirByPath(savePath);
            message.setPid(dir.getId());
            message.setFilePath(savePath+"/"+newFileName);
            System.out.println(message.toString());
            session.save(message);
            while ((len = fis.read(b)) > 0) {
                fos.write(b, 0, b.length);
            }
            session.beginTransaction().commit();
        }
        System.out.println(this.toString());
        return "uploadOK";
    }

    public File[] getUpload() {
        return upload;
    }

    public void setUpload(File[] upload) {
        this.upload = upload;
    }

    public String[] getUploadContentType() {
        return uploadContentType;
    }

    public void setUploadContentType(String[] uploadContentType) {
        this.uploadContentType = uploadContentType;
    }

    public String[] getUploadFileName() {
        return uploadFileName;
    }

    public void setUploadFileName(String[] uploadFileName) {
        this.uploadFileName = uploadFileName;
    }

    public String getSavePath() {
        return savePath;
    }

    public void setSavePath(String savePath) {
        this.savePath = savePath;
    }

    @Override
    public String toString() {
        return "UploadAction{" +
                "upload=" + Arrays.toString(upload) +
                ", uploadContentType=" + Arrays.toString(uploadContentType) +
                ", uploadFileName=" + Arrays.toString(uploadFileName) +
                ", savePath='" + savePath + '\'' +
                '}';
    }
}

