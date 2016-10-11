package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@EnableFeignClients
public class FeingnClientController {

    @FeignClient("PRODUCTS-APP")
    public interface ProductsClient {
        @RequestMapping(method = RequestMethod.GET, value = "/products")
        List<Object> getProducts();

        @RequestMapping(method = RequestMethod.GET, value = "/products/{productId}", consumes = "application/json")
        Map getProduct(@PathVariable("productId") Long productId);
    }

    @Autowired
    ProductsClient productsClient;

    @RequestMapping("/getProductName")
    public Object getProductUsingFeign(@RequestParam("productId") Long productId) {
        Map productMap = productsClient.getProduct(productId);
        return productMap.get("name");
    }
}
