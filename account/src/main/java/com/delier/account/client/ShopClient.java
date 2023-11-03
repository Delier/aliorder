package com.delier.account.client;

import com.delier.base.pojo.Order;
import com.delier.base.util.Phase;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;

@FeignClient("service-shop")
public interface ShopClient {

    @GetMapping("/shop/order/{id}")
    Order getOrder(@PathVariable("id") Long oId);

    @PutMapping("/shop/update/{id}")
    Order updateOrder(@PathVariable("id")Long oId, Phase phase);
}
