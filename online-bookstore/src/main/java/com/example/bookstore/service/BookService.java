package com.example.bookstore.service;

import com.example.bookstore.model.Book;
import com.example.bookstore.model.Customer;
import com.example.bookstore.repository.BookRepository;
import com.example.bookstore.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private CustomerRepository customerRepository;

    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    public double buyBooks(List<Long> bookIds, String customerId) {
        Customer customer = customerRepository.findById(customerId).orElse(new Customer(customerId, 0));
        List<Book> books = bookRepository.findAllById(bookIds);

        double total = 0;
        for (Book book : books) {
            double price = book.getPrice();
            switch (book.getType()) {
                case "New Release": break;
                case "Regular": price *= (books.size() >= 3 ? 0.9 : 1); break;
                case "Old": price *= (books.size() >= 3 ? 0.75 : 0.8); break;
            }
            total += price;
        }

        customer.setPoints(customer.getPoints() + books.size());
        if (customer.getPoints() >= 10) {
            for (Book book : books) {
                if (!book.getType().equals("New Release")) {
                    total -= book.getPrice();
                    customer.setPoints(0);
                    break;
                }
            }
        }

        customerRepository.save(customer);
        return total;
    }
}
