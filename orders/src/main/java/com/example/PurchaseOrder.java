package com.example;

import javax.persistence.*;
import java.util.List;

@Entity
public class PurchaseOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private long customerId;

    @OneToMany
    private List<PoItem> items;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(long customerId) {
        this.customerId = customerId;
    }

    public List<PoItem> getItems() {
        return items;
    }

    public void setItems(List<PoItem> items) {
        this.items = items;
    }
}
