package com.example.bookshop.controller;

import com.example.bookshop.model.Book;
import com.example.bookshop.model.TypeBook;
import com.example.bookshop.repository.BookRepository;
import com.example.bookshop.repository.TypeBookRepository;
import com.example.bookshop.service.TypeBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/book")
public class BookController {
    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private TypeBookService typeBookService;

    @GetMapping("/showall")
    public List<Book> showAll(){
        return bookRepository.showAll();
    }

    @PostMapping("/create")
    public Book create(@RequestBody Book book){
        TypeBook typeBook = typeBookService.get(book.getTypeId());
        book.setTypeBook(typeBook);
        return bookRepository.save(book);
    }
}
