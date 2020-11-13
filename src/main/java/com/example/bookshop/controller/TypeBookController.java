package com.example.bookshop.controller;

import com.example.bookshop.model.TypeBook;
import com.example.bookshop.service.TypeBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
    @PostMapping("/addBook")
    public TypeBook addBook(@RequestBody TypeBook typebook) {
    	return typeBookService.saveTypeBook(typebook);
    }
    @PostMapping("/addBooks")
    public List<TypeBook> addBooks(@RequestBody List<TypeBook> typebooks){
    	return typeBookService.saveTypeBooks(typebooks);
    }
    @GetMapping("/books")
    public List<TypeBook> findAllTypeBooks(){
    	return typeBookService.getTypeBook();
    }
    @GetMapping("/books/{id}")
    public TypeBook findTypeById(@PathVariable int id) {
    	return typeBookService.getTypeBookById(id);
    	
    	
    }
   
    @DeleteMapping("/delete/{id}")
    public String deleteBook(@PathVariable int id) {
    	return typeBookService.deleteTypebook(id);
    }
}
