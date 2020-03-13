package edu.northeastern.cs5200.models;

public class Address {
    private int address_id;
    private String street1;
    private String street2;
    private String city;
    private String state;
    private String zip;
    private String primary;
    private int person_fk;
    private Person person;

    public int getAddress_id() {
        return address_id;
    }

    public void setAddress_id(int address_id) {
        this.address_id = address_id;
    }

    public String getStreet1() {
        return street1;
    }

    public void setStreet1(String street1) {
        this.street1 = street1;
    }

    public String getStreet2() {
        return street2;
    }

    public void setStreet2(String street2) {
        this.street2 = street2;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getPrimary() {
        return primary;
    }

    public void setPrimary(String primary) {
        this.primary = primary;
    }

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

    public Address(int address_id, String street1, String street2, String city, String state, String zip, String primary, int person_fk, Person person) {
        this.address_id = address_id;
        this.street1 = street1;
        this.street2 = street2;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.primary = primary;
        this.person_fk = person_fk;
        this.person = person;
    }

    public Address() {}
}
