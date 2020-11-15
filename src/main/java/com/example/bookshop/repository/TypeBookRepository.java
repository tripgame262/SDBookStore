package com.example.bookshop.repository;

import com.example.bookshop.model.TypeBook;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public class TypeBookRepository {
    @PersistenceContext
    private EntityManager entityManager;

    public List<TypeBook> showAll(){
        Query query = entityManager.createQuery("from TypeBook");
        return query.getResultList();
    }

    @Transactional
    public TypeBook save(TypeBook typeBook){
        entityManager.persist(typeBook);
        return typeBook;
    }

    public TypeBook findById(Integer id){
        return entityManager.find(TypeBook.class , id);
    }

    @Transactional
    public TypeBook deleteBook(Integer id){
        TypeBook typeBook = entityManager.find(TypeBook.class, id);
        entityManager.remove(typeBook);
        return typeBook;
    }
}
