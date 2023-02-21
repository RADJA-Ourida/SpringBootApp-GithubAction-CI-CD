package com.example.appToDeploy.customer;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;
import java.util.*;
@Service
public class CustomerService {


    public Integer ageOfCustomer(LocalDate dateOfBirthCustomer){
        LocalDate today = LocalDate.now();
        Period periodBetween = Period.between(dateOfBirthCustomer,today);
        Integer age = periodBetween.getYears();
        return age;
    }

    public String Hello(String name){
        return "Hello " + name;

    }

    public Customer newCustomer( String firstName, String lastName, LocalDate dateOfBirth){
        Integer id =1;
        return  new Customer(id,firstName,lastName,dateOfBirth);
    }

}
