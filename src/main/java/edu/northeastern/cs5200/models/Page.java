package edu.northeastern.cs5200.models;

import java.util.Date;

public class Page {
    private int page_id;
    private String title;
    private String description;
    private java.sql.Date created;
    private java.sql.Date updated;
    private int views;
    private int website_fk;
    private Website website;

    public Website getWebsite() {
        return website;
    }

    public void setWebsite(Website website) {
        this.website = website;
    }

    public int getPage_id() {
        return page_id;
    }

    public void setPage_id(int page_id) {
        this.page_id = page_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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

    public int getViews() {
        return views;
    }

    public void setViews(int views) {
        this.views = views;
    }

    public int getWebsite_fk() {
        return website_fk;
    }

    public void setWebsite_fk(int website_fk) {
        this.website_fk = website_fk;
    }

    public Page(int page_id, String title, String description, java.sql.Date created, java.sql.Date updated, int views) {
        this.page_id = page_id;
        this.title = title;
        this.description = description;
        this.created = created;
        this.updated = updated;
        this.views = views;
    }

    public Page(int page_id, String title, String description, java.sql.Date created, java.sql.Date updated, int views, int website_fk) {
        this.page_id = page_id;
        this.title = title;
        this.description = description;
        this.created = created;
        this.updated = updated;
        this.views = views;
        this.website_fk = website_fk;
    }

    public Page() {}
}
