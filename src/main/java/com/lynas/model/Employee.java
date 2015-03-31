package com.lynas.model;

import org.springframework.stereotype.Component;

/**
 * Created by sazzad on 3/31/15.
 */
@Component
public class Employee {
    public String firstName;
    public String lastName;

    public Employee() {

    }

    public Employee(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
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
}
