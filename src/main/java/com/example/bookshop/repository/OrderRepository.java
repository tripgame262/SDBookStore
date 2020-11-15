package com.example.bookshop.repository;


import com.example.bookshop.model.O_rder;

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

    public List<O_rder> showAll(){
        Query query = entityManager.createQuery("from O_rder");
        return query.getResultList();
    }

    @Transactional
    public O_rder save(O_rder o_rder){
        entityManager.persist(o_rder);
        return o_rder;
    }

    public O_rder findById(Integer id){
        return entityManager.find(O_rder.class , id);
    }

    @Transactional
    public O_rder deleteBook(Integer id){
        O_rder o_rder = entityManager.find(O_rder.class, id);
        entityManager.remove(o_rder);
        return o_rder;
    }
}
