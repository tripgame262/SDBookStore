package com.example.bookshop.service;

import com.example.bookshop.model.TypeBook;
import com.example.bookshop.repository.TypeBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class TypeBookService {
    @Autowired
    private TypeBookRepository repo;

    public List<TypeBook> listAll() { return repo.findAll(); }

    public void save(TypeBook typeBook) { repo.save(typeBook); }

    public TypeBook get(Integer id) {
        return repo.findById(id).get();
    }

    public void delete(Integer id) {
        repo.deleteById(id);
    }
}
