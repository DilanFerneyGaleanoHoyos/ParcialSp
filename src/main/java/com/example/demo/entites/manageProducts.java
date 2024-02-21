package com.example.demo.entites;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.List;

@Entity
@Table(name="manageProducts")
public class manageProducts  implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(nullable = false,length = 20)
    private String name;

    @Column(nullable = false )
    private Integer stock;

    @Column(nullable = false)
    private Integer flotsam;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
    private List<sale> sales;

    public manageProducts() {
    }

    public manageProducts(int id, String name, Integer stock, Integer flotsam, List<sale> sales) {
        this.id = id;
        this.name = name;
        this.stock = stock;
        this.flotsam = flotsam;
        this.sales = sales;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public Integer getFlotsam() {
        return flotsam;
    }

    public void setFlotsam(Integer flotsam) {
        this.flotsam = flotsam;
    }
}
