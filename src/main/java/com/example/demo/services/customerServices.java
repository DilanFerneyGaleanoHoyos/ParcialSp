package com.example.demo.services;




import com.example.demo.entites.manageCustomers;
import com.example.demo.entites.sale;
import com.example.demo.repositories.CustomersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class customerServices {

    @Autowired
    private CustomersRepository manageCustomersRepository;

    public List<manageCustomers> findAll() {
        return manageCustomersRepository.findAll();
    }

    public manageCustomers save(manageCustomers manageCustomers) {
        return manageCustomersRepository.save(manageCustomers);
    }

    public manageCustomers findById(Integer id) {
        Optional<manageCustomers> optional = manageCustomersRepository.findById(id);
        return optional.orElse(null);
    }

 public void deleteById(Integer id) {
        manageCustomersRepository.deleteById(id);
    }

}
