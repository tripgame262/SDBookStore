package com.example.bookshop.controller;


import com.example.bookshop.model.O_rder;


import com.example.bookshop.repository.OrderRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/order")
public class OrderController {
    @Autowired
    private OrderRepository repository;

    @GetMapping("/showall")
    public List<O_rder> showAll(){
        return repository.showAll();
    }

    @PostMapping("/create")
    public O_rder createOrder (@RequestBody O_rder o_rder){
        return repository.save(o_rder);
    }

}