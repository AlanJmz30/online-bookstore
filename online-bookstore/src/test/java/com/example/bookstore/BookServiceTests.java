package com.example.bookstore;

import com.example.bookstore.model.Book;
import com.example.bookstore.repository.BookRepository;
import com.example.bookstore.service.BookService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class BookServiceTests {

    @Autowired
    private BookService bookService;

    @Autowired
    private BookRepository bookRepository;

    @Test
    public void testBuyBooks() {
        Book book = new Book();
        book.setId(1L);
        book.setTitle("Test Book");
        book.setType("Regular");
        book.setPrice(100);
        bookRepository.save(book);

        double total = bookService.buyBooks(Collections.singletonList(1L), "user123");
        assertTrue(total > 0);
    }
}
