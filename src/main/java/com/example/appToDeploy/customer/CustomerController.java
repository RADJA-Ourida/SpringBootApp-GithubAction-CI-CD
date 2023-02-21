package com.example.appToDeploy.customer;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@AllArgsConstructor
@RestController
@RequestMapping("/customer")
public class CustomerController {

    private final CustomerService customerService;


    @GetMapping("/age")
    public ResponseEntity<Integer> getCustomerAge (@RequestParam Integer year,
                                                   @RequestParam Integer month,
                                                   @RequestParam Integer day){
        LocalDate dateOfBirth = LocalDate.of(year,month,day);
        return new ResponseEntity<>(customerService.ageOfCustomer(dateOfBirth), HttpStatus.OK);
    }
    @GetMapping("/hello/{name}")
    public ResponseEntity<String> Hello (@PathVariable("name") String name){
        return new ResponseEntity<>(customerService.Hello(name), HttpStatus.OK);
    }
    @PostMapping("/newCustomer")
    public ResponseEntity<Customer> newCustomer (
            @RequestParam(name = "firstName",defaultValue = "Danila") String firstName,
            @RequestParam(name = "lastName",defaultValue = "Welsona") String lastName){

       LocalDate dateOfBirth = LocalDate.now();
       Customer customer = customerService.newCustomer(firstName,lastName,dateOfBirth);

        return new ResponseEntity<Customer>(customer,HttpStatus.CREATED);
    }




}
