package com.example.appToDeploy.customer;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.time.LocalDate;
import java.time.Period;
import static org.junit.jupiter.api.Assertions.assertEquals;



@SpringBootTest
class CustomerServiceUnitTest {

    @Autowired
    private  CustomerService customerService;


    @Test
    void testNewCustomer(){
        //Given
       Integer id = 1;
        String firstName = "Dani";
        String lastName ="WELSONE";
        LocalDate dateOfBirth = LocalDate.of(2000, 12,30);

        //when
       Customer customerActual= customerService.newCustomer(firstName,lastName,dateOfBirth);

        //Then
        assertEquals(1,customerActual.getId());
    }

    @Test
    void testHello(){
        //Given
        String name = "Dani";

        //when
        String greeting = customerService.Hello(name);

        //Then
        assertEquals("Hello Dani",greeting);
    }

    @Test
    void testAgeOfCustomer(){
        //Given
        LocalDate dateOfToday = LocalDate.now();
        LocalDate dateOfBirth = LocalDate.of(2000,12,30);
        Integer expectedAge = Period.between(dateOfBirth,dateOfToday).getYears();

        //when
       Integer actualAge = customerService.ageOfCustomer(dateOfBirth);

       //Then
        assertEquals(expectedAge,actualAge);
    }
}