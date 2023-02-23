package com.example.appToDeploy.customer;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import java.time.Period;
import static org.junit.jupiter.api.Assertions.assertEquals;

class CustomerServiceUnitTest {

    @Test
    void testNewCustomer(){
        //Given
        CustomerService customerService = new CustomerService();
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
    void testAgeOfCustomer(){
        //Given
        CustomerService customerService = new CustomerService();
        LocalDate dateOfToday = LocalDate.now();
        LocalDate dateOfBirth = LocalDate.of(2000,12,30);
        Integer expectedAge = Period.between(dateOfBirth,dateOfToday).getYears();

        //when
       Integer actualAge = customerService.ageOfCustomer(dateOfBirth);

       //Then
        assertEquals(expectedAge,actualAge);
    }

    @Test
    void testHello(){
        //Given
        CustomerService customerService = new CustomerService();
        String name = "Dani";


        //when
        String greeting = customerService.Hello(name);

        //Then
        assertEquals("Hello Dani",greeting);
    }


}