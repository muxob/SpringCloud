package com.example;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
public class ShowcaseDynamicConfiguration {

    @Value("${today-discount-product}")
    private String discountProduct;

    @RequestMapping(value = "/discountProduct", method = RequestMethod.GET)
    public String getTodaysDiscountProduct() {
        return "Today's discount product is " + discountProduct;
    }
}