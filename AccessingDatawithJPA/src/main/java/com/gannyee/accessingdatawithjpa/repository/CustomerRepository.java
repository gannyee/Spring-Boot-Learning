package com.gannyee.accessingdatawithjpa.repository;

import com.gannyee.accessingdatawithjpa.bean.Customer;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CustomerRepository extends CrudRepository<Customer, Long> {

    List<Customer> findByLastName(String name);
}
