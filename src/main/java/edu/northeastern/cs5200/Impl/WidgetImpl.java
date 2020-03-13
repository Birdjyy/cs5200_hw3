package edu.northeastern.cs5200.Impl;

import edu.northeastern.cs5200.models.Widget;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import java.util.Collection;
@Service
public interface WidgetImpl{
    void createWidgetForPage(int pageId, Widget widget);
    Collection<Widget> findAllWidgets();
    Widget findWidgetById(int widgetId);
    Collection<Widget> findWidgetsForPage(int pageId);
    int updateWidget(int widgetId, Widget widget);
    int deleteWidget(int widgetId);
    void createImageWidgetForWieget(int widgetId, String src);
    void createYoutubeWidgetForWieget(int widgetId, String url);
    void deleteLastWidget(int pageFk);
}
