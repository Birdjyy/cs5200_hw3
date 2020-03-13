package edu.northeastern.cs5200.Impl;

import edu.northeastern.cs5200.models.Website;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import java.util.Collection;
@Service
public interface WebsiteImpl{
    void createWebsiteForDeveloper(int developerId, Website website);
    Collection<Website> findAllWebsites();
    Collection<Website> findWebsiteForDeveloper(int developerId);
    Website findWebsiteById(int websiteId);
    int updateWebsite(int websiteId, Website website);
    int deleteWebsite(int websiteId);
}
