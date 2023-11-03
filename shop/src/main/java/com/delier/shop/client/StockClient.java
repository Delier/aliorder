package com.delier.shop.client;

import com.delier.base.pojo.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient("service-stock")
public interface StockClient {
    @PutMapping("/stock/decrease")
    Boolean decreaseStock(@RequestBody  Product product);
    @PutMapping("/stock/increase")
    Boolean increaseStock(@RequestBody Product product);
}
