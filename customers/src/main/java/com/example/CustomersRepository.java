package com.example;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface CustomersRepository extends CrudRepository<Customer, Long> {
    Customer findByName(@Param("name") String name);
}
