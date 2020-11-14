package com.example.bookshop.controller;


import com.example.bookshop.model.Customer;
import com.example.bookshop.model.Rent;
import com.example.bookshop.repository.CustomerRepository;
import com.example.bookshop.repository.RentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/rent")
public class RentController {
    @Autowired
    private RentRepository repository;

    @GetMapping("/showall")
    public List<Rent> showAll(){
        return repository.showAll();
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable("id") Integer id){
        repository.deleteRent(id);
    }

    @GetMapping("/show/{id}")
    public Rent getRent(@PathVariable("id") Integer id){
        return repository.findById(id);
    }

    @PostMapping("/create")
    public Rent createRent(@RequestBody Rent rent){
        return repository.save(rent);
    }

   /* @PostMapping("/edit")
    public Rent editRent(@RequestBody Customer customer){
        Rent editCustomer = repository.findById(customer.getId());
        editCustomer.setName(customer.getName());
        editCustomer.setTel(customer.getTel());
        return repository.save(editCustomer);
    }*/
}
