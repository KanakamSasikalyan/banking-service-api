package com.rest.banking.service;


import com.rest.banking.dto.CustomerDTO;
import com.rest.banking.model.Customer;
import com.rest.banking.repository.CustomerRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class CustomerServiceTest {

    @Mock
    public CustomerRepository customerRepository;

    @InjectMocks
    public CustomerService customerService;

    public Customer customer;
    public CustomerDTO customerDTO;

    @BeforeEach
    public void setUp(){
        customer = new Customer();
        customerDTO = new CustomerDTO();
        customerDTO.setFirstname("ABCD");
        customerDTO.setLastname("RFTC");
        customerDTO.setEmail("kal@gmail.com");
        customerDTO.setDob("dd-mm-yyyy");
        customerDTO.setGender("male");
    }

    @Test
    public void testFindCustomerById(){
        when(customerRepository.findById(1L)).thenReturn(Optional.of(new Customer()));
        Customer customer = customerService.findCustomerById(1L);
        verify(customerRepository, times(1)).findById(1L);
    }

    @Test
    public void testAddCustomer(){
        when(customerRepository.save(Mockito.any(Customer.class))).thenReturn(customer);
        Customer customer1 = customerService.addCustomer(customerDTO);

        verify(customerRepository, times(1)).save(Mockito.any(Customer.class));

        assertEquals("ABCD", customer1.getFirstname());
        assertEquals("RFTC", customer1.getLastname());
        assertEquals("kal@gmail.com", customer1.getEmail());
        assertEquals("dd-mm-yyyy", customer1.getDob());
        assertEquals("male", customer1.getGender());
    }

    @Test
    public void testUpdateCustomer(){
        when(customerRepository.findById(anyLong())).thenReturn(Optional.of(customer));
        when(customerRepository.save(Mockito.any(Customer.class))).thenReturn(customer);

        Customer customer1 = customerService.updateCustomer(Mockito.anyLong(), customerDTO);

        verify(customerRepository, times(1)).findById(anyLong());
        verify(customerRepository, times(1)).save(Mockito.any(Customer.class));

        assertNotNull(customer1);
    }

}
