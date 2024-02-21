package com.example.demo.entites;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.List;

@Entity
@Table(name="manageCustomers")
public class manageCustomers implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(nullable = false,length = 20)
    private String name;
    @Column(nullable = false,length = 20)
    private String phone;
    @Column(nullable = false,length = 20)
    private String address;
    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
    private List<sale> sales;

    public manageCustomers() {
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }


}
