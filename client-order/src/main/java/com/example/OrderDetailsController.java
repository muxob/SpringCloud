package com.example;

import com.example.domainobject.Customer;
import com.example.domainobject.OrderDetails;
import com.example.domainobject.OrderItem;
import com.example.domainobject.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderDetailsController {
    @Autowired
    private MicroServiceApi microServiceApi;

    @RequestMapping("/orderDetail")
    public OrderDetails getOrderDetails(@RequestParam("customerName") String customerName) {
        Customer customer = microServiceApi.getCustomerByName(customerName);

        OrderDetails orderDetails = microServiceApi.getCustomerOrder(customer.getId());
        orderDetails.setCustomerName(customerName);
        orderDetails.setCustomerAddress(customer.getAddress());

        for (OrderItem poItem : microServiceApi.getOrderItems(orderDetails.getId())) {
            Product orderedProduct = microServiceApi.getProduct(poItem.getProductId());
            poItem.setProductName(orderedProduct.getName());
            poItem.setProductProducer(orderedProduct.getProducer());
            orderDetails.getItems().add(poItem);
        }
        return orderDetails;
    }
}
