package com.rest.banking;

import com.rest.banking.model.Customer;
import com.rest.banking.repository.CustomerRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import javax.sql.DataSource;
import java.sql.Date;
import java.text.SimpleDateFormat;

@SpringBootApplication
public class BankingServiceApiApplication {

    private static final Logger log = LogManager.getLogger(BankingServiceApiApplication.class);
    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    DataSource dataSource;

	public static void main(String[] args) {
		SpringApplication.run(BankingServiceApiApplication.class, args);
	}

//    @Bean
//    public CommandLineRunner runner(){
//        return (args) -> {
//            customerRepository.save(new Customer("Kalyan", "K", "kalyan@gmail.com", "7075873532", "22-07-2002", "Male"));
//            log.info("record saved...");
//        };
//    }

}
