package com.wyb.bean;

import javax.persistence.*;

/**
 * Created by 吴亚斌 on 2017/11/18.
 */
@Entity
@Table(name = "FileMessage")
public class FileMessage{
    @Id
    @Column( name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "contentType")
    private String contentType;
    @Column(name = "fileName")
    private String fileName;
    @Column(name = "ico")
    private String ico;

    @Column(name = "filePath")
    private String filePath;
    @Column(name = "parentPath")
    private String parentPath;
    @Column(name = "pid")
    private int pid;

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getParentPath() {
        return parentPath;
    }

    public void setParentPath(String parentPath) {
        this.parentPath = parentPath;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public String getIco() {
        return ico;
    }

    public void setIco(String ico) {
        this.ico = ico;
    }


    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public String toString() {
        return "FileMessage{" +
                "contentType='" + contentType + '\'' +
                ", fileName='" + fileName + '\'' +
                ", ico='" + ico + '\'' +
                ", filePath='" + filePath + '\'' +
                ", parentPath='" + parentPath + '\'' +
                '}';
    }
}
