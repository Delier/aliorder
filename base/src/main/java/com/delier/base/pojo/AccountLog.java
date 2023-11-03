package com.delier.base.pojo;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

//用户的消费日志
@Entity
@Table(name = "account_log")
public class AccountLog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "order_id")
    private Long orderId;
    @Column(name = "type")
    private Integer type;
    @Column(name = "money")
    private BigDecimal money;
    @Column(name = "create_time")
    private Date CreateTime;

    public AccountLog(Long id, Long orderId, Integer type, BigDecimal money, Date createTime) {
        this.id = id;
        this.orderId = orderId;
        this.type = type;
        this.money = money;
        CreateTime = createTime;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public BigDecimal getMoney() {
        return money;
    }

    public void setMoney(BigDecimal money) {
        this.money = money;
    }

    public Date getCreateTime() {
        return CreateTime;
    }

    public void setCreateTime(Date createTime) {
        CreateTime = createTime;
    }

    @Override
    public String toString() {
        return "AccountLog{" +
                "id=" + id +
                ", OrderId=" + orderId +
                ", type=" + type +
                ", money=" + money +
                ", CreateTime=" + CreateTime +
                '}';
    }
}
