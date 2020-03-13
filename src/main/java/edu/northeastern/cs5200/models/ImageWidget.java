package edu.northeastern.cs5200.models;

public class ImageWidget {
    private int image_widget_id;
    private String src;
    private int widget_fk;
    private Widget widget;

    public Widget getWidget() {
        return widget;
    }

    public void setWidget(Widget widget) {
        this.widget = widget;
    }

    public int getImage_widget_id() {
        return image_widget_id;
    }

    public void setImage_widget_id(int image_widget_id) {
        this.image_widget_id = image_widget_id;
    }

    public String getSrc() {
        return src;
    }

    public void setSrc(String src) {
        this.src = src;
    }

    public int getWidget_fk() {
        return widget_fk;
    }

    public void setWidget_fk(int widget_fk) {
        this.widget_fk = widget_fk;
    }

    public ImageWidget(int image_widget_id, String src, int widget_fk, Widget widget) {
        this.image_widget_id = image_widget_id;
        this.src = src;
        this.widget_fk = widget_fk;
        this.widget = widget;
    }

    public ImageWidget() {}
}
