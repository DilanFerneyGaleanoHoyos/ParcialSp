package com.example.demo.entites;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name="sale")
public class sale implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(nullable = false, length = 20)
    private String name;

    @Column(nullable = false)
    private Integer cant;



    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product" )
    @JsonIgnore
    private manageProducts product;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer") // Cambia "customer_id" al nombre correcto de la columna en tu base de datos
    @JsonIgnore
    private manageCustomers customer;


    public sale() {
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



    public manageProducts getProduct() {
        return product;
    }

    public void setProduct(manageProducts product) {
        this.product = product;
    }

    public manageCustomers getCustomer() {
        return customer;
    }

    public void setCustomer(manageCustomers customer) {
        this.customer = customer;
    }

    public Integer getCant() {
        return cant;
    }

    public void setCant(Integer cant) {
        this.cant = cant;
    }
}