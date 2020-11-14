package com.example.bookshop.service;

import com.example.bookshop.model.TypeBook;
import com.example.bookshop.repository.TypeBookRepository;
import com.example.bookshop.repository.TypebooksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class TypeBookService {
    @Autowired
    private TypeBookRepository repo;

    public List<TypeBook> listAll() {
        return repo.findAll(); }

    public TypeBook save(TypeBook typeBook) {
        repo.save(typeBook);
        return typeBook;
    }

    public TypeBook get(Integer id) {
        return repo.findById(id).get();
    }

    public void delete(int id) {
        repo.deleteById(id);
    }
}
