package com.example.bookshop.model;

import javax.persistence.*;
import java.util.Date;

@Entity
public class BookOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Temporal(value = TemporalType.DATE)
    private Date date;
    private Integer bookRefId;
    private Integer customerRefId;
    @OneToOne
    @JoinColumn(name = "book_id")
    private Book book;
    @OneToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Integer getBookRefId() {
        return bookRefId;
    }

    public void setBookRefId(Integer bookRefId) {
        this.bookRefId = bookRefId;
    }

    public Integer getCustomerRefId() {
        return customerRefId;
    }

    public void setCustomerRefId(Integer customerRefId) {
        this.customerRefId = customerRefId;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
