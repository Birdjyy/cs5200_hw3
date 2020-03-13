package edu.northeastern.cs5200.models;

import sun.security.krb5.internal.SeqNumber;

public class Widget {
    private int widget_id;
    private String name;
    private int width;
    private int height;
    private String css_class;
    private String css_style;
    private String text;
    private int widget_order;
    private int page_fk;
    private Page page;

    public Page getPage() {
        return page;
    }

    public void setPage(Page page) {
        this.page = page;
    }

    public int getWidget_id() {
        return widget_id;
    }

    public void setWidget_id(int widget_id) {
        this.widget_id = widget_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public String getCss_class() {
        return css_class;
    }

    public void setCss_class(String css_class) {
        this.css_class = css_class;
    }

    public String getCss_style() {
        return css_style;
    }

    public void setCss_style(String css_style) {
        this.css_style = css_style;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getWidget_order() {
        return widget_order;
    }

    public void setWidget_order(int widget_order) {
        this.widget_order = widget_order;
    }

    public int getPage_fk() {
        return page_fk;
    }

    public void setPage_fk(int page_fk) {
        this.page_fk = page_fk;
    }

    public Widget(int widget_id, String name, int width, int height, String css_class, String css_style, String text, int order) {
        this.widget_id = widget_id;
        this.name = name;
        this.width = width;
        this.height = height;
        this.css_class = css_class;
        this.css_style = css_style;
        this.text = text;
        this.widget_order = order;
    }

    public Widget(int widget_id, String name, int width, int height, String css_class, String css_style, String text, int order, int size, String html, String src, String url, boolean Shareable, boolean expandable) {
        this.widget_id = widget_id;
        this.name = name;
        this.width = width;
        this.height = height;
        this.css_class = css_class;
        this.css_style = css_style;
        this.text = text;
        this.widget_order = order;
    }

    public Widget(String name, String text, int order, int page_fk) {
        this.name = name;
        this.text = text;
        this.widget_order = order;
        this.page_fk = page_fk;
    }

    public Widget(String name, int width, int height, int order, int page_fk) {
        this.name = name;
        this.width = width;
        this.height = height;
        this.widget_order = order;
        this.page_fk = page_fk;
    }

    public Widget() {}
}
