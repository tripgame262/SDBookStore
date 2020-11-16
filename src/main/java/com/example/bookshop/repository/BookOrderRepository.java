package com.example.bookshop.repository;

import com.example.bookshop.model.BookOrder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
public class BookOrderRepository {
    @PersistenceContext
    private EntityManager entityManager;

    public List<BookOrder> showAll(){
        Query query = entityManager.createQuery("from BookOrder");
        return query.getResultList();
    }

    @Transactional
    public BookOrder save(BookOrder bookOrder){
        entityManager.persist(bookOrder);
        return bookOrder;
    }

    public BookOrder findById(Integer id){
        return entityManager.find(BookOrder.class , id);
    }

    @Transactional
    public BookOrder deleteBook(Integer id){
        BookOrder bookOrder = entityManager.find(BookOrder.class, id);
        entityManager.remove(bookOrder);
        return bookOrder;
    }

}
