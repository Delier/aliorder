package com.delier.stock.dao;

import com.delier.base.pojo.Stock;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StockDao extends JpaRepository<Stock,Long> {
}
