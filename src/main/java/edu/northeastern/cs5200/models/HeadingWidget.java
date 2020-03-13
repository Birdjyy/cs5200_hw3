package edu.northeastern.cs5200.models;

public class HeadingWidget {
    private int heading_widget_id;
    private int size;
    private int widget_fk;
    private Widget widget;

    public int getHeading_widget_id() {
        return heading_widget_id;
    }

    public void setHeading_widget_id(int heading_widget_id) {
        this.heading_widget_id = heading_widget_id;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getWidget_fk() {
        return widget_fk;
    }

    public void setWidget_fk(int widget_fk) {
        this.widget_fk = widget_fk;
    }

    public Widget getWidget() {
        return widget;
    }

    public void setWidget(Widget widget) {
        this.widget = widget;
    }

    public HeadingWidget(int heading_widget_id, int size, int widget_fk, Widget widget) {
        this.heading_widget_id = heading_widget_id;
        this.size = size;
        this.widget_fk = widget_fk;
        this.widget = widget;
    }

    public HeadingWidget() {}
}
