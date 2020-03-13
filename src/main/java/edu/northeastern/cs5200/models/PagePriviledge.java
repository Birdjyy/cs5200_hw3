package edu.northeastern.cs5200.models;

public class PagePriviledge {
    private int page_priviledge_id;
    private int developer_fk;
    private int page_fk;
    private int priviledge_fk;

    public int getPage_priviledge_id() {
        return page_priviledge_id;
    }

    public void setPage_priviledge_id(int page_priviledge_id) {
        this.page_priviledge_id = page_priviledge_id;
    }

    public int getDeveloper_fk() {
        return developer_fk;
    }

    public void setDeveloper_fk(int developer_fk) {
        this.developer_fk = developer_fk;
    }

    public int getPage_fk() {
        return page_fk;
    }

    public void setPage_fk(int page_fk) {
        this.page_fk = page_fk;
    }

    public int getPriviledge_fk() {
        return priviledge_fk;
    }

    public void setPriviledge_fk(int priviledge_fk) {
        this.priviledge_fk = priviledge_fk;
    }

    public PagePriviledge(int page_priviledge_id, int developer_fk, int page_fk, int priviledge_fk) {
        this.page_priviledge_id = page_priviledge_id;
        this.developer_fk = developer_fk;
        this.page_fk = page_fk;
        this.priviledge_fk = priviledge_fk;
    }

    public PagePriviledge() {}
}
