package edu.northeastern.cs5200.models;

import java.util.Date;

public class Website {
    private int website_id;
    private String name;
    private String description;
    private java.sql.Date created;
    private java.sql.Date updated;
    private int visits;
    private int developer_fk;
    private Developer developer;

    public int getWebsite_id() {
        return website_id;
    }

    public void setWebsite_id(int website_id) {
        this.website_id = website_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public java.sql.Date getCreated() {
        return created;
    }

    public void setCreated(java.sql.Date created) {
        this.created = created;
    }

    public java.sql.Date getUpdated() {
        return updated;
    }

    public void setUpdated(java.sql.Date updated) {
        this.updated = updated;
    }

    public int getVisits() {
        return visits;
    }

    public void setVisits(int visits) {
        this.visits = visits;
    }

    public int getDeveloper_fk() {
        return developer_fk;
    }

    public void setDeveloper_fk(int deceloper_fk) {
        this.developer_fk = deceloper_fk;
    }

    public Developer getDeveloper() {
        return developer;
    }

    public void setDeveloper(Developer developer) {
        this.developer = developer;
    }

    public Website(int website_id, String name, String description, java.sql.Date created, java.sql.Date updated, int visits) {
        this.website_id = website_id;
        this.name = name;
        this.description = description;
        this.created = created;
        this.updated = updated;
        this.visits = visits;
    }

    public Website(int website_id, String name, String description, java.sql.Date created, java.sql.Date updated, int visits, int developer_fk) {
        this.website_id = website_id;
        this.name = name;
        this.description = description;
        this.created = created;
        this.updated = updated;
        this.visits = visits;
        this.developer_fk = developer_fk;
    }

    public Website() {}
}
