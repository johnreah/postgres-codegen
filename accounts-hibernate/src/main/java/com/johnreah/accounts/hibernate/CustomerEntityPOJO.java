package com.johnreah.accounts.hibernate;

public class CustomerEntityPOJO implements EntityPOJO {

    private long id;
    private String firstName;
    private String lastName;
    private String email;
    private String reference;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public String toString() {
        return String.format("%d | %s, %s | %s | %s", this.getId(), this.getLastName(), this.getFirstName(), this.getEmail(), this.getReference());
    }
}
