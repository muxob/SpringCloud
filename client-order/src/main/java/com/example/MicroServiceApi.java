package com.example;

import com.example.domainobject.*;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class MicroServiceApi {

    @LoadBalanced
    @Bean
    RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Autowired
    private RestTemplate restTemplate;

    public Customer getCustomerByName(String customerName) {
        return restTemplate.getForObject(
                "http://CUSTOMERS-APP/customers/search/findByName?name={customerName}",
                Customer.class,
                customerName
        );
    }

    public OrderDetails getCustomerOrder(long customerId) {
        return restTemplate.getForObject(
                "http://ORDERS-APP/purchaseOrders/search/findByCustomerId?customerId={customerId}",
                OrderDetails.class,
                customerId
        );
    }

    public OrderItem[] getOrderItems(long orderId) {
        EmbeddedResponse responseEntity = restTemplate.getForObject(
                "http://ORDERS-APP/purchaseOrders/{orderId}/items",
                EmbeddedResponse.class,
                orderId
        );
        return responseEntity._embedded.poItems;
    }

    @HystrixCommand(fallbackMethod = "defaultProduct")
    public Product getProduct(long productId) {
        return restTemplate.getForObject(
                "http://PRODUCTS-APP/products/{productId}",
                Product.class,
                productId
        );
    }

    public Product defaultProduct(long productId) {
        return new Product();
    }
}