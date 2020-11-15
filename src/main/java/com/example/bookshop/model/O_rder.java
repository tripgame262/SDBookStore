package com.example.bookshop.model;

import javax.persistence.*;
import java.util.Date;

@Entity
public class O_rder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer Order_id;
    Date D_ate;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "book_id")
        Book book;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "customer_id")
    Customer customer;

    public Integer getOrder_id() {
        return Order_id;
    }

    public void setOrder_id(Integer order_id) {
        Order_id = order_id;
    }


    public Book getBook() {
        return book;
    }

    public Date getD_ate() {
        return D_ate;
    }

    public void setD_ate(Date d_ate) {
        D_ate = d_ate;
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
