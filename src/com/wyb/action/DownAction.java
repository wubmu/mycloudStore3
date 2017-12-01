package com.wyb.action;

import com.opensymphony.xwork2.ActionSupport;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

/**
 * Created by 吴亚斌 on 2017/11/22.
 */
public class DownAction extends ActionSupport {
    private String fileName;
    private String path;
    private String contentType;

    @Override
    public String execute() throws Exception {
        return SUCCESS;
    }

    public InputStream getTargetFile() throws FileNotFoundException {
        System.out.println(toString());
        InputStream in = new FileInputStream(path);
        return in;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
            this.fileName = fileName;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    @Override
    public String toString() {
        return "DownAction{" +
                "fileName='" + fileName + '\'' +
                ", path='" + path + '\'' +
                ", contentType='" + contentType + '\'' +
                '}';
    }
}
