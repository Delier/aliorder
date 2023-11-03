package com.delier.base.pojo;

import com.delier.base.util.Deleted;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

//用户
@SQLDelete(sql = "update `account` set deleted = 1 where id=?")
@Where(clause = "deleted = 0")
@Entity
@Table(name = "account")
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nick_name")
    private String nickName;

    @Column(name = "money")
    private BigDecimal money;

    @OneToMany
    @JoinTable(
            name = "account_order",
            joinColumns = @JoinColumn(name = "account_id"),
            inverseJoinColumns = @JoinColumn(name = "order_id")
    )
    private List<Order> orderList;

    @Column(name = "deleted")
    private Deleted deleted;

    @Version
    @Column(name = "version")
    private Long version;

    public Account() {
    }

    public Long getId() {
        return id;
    }

    public BigDecimal getMoney() {
        return money;
    }

    public void setMoney(BigDecimal money) {
        this.money = money;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public List<Order> getOrderList() {
        return orderList;
    }

    public void setOrderList(List<Order> orderList) {
        this.orderList = orderList;
    }

    public Account(Long id, String nickName, BigDecimal money, List<Order> orderList, Long version, Deleted deleted) {
        this.id = id;
        this.nickName = nickName;
        this.money = money;
        this.orderList = orderList;
        this.version = version;
        this.deleted = deleted;
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

    public Deleted getDeleted() {
        return deleted;
    }

    public void setDeleted(Deleted deleted) {
        this.deleted = deleted;
    }

    @Override
    public String toString() {
        String str = "Account{" +
                "id=" + id +
                ", nickName='" + nickName +
                ", money='" + money;
        StringBuilder sb = new StringBuilder(str);
        sb.append(", OrderList = [");
        for (Order order : orderList) {
            sb.append(order.getId());
            sb.append(",");
        }
        sb.append("] }");
        return sb.toString();
    }
}
