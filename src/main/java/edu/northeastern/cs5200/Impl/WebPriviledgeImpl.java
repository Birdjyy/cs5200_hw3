package edu.northeastern.cs5200.Impl;

import org.springframework.stereotype.Service;

@Service
public interface WebPriviledgeImpl {
    void deleteWebRole(int website_fk);
}
