package edu.northeastern.cs5200.Impl;

import edu.northeastern.cs5200.models.User;
import org.springframework.stereotype.Service;

@Service
public interface UserImpl {
    void createUser(User user);
}
