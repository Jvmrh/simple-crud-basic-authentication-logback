package com.example.demo.service;

import com.example.demo.model.Book;
import com.example.demo.repository.BooksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.ResourceBundle;

@Service
public class BooksService {
    ResourceBundle resourceBundle = ResourceBundle.getBundle("errorMessage");

    @Autowired
    BooksRepository booksRepository;

    public BooksService() {
    }

    public List<Book> getAllBook() {
        return booksRepository.findAll();
    }

    public Book getBooksById(Long id) {
        return booksRepository.findById(id).get();
    }

    public void save(Book book) {
        booksRepository.save(book);
    }

    public String deleteBook(Long id) {
        if (booksRepository.findById(id).isPresent()) {
            booksRepository.deleteById(id);
            return resourceBundle.getString("message.successful");
        } else {
            return resourceBundle.getString("error.message.bookNotFound");
        }
    }

    public Book updateBook(Book book) {

        booksRepository.findById(book.getBookid());

        return booksRepository.save(book);

    }

}