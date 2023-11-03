package com.delier.stock.service;

import com.delier.base.pojo.Product;
import com.delier.base.pojo.Stock;

public interface StockService {
    Boolean increaseStock(Product product);
    Boolean decreaseStock(Product product);
    Stock getStock(Long id);
}
