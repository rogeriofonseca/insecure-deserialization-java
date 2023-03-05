package com.example.insecuredeserialization.insecuredeserialization;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.insecuredeserialization.structure.Employee;

@RestController
public class WebApp {
    
    @RequestMapping("/api/test")
    public String getRoute(@RequestParam(defaultValue = "default") String name) throws IOException, ClassNotFoundException {
        Employee employee = new Employee();
        employee.name = "Rogerio F Goncalves";
        employee.email = "rogerio@email.com";
        employee.password = "senha@123";
        employee.roleName = "Pentetester 12345";
        employee.salary = 10000.00;

        try {
            // File Handler
            FileOutputStream fos = new FileOutputStream("objectSerialized.ser");
            
            // Object Handler
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(employee);
            oos.flush();
            oos.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }


        FileInputStream fis = new FileInputStream("objectSerialized.ser");
        ObjectInputStream ois = new ObjectInputStream(fis);

        Employee newEmployee = (Employee) ois.readObject();

        return newEmployee.getName();
    }
}
