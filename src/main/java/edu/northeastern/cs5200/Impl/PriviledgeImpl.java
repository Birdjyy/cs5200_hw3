package edu.northeastern.cs5200.Impl;

import edu.northeastern.cs5200.models.Priviledge;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public interface PriviledgeImpl{
    void assignWebsitePriviledge(int developerId, int websiteId, int priviledgeId);
    void assignPagePriviledge(int developerId, int pageId, int priviledgeId);
    void deleteWebsitePriviledge(int developerId, int websiteId, int priviledgeId);
    void deletePagePriviledge(int developerId, int pageId, int priviledgeId);
}
