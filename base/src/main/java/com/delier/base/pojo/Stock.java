package com.delier.base.pojo;

import com.delier.base.util.Deleted;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;

//库存
@SQLDelete(sql = "update `stock` set deleted = 1 where id=?")
@Where(clause = "deleted = 0")
@Entity
@Table(name = "stock")
public class Stock {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "count")
    private Integer count;
    @Version
    @Column(name = "version")
    private Long version;
    @Column(name = "deleted")
    private Deleted deleted;

    public Stock() {
    }

    public Stock(Long id, String name, Integer count, Long version, Deleted deleted) {
        this.id = id;
        this.name = name;
        this.count = count;
        this.version = version;
        this.deleted = deleted;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
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
        return "Stock{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", count=" + count +
                '}';
    }
}
