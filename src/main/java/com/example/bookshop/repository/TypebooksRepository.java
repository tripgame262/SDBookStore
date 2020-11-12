package com.example.bookshop.repository;

import com.example.bookshop.model.Customer;
import com.example.bookshop.model.TypeBook;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public class TypebooksRepository {


        @PersistenceContext
        private EntityManager entityManager;

        public List<TypeBook> findAll(){
            Query query = entityManager.createQuery("from TypeBook");
            return query.getResultList();
        }

        @Transactional
        public TypeBook save(TypeBook typebook){
            entityManager.persist(typebook);
            return typebook;
        }

        public TypeBook findById(Integer id){

            return entityManager.find(TypeBook.class , id);
        }

        @Transactional
        public TypeBook deleteTypeBook(Integer id){
            TypeBook typebook = entityManager.find(TypeBook.class ,id);
            entityManager.remove(typebook);
            return typebook;
        }

}
