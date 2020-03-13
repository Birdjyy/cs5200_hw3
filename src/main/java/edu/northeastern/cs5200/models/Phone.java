package edu.northeastern.cs5200.models;

public class Phone {
    private int phone_id;
    private int person_fk;
    private String phone;
    private boolean p_primary;
    private Person person;

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public int getPhone_id() {
        return phone_id;
    }

    public void setPhone_id(int phone_id) {
        this.phone_id = phone_id;
    }

    public int getPerson_fk() {
        return person_fk;
    }

    public void setPerson_fk(int person_fk) {
        this.person_fk = person_fk;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public boolean isP_primary() {
        return p_primary;
    }

    public void setP_primary(boolean p_primary) {
        this.p_primary = p_primary;
    }

    public Phone(int phone_id, int person_fk, String phone, boolean primary, Person person) {
        this.phone_id = phone_id;
        this.person_fk = person_fk;
        this.phone = phone;
        this.p_primary = primary;
        this.person = person;
    }

    public Phone() {}
}
