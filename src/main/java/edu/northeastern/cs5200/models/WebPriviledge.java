package edu.northeastern.cs5200.models;

public class WebPriviledge {
    private int web_priviledge_id;
    private int developer_fk;
    private int waebsite_fk;
    private int priviledge_fk;

    public int getWeb_priviledge_id() {
        return web_priviledge_id;
    }

    public void setWeb_priviledge_id(int web_priviledge_id) {
        this.web_priviledge_id = web_priviledge_id;
    }

    public int getDeveloper_fk() {
        return developer_fk;
    }

    public void setDeveloper_fk(int developer_fk) {
        this.developer_fk = developer_fk;
    }

    public int getWaebsite_fk() {
        return waebsite_fk;
    }

    public void setWaebsite_fk(int waebsite_fk) {
        this.waebsite_fk = waebsite_fk;
    }

    public int getPriviledge_fk() {
        return priviledge_fk;
    }

    public void setPriviledge_fk(int priviledge_fk) {
        this.priviledge_fk = priviledge_fk;
    }

    public WebPriviledge(int web_priviledge_id, int developer_fk, int waebsite_fk, int priviledge_fk) {
        this.web_priviledge_id = web_priviledge_id;
        this.developer_fk = developer_fk;
        this.waebsite_fk = waebsite_fk;
        this.priviledge_fk = priviledge_fk;
    }

    public WebPriviledge() {}
}
