package com.example.domainobject;

import java.util.ArrayList;
import java.util.List;

public class OrderDetails {
    private long id;
    private String customerName;
    private String customerAddress;
    private List<OrderItem> items = new ArrayList<>();

    public long getId() {
        return id;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }

    public List<OrderItem> getItems() {
        return items;
    }

    public void setItems(List<OrderItem> items) {
        this.items = items;
    }
}
