package com.johnreah.accounts.springdatajpa.model.pojos;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
public class Customer {

    private long id;
    private String firstName;
    private String lastName;
    private String email;
    private String reference;

    public String toString() {
        return String.format("%d | %s, %s | %s | %s", this.getId(), this.getLastName(), this.getFirstName(), this.getEmail(), this.getReference());
    }
}
