package com.example.bookshop.repository;

import com.example.bookshop.model.Book;
import com.example.bookshop.model.Order;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public class OrderRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public List<Order> showAll(){
        Query query = entityManager.createQuery("from Order");
        return query.getResultList();
    }

    @Transactional
    public Order save(Order order){
        entityManager.persist(order);
        return order;
    }

    public Order findById(Integer id){
        return entityManager.find(Order.class , id);
    }

    @Transactional
    public Order deleteBook(Integer id){
        Order order = entityManager.find(Order.class, id);
        entityManager.remove(order);
        return order;
    }
}
