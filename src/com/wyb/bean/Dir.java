package com.wyb.bean;

import javax.persistence.*;

/**
 * Created by 吴亚斌 on 2017/11/21.
 */
@Entity
@Table(name = "dir")
public class Dir {
    @Id
    @Column( name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "name")
    private String name;

    @Column(name ="path")
    private String path;
    @Column(name = "parentPath")
    private String  parentPath;
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
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

    @Override
    public String toString() {
        return "Dir{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", path='" + path + '\'' +
                ", parentPath='" + parentPath + '\'' +
                '}';
    }
}
