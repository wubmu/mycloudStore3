package com.wyb.action;

import com.opensymphony.xwork2.ActionSupport;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/**
 * Created by 吴亚斌 on 2017/11/4.
 */
public class DownloadAction extends ActionSupport {
    private String fileName;
    private String filePath;
    private String ContentType;

    @Override
    public String execute() throws Exception {
        System.out.println(toString());
        return SUCCESS;
    }

    @Override
    public String toString() {
        return "DownloadAction{" +
                "fileName='" + fileName + '\'' +
                ", path='" + filePath + '\'' +
                '}';
    }

    public InputStream getTargetFile() throws FileNotFoundException {
        System.out.println(this.toString());

        InputStream in = new FileInputStream(filePath);
        return in;
    }

    public String getFileName() throws UnsupportedEncodingException {
        return new String(fileName.getBytes(),"utf-8");
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public String getContentType() {
        return ContentType;
    }

    public void setContentType(String contentType) {
        ContentType = contentType;
    }
}
