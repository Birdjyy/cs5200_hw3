package edu.northeastern.cs5200.Impl;

import edu.northeastern.cs5200.models.Role;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public interface RoleImpl{
    void assignWebsiteRole(int developerId, int websiteId, int roleId);
    void assignPageRole(int developerId, int pageId, int roleId);
    void deleteWebsiteRole(int developerId, int websiteId, int roleId);
    void deletePageRole(int developerId, int pageId, int roleId);
}
