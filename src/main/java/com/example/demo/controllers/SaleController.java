package com.example.demo.controllers;



import com.example.demo.entites.sale;
import com.example.demo.services.saleServices;
import com.example.demo.responses.ResponseHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/sales")
public class SaleController {

    @Autowired
    private saleServices saleServices;

    @PostMapping
    public ResponseEntity<Object> createSale(@RequestParam int productId, @RequestParam int customerId, @RequestParam int quantity) {
        try {
            sale newSale = saleServices.createSale(productId, customerId, quantity);
            if (newSale != null) {
                return ResponseHandler.generateResponse("Sale created successfully", HttpStatus.CREATED, newSale);
            } else {
                return ResponseHandler.generateResponse("Failed to create sale", HttpStatus.BAD_REQUEST, null);
            }
        } catch (Exception e) {
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR, null);
        }
    }
}
