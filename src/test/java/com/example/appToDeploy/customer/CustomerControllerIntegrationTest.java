package com.example.appToDeploy.customer;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
//import static org.springframework.boot.env.OriginTrackedYamlLoader.KeyScalarNode.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
class CustomerControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void testGetCustomerAge() throws Exception {
        LocalDate dateOfBirth = LocalDate.of(2000,12,30);
        LocalDate today = LocalDate.now();
        Integer age =  Period.between(dateOfBirth,today).getYears();
        mockMvc.perform(get("/customer/age?year=2000&month=12&day=30"))// this cart doesn't exist but it will be created
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").value(age));
    }

    @Test
    void testHello() throws Exception {
        String name = "Dani";
        mockMvc.perform(get("/customer/hello/"+name))// this cart doesn't exist but it will be created
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").value("Hello Dani"));
    }
    @Test
    void testNewCustomer() throws Exception {
        mockMvc.perform(post("/customer/newCustomer?firstName=Dani&lastName=Welson"))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.firstName").value("Dani"))
                .andExpect(jsonPath("$.lastName").value("Welson"))
                .andExpect(jsonPath("$.id").value(1));
    }
}