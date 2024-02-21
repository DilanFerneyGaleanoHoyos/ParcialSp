package com.example.demo.repositories;




import com.example.demo.entites.sale;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SaleRepository extends JpaRepository<sale, Integer> {
}
