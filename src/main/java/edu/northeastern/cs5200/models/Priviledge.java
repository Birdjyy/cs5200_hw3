package edu.northeastern.cs5200.models;

public class Priviledge {
    private int priviledge_id;
    private String priviledge;

    public int getPriviledge_id() {
        return priviledge_id;
    }

    public void setPriviledge_id(int priviledge_id) {
        this.priviledge_id = priviledge_id;
    }

    public String getPriviledge() {
        return priviledge;
    }

    public void setPriviledge(String priviledge) {
        this.priviledge = priviledge;
    }

    public Priviledge(int priviledge_id, String priviledge) {
        this.priviledge_id = priviledge_id;
        this.priviledge = priviledge;
    }

    public Priviledge() {}
}
