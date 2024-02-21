package com.example.demo.services;

import com.example.demo.entites.manageProducts;

import com.example.demo.repositories.ProductsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductsService {

    @Autowired
    private ProductsRepository productsRepository;

    public List<manageProducts> findAll() {
        return productsRepository.findAll();
    }

    public manageProducts save(manageProducts manageProducts) {
        return productsRepository.save(manageProducts);
    }

    public manageProducts findById(Integer id) {
        Optional<manageProducts> optional = productsRepository.findById(id);
        return optional.orElse(null);
    }

    public void deleteById(Integer id) {
        productsRepository.deleteById(id);
    }

    public manageProducts update(Integer id, manageProducts updatedProduct) {
        Optional<manageProducts> optionalProduct = productsRepository.findById(id);
        if (optionalProduct.isPresent()) {
            manageProducts existingProduct = optionalProduct.get();

            existingProduct.setStock(updatedProduct.getStock());
            return productsRepository.save(existingProduct);
        } else {
            return null;
        }
    }
}
