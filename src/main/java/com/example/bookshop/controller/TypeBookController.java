package com.example.bookshop.controller;

import com.example.bookshop.model.TypeBook;
import com.example.bookshop.repository.TypeBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/typebook")
public class TypeBookController {
    @Autowired
    private TypeBookRepository typeBookRepository;

    @GetMapping("/showall")
    public List<TypeBook> list() {
        return typeBookRepository.showAll();
    }

    @PostMapping("/create")
    public void create(@RequestBody TypeBook typeBook){
        typeBookRepository.save(typeBook);
    }

    @GetMapping("/show/{id}")
    public TypeBook getTypeBook(@PathVariable("id") Integer id){
        return typeBookRepository.findById(id);
    }

    @PostMapping("/edit")
    public TypeBook editTypeBook(@RequestBody TypeBook typeBook){
        TypeBook editTypeBook = typeBookRepository.findById(typeBook.getId());
        editTypeBook.setType(typeBook.getType());
        return typeBookRepository.save(editTypeBook);
    }
}
