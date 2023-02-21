package com.example.appToDeploy.customer;
//import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@AllArgsConstructor
@Setter
@Getter
//@Entity
public class Customer {

    private Integer id;
    private String firstName;
    private String lastName;
    private LocalDate dateOfBirth;

}
