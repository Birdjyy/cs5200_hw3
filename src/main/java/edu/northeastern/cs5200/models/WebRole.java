package edu.northeastern.cs5200.models;

public class WebRole {
    private int web_role_id;
    private int developer_fk;
    private int website_fk;
    private int role_fk;

    public int getWeb_role_id() {
        return web_role_id;
    }

    public void setWeb_role_id(int web_role_id) {
        this.web_role_id = web_role_id;
    }

    public int getDeveloper_fk() {
        return developer_fk;
    }

    public void setDeveloper_fk(int developer_fk) {
        this.developer_fk = developer_fk;
    }

    public int getWebsite_fk() {
        return website_fk;
    }

    public void setWebsite_fk(int website_fk) {
        this.website_fk = website_fk;
    }

    public int getRole_fk() {
        return role_fk;
    }

    public void setRole_fk(int role_fk) {
        this.role_fk = role_fk;
    }

    public WebRole(int developer_fk, int website_fk, int role_fk) {
        this.developer_fk = developer_fk;
        this.website_fk = website_fk;
        this.role_fk = role_fk;
    }

    public WebRole() {}
}
