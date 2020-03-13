package edu.northeastern.cs5200.Impl;

import edu.northeastern.cs5200.models.Developer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public interface DeveloperImpl {
    void createDeveloper(Developer developer);
    Collection<Developer> findAllDevelopers();
    Developer findDeveloperById(int developerId);
    Developer findDeveloperByUsername (String username);
    Developer findDeveloperByCredentials(String username, String password);
    int updateDeveloper(int developerId, Developer developer);
    int deleteDeveloper(int developerId);
    void updatephone(int developerId, String phone);
    void deleteAdress(int developerId, boolean primary);
}
