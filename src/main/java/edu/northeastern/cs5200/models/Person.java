package edu.northeastern.cs5200.models;

public class Person {
    private int person_id;
    private String firstname;
    private String lastname;
    private String username;
    private String password;
    private String email;
    private String dob;

    public int getPerson_id() {
        return person_id;
    }

    public void setPerson_id(int person_id) {
        this.person_id = person_id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public Person(int person_id, String firstname, String lastname, String username, String password, String email, String dob) {
        this.person_id = person_id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.username = username;
        this.password = password;
        this.email = email;
        this.dob = dob;
    }

    public Person(int person_id, String firstname, String lastname) {
        this.person_id = person_id;
        this.firstname = firstname;
        this.lastname = lastname;
    }

    public Person(int person_id, String firstname, String lastname, String username, String password, String email) {
        this.person_id = person_id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.username = username;
        this.password = password;
        this.email = email;
    }

    public Person() {}
}
