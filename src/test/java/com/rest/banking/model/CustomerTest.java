package com.rest.banking.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CustomerTest {
    @Test
    public void testCustomer(){
        Customer customer = new Customer();
        customer.setId(1L);
        customer.setFirstname("Kalyan");
        customer.setLastname("Kanakam");
        customer.setEmail("kalyan@gmail.com");
        customer.setDob("22-07-2002");
        customer.setMobile("1234567890");

        assertEquals(1L, customer.getId());
        assertEquals("Kalyan", customer.getFirstname());
        assertEquals("Kanakam", customer.getLastname());
        assertEquals("kalyan@gmail.com", customer.getEmail());
        assertEquals("22-07-2002", customer.getDob());
        assertEquals("1234567890", customer.getMobile());

    }

}
