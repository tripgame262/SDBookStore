package com.example.bookshop.controller;

import com.example.bookshop.model.TypeBook;
import com.example.bookshop.service.TypeBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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
    
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public String delete(@PathVariable("id") int id) {
    	this.typeBookService.delete(id);
    	return "Deleted.";
   }
    
    
}
