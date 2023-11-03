package com.delier.stock.controller;

import com.delier.base.pojo.Product;
import com.delier.stock.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/stock")
public class StockController {

    @Autowired
    StockService stockService;

    //减少库存
    @PutMapping("/decrease")
    public void decrease(@RequestBody Product product){
        stockService.decreaseStock(product);
    }

    //新增库存
    @PutMapping("/increase")
    public void increase(@RequestBody Product product){
        stockService.increaseStock(product);
    }

    @GetMapping("/info/{id}")
    public void getStock(@PathVariable("id") Long id){
        stockService.getStock(id);
    }
}
