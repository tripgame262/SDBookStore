package com.example.bookshop.repository;


import com.example.bookshop.model.Rent;
import com.example.bookshop.model.Return;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public class ReturnRepository {
    @PersistenceContext
    private EntityManager entityManager;

    public List<Return> showAll(){
        Query query = entityManager.createQuery("from return");
        return query.getResultList();
    }

    @Transactional
    public Return save(Return ret){
        entityManager.persist(ret);
        return ret;
    }

    public Return findById(Integer id){
        return entityManager.find(Return.class , id);
    }

    @Transactional
    public Return deleteRent(Integer id){
        Return ret = entityManager.find(Return.class ,id);
        entityManager.remove(ret);
        return ret;
    }
}
