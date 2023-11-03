package com.delier.base.pojo;

import javax.persistence.*;
import java.math.BigDecimal;

//订单内商品
@Entity
@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "final_price")
    private BigDecimal finalPrice;
    @Column(name = "final_count")
    private Integer finalCount;
    @Column(name = "stock_id")
    private Long stockId;
    public Product() {
    }

    public Product(Long id, BigDecimal finalPrice, Integer finalCount, Long stockId) {
        this.id = id;
        this.finalPrice = finalPrice;
        this.finalCount = finalCount;
        this.stockId = stockId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getFinalPrice() {
        return finalPrice;
    }

    public void setFinalPrice(BigDecimal finalPrice) {
        this.finalPrice = finalPrice;
    }

    public Integer getFinalCount() {
        return finalCount;
    }

    public void setFinalCount(Integer finalCount) {
        this.finalCount = finalCount;
    }

    public Long getStockId() {
        return stockId;
    }

    public void setStockId(Long stockId) {
        this.stockId = stockId;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", finalPrice=" + finalPrice +
                ", finalCount=" + finalCount +
                ", stockId=" + stockId +
                '}';
    }
}
