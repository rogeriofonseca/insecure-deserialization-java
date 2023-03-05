package com.example.insecuredeserialization.structure;

import java.io.Serializable;

public class Employee extends Role implements Serializable {
    public Employee() {
        System.out.println("Employee Created!!!");
    }

    public String name;
    public String email;
    public String password;

    public String getName() {
        return name;
    }
    public String getEmail() {
        return email;
    }

    @Override
    public Double getSalary() {
        return this.getSalary();
    }
}
