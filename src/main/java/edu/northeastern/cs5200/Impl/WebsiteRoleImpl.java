package edu.northeastern.cs5200.Impl;

import edu.northeastern.cs5200.models.WebRole;
import org.springframework.stereotype.Service;

@Service
public interface WebsiteRoleImpl {
    void createWebRole(WebRole webRole);
    void deleteWebRole(int website_fk);
}
