package com.example.demo.controller;


import com.example.demo.model.Book;
import com.example.demo.service.BooksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Logger;

@RestController
@RequestMapping(value = "/v1/api/lib")
public class BooksController {

    private final static Logger logger = Logger.getLogger("BooksController.class");

    @Autowired
    BooksService booksService;

    public BooksController() {
    }

    @GetMapping("/book")
    private ResponseEntity<List<Book>> getAllBooks() {
        List<Book> books = booksService.getAllBook();

        return new ResponseEntity<>(books, HttpStatus.OK);
    }

    @GetMapping("/book/{bookid}")
    private Book getBooks(@PathVariable("bookid") Long bookid) {
        Book book = booksService.getBooksById(bookid);

        logger.info("getAll!!!!!!!!!!!!!!!" + book.getBookname());
        return book;
    }




    @DeleteMapping("/book/{bookid}")
    private String deleteBook(@PathVariable("bookid") Long bookid) {
       return booksService.deleteBook(bookid);

    }


    @PostMapping("/books")
    private Long saveBook(@RequestBody Book books) {
        booksService.save(books);
        return books.getBookid();
    }


    @PutMapping("/books")
    private Book update(@RequestBody Book books) {
        booksService.updateBook(books);
        return books;
    }
}
