package com.rest.banking.controller;

import com.rest.banking.dto.CustomerDTO;
import com.rest.banking.model.Customer;
import com.rest.banking.service.CustomerService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/customer")
public class CustomerController {

    private static final Logger log = LogManager.getLogger(CustomerController.class);

    @Autowired
    CustomerService customerService;

    @GetMapping("/{id}")
    public ResponseEntity<Customer> findCustomerById(@PathVariable Long id){
        Customer customer = customerService.findCustomerById(id);
        return ResponseEntity.ok(customer);
    }

    @PostMapping("/addCustomer")
    public ResponseEntity<CustomerDTO> addCustomer(@RequestBody CustomerDTO customer){
        customerService.addCustomer(customer);
        return ResponseEntity.ok(customer);
    }

    @PutMapping("/updateCustomer/{id}")
    public ResponseEntity<Customer> updateCustomer(@PathVariable Long id, @RequestBody CustomerDTO customerDTO){
        Customer customer = customerService.updateCustomer(id, customerDTO);
        return ResponseEntity.ok(customer);
    }
}
