package com.delier.base.pojo;

import com.delier.base.util.Deleted;
import com.delier.base.util.Phase;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

//订单表
@SQLDelete(sql = "update `order` set deleted = 1 where id=?")
@Where(clause = "deleted = 0")
@Entity
@Table(name = "`order`")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "product_id")
    private Product product;
    @Column(name = "final_price")
    private BigDecimal finalPrice;
    @Column(name = "phase")
    private Phase phase;
    @Column(name = "create_time")
    private Date createTime;
    @Column(name = "deleted")
    private Deleted deleted;


    public Order() {
    }

    public Order(Long id, BigDecimal finalPrice, Product product, Date createTime, Deleted deleted, Phase phase) {
        this.id = id;
        this.finalPrice = finalPrice;
        this.product = product;
        this.createTime = createTime;
        this.deleted = deleted;
        this.phase = phase;
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

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Deleted getDeleted() {
        return deleted;
    }

    public void setDeleted(Deleted deleted) {
        this.deleted = deleted;
    }

    public Phase getPhase() {
        return phase;
    }

    public void setPhase(Phase phase) {
        this.phase = phase;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", finalPrice=" + finalPrice +
                ", product=" + product +
                ", createTime=" + createTime +
                '}';
    }
}
