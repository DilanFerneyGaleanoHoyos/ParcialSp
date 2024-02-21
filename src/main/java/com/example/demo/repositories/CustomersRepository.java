package com.example.demo.repositories;

import com.example.demo.entites.manageCustomers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomersRepository extends JpaRepository<manageCustomers, Integer> {
}