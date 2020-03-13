package edu.northeastern.cs5200.models;

public class PageRole {
    private int page_role_id;
    private int developer_fk;
    private int page_fk;
    private int role_fk;

    public int getPage_role_id() {
        return page_role_id;
    }

    public void setPage_role_id(int page_role_id) {
        this.page_role_id = page_role_id;
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

    public int getRole_fk() {
        return role_fk;
    }

    public void setRole_fk(int role_fk) {
        this.role_fk = role_fk;
    }

    public PageRole(int developer_fk, int page_fk, int role_fk) {
        this.developer_fk = developer_fk;
        this.page_fk = page_fk;
        this.role_fk = role_fk;
    }

    public PageRole() {}
}
