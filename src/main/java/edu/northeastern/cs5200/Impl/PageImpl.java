package edu.northeastern.cs5200.Impl;

import edu.northeastern.cs5200.models.Page;
import edu.northeastern.cs5200.models.Website;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public interface PageImpl{
    void createPageForWebsite(int websiteId, Page page);
    Collection<Page> findAllPages();
    Page findPageById(int pageId);
    Collection<Page> findPagesForWebsite(int websiteId);
    int updatePage(int pageId, Page page);
    int deletePage(int pageId);
    int deleteLastPage(int website_fk);


}
