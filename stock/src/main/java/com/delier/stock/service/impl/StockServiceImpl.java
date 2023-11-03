package com.delier.stock.service.impl;

import com.delier.base.pojo.Product;
import com.delier.base.pojo.Stock;
import com.delier.stock.dao.StockDao;
import com.delier.stock.service.StockService;
import io.seata.core.context.RootContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class StockServiceImpl implements StockService {

    @Autowired
    StockDao stockDao;

    @Override
    public Boolean increaseStock(Product product) {
        System.out.println("+++++++++++++++++"+RootContext.getXID());
        Long stockId = product.getStockId();
        Optional<Stock> stockOpt = stockDao.findById(stockId);
        Stock stock = stockOpt.get();
        Integer count = stock.getCount();
        stock.setCount(count+product.getFinalCount());
        stockDao.save(stock);
        return Boolean.TRUE;
    }

    @Override
    public Boolean decreaseStock(Product product) {
        Long stockId = product.getStockId();
        Optional<Stock> stockOpt = stockDao.findById(stockId);
        Stock stock = stockOpt.get();
        Integer count = stock.getCount();
        stock.setCount(count-product.getFinalCount());
        stockDao.save(stock);
        return Boolean.TRUE;
    }

    @Override
    public Stock getStock(Long id) {
        return stockDao.findById(id).get();
    }
}
