package com.example.bookshop.controller;

import com.example.bookshop.model.Customer;
import com.example.bookshop.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/customer")
public class CustomerController {
    @Autowired
    private CustomerRepository repository;

    @GetMapping("/showall")
    public List<Customer> showAll(){
        return repository.showAll();
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable("id") Integer id){
        repository.deleteCustomer(id);
    }

    @GetMapping("/show/{id}")
    public Customer getCustomer(@PathVariable("id") Integer id){
        return repository.findById(id);
    }

    @PostMapping("/create")
    public Customer creatCustomer(@RequestBody Customer customer){
        return repository.save(customer);
    }

    @PostMapping("/edit")
    public Customer editCustomer(@RequestBody Customer customer){
        Customer editCustomer = repository.findById(customer.getId());
        editCustomer.setName(customer.getName());
        editCustomer.setTel(customer.getTel());
        return repository.save(editCustomer);
    }
}
