package com.example.bookshop.repository;

import com.example.bookshop.model.Customer;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public class CustomerRepository {
    @PersistenceContext
    private EntityManager entityManager;

    public List<Customer> showAll(){
        Query query = entityManager.createQuery("from Customer");
        return query.getResultList();
    }

    @Transactional
    public Customer save(Customer customer){
        entityManager.persist(customer);
        return customer;
    }

    public Customer findById(Integer id){
        return entityManager.find(Customer.class , id);
    }

    @Transactional
    public Customer deleteCustomer(Integer id){
        Customer customer = entityManager.find(Customer.class ,id);
        entityManager.remove(customer);
        return customer;
    }


}
