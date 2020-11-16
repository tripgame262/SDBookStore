package com.example.bookshop.controller;


import com.example.bookshop.model.Book;
import com.example.bookshop.model.Customer;
import com.example.bookshop.model.O_rder;


import com.example.bookshop.model.TypeBook;
import com.example.bookshop.repository.BookRepository;
import com.example.bookshop.repository.CustomerRepository;
import com.example.bookshop.repository.OrderRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/order")
public class OrderController {
    @Autowired
    private OrderRepository Orderrepository;
    @Autowired
    private CustomerRepository CustomerRepository;
    @Autowired
    private BookRepository BookRepository;

    @GetMapping("/showall")
    public List<O_rder> showAll(){
        return Orderrepository.showAll();
    }

    @PostMapping("/create")
    public O_rder createOrder (@RequestBody O_rder o_rder){
        return Orderrepository.save(o_rder);
    }

}