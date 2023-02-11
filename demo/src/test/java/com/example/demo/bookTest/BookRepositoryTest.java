package com.example.demo.bookTest;

import com.example.demo.model.Book;
import com.example.demo.repository.BooksRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import java.util.List;


@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class BookRepositoryTest {
    @Autowired
    private BooksRepository booksRepository;

    @Test
    public void saveBookTest() {
        Book book = new Book();
        book.setBookname("divan hafez");
        book.setAuthor("hafez");
        book.setPrice(1000);
        booksRepository.save(book);
        Assertions.assertThat(book.getBookid()).isGreaterThan(0);
    }

    @Test
    public void getBook() {
        Book book = booksRepository.findById(1L).get();
        Assertions.assertThat(book.getBookid()).isEqualTo(1);
    }

    @Test
    public void getListOfBook() {
        List<Book> books = booksRepository.findAll();
        Assertions.assertThat(books.size()).isGreaterThan(0);
    }

    @Test
    public void updateBook() {
        Book book = booksRepository.findById(1L).get();
        book.setAuthor("saadi");
        Book bookUpdated = booksRepository.save(book);
        Assertions.assertThat(bookUpdated.getAuthor()).isEqualTo("saadi");
    }

    @Test
    public void deleteBook() {
        Book book = booksRepository.findById(1L).get();
        booksRepository.delete(book);
        Book book1 = booksRepository.findByAuthor("saadi");
        Assertions.assertThat(book1).isNull();
    }
}

