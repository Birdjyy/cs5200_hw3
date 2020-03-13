package edu.northeastern.cs5200.Impl;

import edu.northeastern.cs5200.models.PageRole;
import org.springframework.stereotype.Service;

@Service
public interface PageRoleImpl {
    void createPageRole(PageRole pageRole);
    void updatePageRole(PageRole pageRole);
}
