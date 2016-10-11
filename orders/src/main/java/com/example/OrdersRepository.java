package com.example;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface OrdersRepository extends CrudRepository<PurchaseOrder, Long> {
    PurchaseOrder findByCustomerId(@Param("customerId") long customerId);
}
