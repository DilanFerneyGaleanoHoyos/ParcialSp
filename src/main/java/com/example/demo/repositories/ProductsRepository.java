package com.example.demo.repositories;



import com.example.demo.entites.manageProducts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductsRepository extends JpaRepository<manageProducts, Integer> {
}