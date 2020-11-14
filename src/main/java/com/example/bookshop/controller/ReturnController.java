package com.example.bookshop.controller;

import com.example.bookshop.model.Rent;
import com.example.bookshop.model.Return;
import com.example.bookshop.repository.RentRepository;
import com.example.bookshop.repository.ReturnRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/return")
public class ReturnController {
    @Autowired
    private ReturnRepository repository;

    @GetMapping("/showall")
    public List<Return> showAll(){
        return repository.showAll();
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable("id") Integer id){
        repository.deleteRent(id);
    }

    @GetMapping("/show/{id}")
    public Return getAReturn(@PathVariable("id") Integer id){
        return repository.findById(id);
    }

    @PostMapping("/create")
    public Return createAReturn(@RequestBody Return ret){
        return repository.save(ret);
    }
}
