package com.example.stech;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.stech.model.Employee;
import com.example.stech.repository.EmployeeRepository;

@SpringBootApplication
public class PdfgeneratorApplication implements CommandLineRunner{
     @Autowired  EmployeeRepository repository;
     
    public static void main(String[] args) {
        SpringApplication.run(PdfgeneratorApplication.class, args);
    }
     
    @Override
    public void run(String... args) throws Exception {
 
        if (repository.count() == 0) {
            // save a list of Employees
            repository.saveAll(Arrays.asList(
                    new Employee("Manager", "Mr", "A", "Male","manager123@gmail.com","Noida","123.456.7890"),
                    new Employee("Hr", "Mr", "B", "Male","hr123@gmial.com","Mohali","909.897.5432"),
                    new Employee("Engineer", "Mr", "C", "Male","eng@123gmail.com","Patna","123.455.4321"),
                    new Employee("SrEr.", "Raj", "D", "Male","sr@123gmail.com","Delhi","620.090.9080"),
                    new Employee("Recruiter", "Miss", "E", "Female","re@123gmail.com","Noida","908,765,1234"),
                    new Employee("Worker", "Mr", "F", "Male","worker@gmail.com","Chnadigadh","908,756,4411")));
        }
 
    }
 
}
