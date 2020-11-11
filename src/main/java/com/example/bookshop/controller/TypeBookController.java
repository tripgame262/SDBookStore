package com.example.bookshop.controller;

import com.example.bookshop.model.TypeBook;
import com.example.bookshop.model.TypeBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TypeBookController {
    @Autowired
    private TypeBookService typeBookService;

    @GetMapping("/typebook")
    public List<TypeBook> list() {
        return typeBookService.listAll();
    }
}
