package com.example.insecuredeserialization.structure;

public class Role {
    Role(){
        System.out.println("Role Created!!!!");
    }

    public String roleName;
    public Double salary;

    public Double getSalary() {
        return salary;
    }
    
}
