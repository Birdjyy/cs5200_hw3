package edu.northeastern.cs5200.models;

public class YouTubeWidget {
    private int youtube_widget_id;
    private String url;
    private boolean shareble;
    private boolean expandable;
    private int widget_fk;
    private Widget widget;

    public Widget getWidget() {
        return widget;
    }

    public void setWidget(Widget widget) {
        this.widget = widget;
    }

    public int getYoutube_widget_id() {
        return youtube_widget_id;
    }

    public void setYoutube_widget_id(int youtube_widget_id) {
        this.youtube_widget_id = youtube_widget_id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public boolean isShareble() {
        return shareble;
    }

    public void setShareble(boolean shareble) {
        this.shareble = shareble;
    }

    public boolean isExpandable() {
        return expandable;
    }

    public void setExpandable(boolean expandable) {
        this.expandable = expandable;
    }

    public int getWidget_fk() {
        return widget_fk;
    }

    public void setWidget_fk(int widget_fk) {
        this.widget_fk = widget_fk;
    }

    public YouTubeWidget(int youtube_widget_id, String url, boolean shareble, boolean expandable, int widget_fk, Widget widget) {
        this.youtube_widget_id = youtube_widget_id;
        this.url = url;
        this.shareble = shareble;
        this.expandable = expandable;
        this.widget_fk = widget_fk;
        this.widget = widget;
    }

    public YouTubeWidget() {}
}
