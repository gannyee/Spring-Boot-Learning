package com.gannyee.accessingdatawithjpa;

import com.gannyee.accessingdatawithjpa.bean.Customer;
import com.gannyee.accessingdatawithjpa.repository.CustomerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication()
public class AccessingDataWithJPAApplication {

    private static Logger log = LoggerFactory.getLogger(AccessingDataWithJPAApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(AccessingDataWithJPAApplication.class, args);
    }

    @Bean
    public CommandLineRunner demo(CustomerRepository repository) {
        return (args) -> {
            // save a couple of customers
            repository.save(new Customer("Jack", "Bauer"));
            repository.save(new Customer("Chloe", "O'Brian"));
            repository.save(new Customer("Kim", "Bauer"));
            repository.save(new Customer("David", "Palmer"));
            repository.save(new Customer("Michelle", "Dessler"));


            //fetch all customers
            log.info("Customer found with findAll()");
            log.info("-----------------------------");
            for (Customer customer : repository.findAll()) {
                log.info(customer.toString());
            }
            log.info("");

            //fetch an individual customer by Id
            Customer customer = repository.findOne(1L);
            log.info("Customer found with findOne(1L)");
            log.info("-------------------------------");
            log.info(customer.toString());
            log.info("");

            //fetch customer by lastName
            log.info("Customer found with findByLastName(Bauer)");
            log.info("-----------------------------------------");
            for (Customer bauer : repository.findByLastName("Bauer")) {
                log.info(bauer.toString());
            }
            log.info("");

        };
    }
}
