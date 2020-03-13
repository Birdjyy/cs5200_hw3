package edu.northeastern.cs5200.models;

public class HtmlWidget {
    private int html_widget_id;
    private String html;
    private int widget_fk;
    private Widget widget;

    public Widget getWidget() {
        return widget;
    }

    public void setWidget(Widget widget) {
        this.widget = widget;
    }

    public int getHtml_widget_id() {
        return html_widget_id;
    }

    public void setHtml_widget_id(int html_widget_id) {
        this.html_widget_id = html_widget_id;
    }

    public String getHtml() {
        return html;
    }

    public void setHtml(String html) {
        this.html = html;
    }

    public int getWidget_fk() {
        return widget_fk;
    }

    public void setWidget_fk(int widget_fk) {
        this.widget_fk = widget_fk;
    }

    public HtmlWidget(int html_widget_id, String html, int widget_fk, Widget widget) {
        this.html_widget_id = html_widget_id;
        this.html = html;
        this.widget_fk = widget_fk;
        this.widget = widget;
    }

     public HtmlWidget() {}
}
