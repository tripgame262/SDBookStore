package com.example.bookshop.controller;

import com.example.bookshop.model.Book;
import com.example.bookshop.model.BookOrder;
import com.example.bookshop.model.Customer;
import com.example.bookshop.repository.BookOrderRepository;
import com.example.bookshop.repository.BookRepository;
import com.example.bookshop.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.List;

@RestController
@RequestMapping("/api/bookorder")
public class BookOrderController {
    @Autowired
    private BookOrderRepository bookOrderRepository;
    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private CustomerRepository customerRepository;

    @GetMapping("/showall")
    public List<BookOrder> showAll(){
        return bookOrderRepository.showAll();
    }

    @PostMapping("/create")
    public BookOrder create(@RequestBody BookOrder bookOrder){
        Book book = bookRepository.findById(bookOrder.getBookRefId());
        book.setStatus(false);
        Customer customer = customerRepository.findById(bookOrder.getCustomerRefId());
        bookOrder.setBook(book);
        bookOrder.setCustomer(customer);
        bookOrderRepository.save(bookOrder);
        return bookOrder;
    }


}
