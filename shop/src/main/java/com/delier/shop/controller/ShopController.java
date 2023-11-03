package com.delier.shop.controller;

import com.delier.base.pojo.Order;
import com.delier.base.util.Phase;
import com.delier.shop.service.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/shop")
public class ShopController {

    @Autowired
    ShopService shopService;

    @GetMapping("/order/{id}")
    public void getOrderInfo(@PathVariable("id") Long id){
        shopService.getOrder(id);
    }

    @PostMapping("/create")
    public void createOrder(@RequestBody Order order){
        shopService.create(order);
    }

    @DeleteMapping("/cancel/{id}")
    public void cancelOrder(@PathVariable("id") Long id){
        shopService.cancelOrder(id);
    }

    @PutMapping("/update/{id}")
    public Order updateOrder(@PathVariable("id")Long oId, Phase phase){
        return shopService.updateOrder(oId,phase);
    }

}
