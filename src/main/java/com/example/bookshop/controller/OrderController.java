package com.example.bookshop.controller;

import com.example.bookshop.model.Book;
import com.example.bookshop.model.Order;
import com.example.bookshop.model.TypeBook;
import com.example.bookshop.repository.BookRepository;
import com.example.bookshop.repository.CustomerRepository;
import com.example.bookshop.repository.OrderRepository;
import com.example.bookshop.service.TypeBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/order")
public class OrderController {
   @Autowired
   private OrderRepository repository;

    @GetMapping("/showall")
    public List<Order> showAll(){
        return repository.showAll();
    }

    @PostMapping("/create")
    public Order createOrder (@RequestBody Order order){
        return repository.save(order);
    }

}
