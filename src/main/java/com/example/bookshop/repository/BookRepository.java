package com.example.bookshop.repository;

import com.example.bookshop.model.Book;
import com.example.bookshop.model.Customer;
import com.example.bookshop.model.TypeBook;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public class BookRepository {
    @PersistenceContext
    private EntityManager entityManager;

    public List<Book> showAll(){
        Query query = entityManager.createQuery("from Book");
        return query.getResultList();
    }

    @Transactional
    public Book save(Book book){
        entityManager.persist(book);
        return book;
    }

    public Book findById(Integer id){
        return entityManager.find(Book.class , id);
    }

    @Transactional
    public Book deleteBook(Integer id){
        Book book = entityManager.find(Book.class, id);
        entityManager.remove(book);
        return book;
    }
}
