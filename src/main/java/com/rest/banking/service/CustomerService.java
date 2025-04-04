package com.rest.banking.service;

import com.rest.banking.dto.CustomerDTO;
import com.rest.banking.model.Customer;
import com.rest.banking.repository.CustomerRepository;
import jakarta.transaction.Transactional;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class CustomerService {

    private static final Logger log = LogManager.getLogger(CustomerService.class);
    @Autowired
    public CustomerRepository customerRepository;

    public Customer findCustomerById(Long id){
        Optional<Customer> customer = customerRepository.findById(id);
        return customer.orElse(null);
    }

    @Transactional
    public Customer addCustomer(CustomerDTO customer){
        Customer customer1 = new Customer();
        customer1.setFirstname(customer.getFirstname());
        customer1.setLastname(customer.getLastname());
        customer1.setEmail(customer.getEmail());
        customer1.setMobile(customer.getMobile());
        customer1.setDob(customer.getDob());
        customer1.setGender(customer.getGender());
        customerRepository.save(customer1);
        return customer1;
    }

    @Transactional
    public Customer updateCustomer(Long id, CustomerDTO customerDTO){
        Optional<Customer> opt = customerRepository.findById(id);
        Customer customer = opt.get();
        if(opt.isPresent()){
            customer.setFirstname(customerDTO.getFirstname());
            customer.setLastname(customerDTO.getLastname());
            customer.setEmail(customerDTO.getEmail());
            customer.setMobile(customerDTO.getMobile());
            customer.setDob(customerDTO.getDob());
            customer.setGender(customerDTO.getGender());

            customerRepository.save(customer);
            log.info("Customer Record Updated!");
        }else{
            log.info("Customer Record Not Found!");
        }

        return opt.orElse(null);
    }

}
