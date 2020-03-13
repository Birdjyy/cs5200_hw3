package edu.northeastern.cs5200.models;

public class Developer {
    private int person_fk;
    private Person person;
    private String developer_key;

    public int getPerson_fk() {
        return person_fk;
    }

    public void setPerson_fk(int person_fk) {
        this.person_fk = person_fk;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public String getDeveloper_key() {
        return developer_key;
    }

    public void setDeveloper_key(String developer_key) {
        this.developer_key = developer_key;
    }

    public Developer(int person_fk, Person person, String developer_key) {
        this.person_fk = person_fk;
        this.person = person;
        this.developer_key = developer_key;
    }

    public Developer(String developer_key, int person_fk, String firstname, String lastname) {
        this.developer_key = developer_key;
        this.person = new Person(person_fk, firstname, lastname);
        this.person_fk = person_fk;
    }

    public Developer(String developer_key, int person_fk, String firstname, String lastname, String username, String password, String email, String dob) {
        this.developer_key = developer_key;
        this.person = new Person(person_fk, firstname, lastname, username, password, email, dob);
        this.person_fk = person_fk;
    }

    public Developer(String developer_key, int person_fk, String firstname, String lastname, String username, String password, String email, String dob, String address, String phone) {
        this.developer_key = developer_key;
        this.person = new Person(person_fk, firstname, lastname, username, password, email, dob);
        this.person_fk = person_fk;
    }

    public Developer(String developer_key, int person_fk, String firstname, String lastname, String username, String password, String email) {
        this.developer_key = developer_key;
        this.person = new Person(person_fk, firstname, lastname, username, password, email);
        this.person_fk = person_fk;
    }
    public Developer(String developer_key) {
        this.developer_key = developer_key;
    }

    public Developer() {}
}
