package edu.northeastern.cs5200.Impl;

import edu.northeastern.cs5200.models.Person;
import org.springframework.stereotype.Service;

@Service
public interface PersonImpl {
    void createPerson(Person person);
}
