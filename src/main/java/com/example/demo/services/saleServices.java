package com.example.demo.services;

import com.example.demo.entites.manageCustomers;
import com.example.demo.entites.manageProducts;
import com.example.demo.entites.sale;
import com.example.demo.repositories.CustomersRepository;
import com.example.demo.repositories.ProductsRepository;
import com.example.demo.repositories.SaleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class saleServices {

    @Autowired
    private SaleRepository saleRepository;

    @Autowired
    private ProductsRepository productsRepository;

    @Autowired
    private CustomersRepository customersRepository;

    public sale createSale(int productId, int customerId, int quantity) {
        manageProducts product = productsRepository.findById(productId).orElse(null);
        manageCustomers customer = customersRepository.findById(customerId).orElse(null);

        if (product != null && customer != null && product.getStock() >= quantity) {
            sale newSale = new sale();
            newSale.setName(String.valueOf(productId)); // Nombre del producto como String
            newSale.setCant(quantity); // Establecer la cantidad en la venta

            newSale.setProduct(product);
            newSale.setCustomer(customer);

            // Actualizar el stock del producto
            product.setStock(product.getStock() - quantity);
            productsRepository.save(product);

            return saleRepository.save(newSale);
        }

        return null;
    }

}
