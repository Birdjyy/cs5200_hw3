package edu.northeastern.cs5200.models;

import edu.northeastern.cs5200.daos.PersonDao;

public class User {
    private int person_fk;
    private boolean user_agreement;
    private Person person;

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public int getPerson_fk() {
        return person_fk;
    }

    public void setPerson_fk(int person_fk) {
        this.person_fk = person_fk;
    }

    public boolean isUser_agreement() {
        return user_agreement;
    }

    public void setUser_agreement(boolean user_agreement) {
        this.user_agreement = user_agreement;
    }

    public User(int person_fk, boolean user_agreement, Person person) {
        this.person_fk = person_fk;
        this.user_agreement = user_agreement;
        this.person = person;
    }

    public User(String developer_key, int person_fk, String firstname, String lastname, String username, String password, String email) {
        this.user_agreement = true;
        Person person = new Person(person_fk, firstname, lastname, username, password, email);
        this.person = person;
        this.person_fk = person_fk;
    }

    public User() {}
}
