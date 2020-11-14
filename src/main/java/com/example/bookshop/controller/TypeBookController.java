package com.example.bookshop.controller;

import com.example.bookshop.model.TypeBook;
import com.example.bookshop.service.TypeBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/typebook")
public class TypeBookController {
    @Autowired
    private TypeBookService typeBookService;

    @GetMapping("/typebook")
    public List<TypeBook> list() {
        return typeBookService.listAll();
    }

    @PostMapping("/create")
    public void create(@RequestBody TypeBook typeBook){
        typeBookService.save(typeBook);
    }
}
