package com.example.demo.controllers;




import com.example.demo.entites.manageProducts;
import com.example.demo.responses.ResponseHandler;
import com.example.demo.services.ProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class manageProductsController {

    @Autowired
    private ProductsService productService;

    @GetMapping
    public ResponseEntity<Object> findAll() {
        try {
            List<manageProducts> result = productService.findAll();
            return ResponseHandler.generateResponse("Success", HttpStatus.OK, result);
        } catch (Exception e) {
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR, null);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> findById(@PathVariable Integer id) {
        try {
            manageProducts result = productService.findById(id);
            if (result != null) {
                return ResponseHandler.generateResponse("Success", HttpStatus.OK, result);
            } else {
                return ResponseHandler.generateResponse("Product not found", HttpStatus.NOT_FOUND, null);
            }
        } catch (Exception e) {
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR, null);
        }
    }

    @PostMapping
    public ResponseEntity<Object> save(@RequestBody manageProducts manageProducts) {
        try {
            manageProducts savedProduct = productService.save(manageProducts);
            return ResponseHandler.generateResponse("Success", HttpStatus.CREATED, savedProduct);
        } catch (Exception e) {
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR, null);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable Integer id) {
        try {
            productService.deleteById(id);
            return ResponseHandler.generateResponse("Success", HttpStatus.OK, null);
        } catch (Exception e) {
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR, null);
        }
    }
    @PutMapping("/{id}")
    public ResponseEntity<Object> update(@PathVariable Integer id, @RequestBody manageProducts updatedProduct) {
        try {
            manageProducts result = productService.update(id, updatedProduct);
            if (result != null) {
                return ResponseHandler.generateResponse("Success", HttpStatus.OK, result);
            } else {
                return ResponseHandler.generateResponse("Product not found", HttpStatus.NOT_FOUND, null);
            }
        } catch (Exception e) {
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR, null);
        }
    }
}

