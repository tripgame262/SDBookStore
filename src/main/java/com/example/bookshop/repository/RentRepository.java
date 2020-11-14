package com.example.bookshop.repository;

import com.example.bookshop.model.Customer;
import com.example.bookshop.model.Rent;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public class RentRepository {
    @PersistenceContext
    private EntityManager entityManager;

    public List<Rent> showAll(){
        Query query = entityManager.createQuery("from rent");
        return query.getResultList();
    }

    @Transactional
    public Rent save(Rent rent){
        entityManager.persist(rent);
        return rent;
    }

    public Rent findById(Integer id){
        return entityManager.find(Rent.class , id);
    }

    @Transactional
    public Rent deleteRent(Integer id){
        Rent rent = entityManager.find(Rent.class ,id);
        entityManager.remove(rent);
        return rent;
    }
}
