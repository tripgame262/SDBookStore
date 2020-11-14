package com.example.bookshop.controller;

import com.example.bookshop.model.Customer;
import com.example.bookshop.model.TypeBook;
import com.example.bookshop.service.TypeBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/book")
public class TypeBookController {
    @Autowired
    private TypeBookService typeBookService;

    @GetMapping("/typebook")
    public List<TypeBook> list() {
        return typeBookService.listAll();
    }


    @GetMapping("/show/{id}")
    public TypeBook getTypeBook(@PathVariable("id") Integer id){
        return typeBookService.get(id);
    }

    @PostMapping("/create")
    public TypeBook createTypeBook (@RequestBody TypeBook typeBook){
        return typeBookService.save(typeBook);
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable("id") int id){
        typeBookService.delete(id);
        return "Deleted.";
    }



}





    

