package com.bookservice.service;

import com.bookservice.entity.Book;
import com.bookservice.repository.BookRepository;
import io.github.resilience4j.ratelimiter.RequestNotPermitted;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
@Service
@Slf4j
public class BookImpl implements BookService{
    @Autowired
    private BookRepository bookRepository;
    @Override
    public List<Book> getListBook() {
        return bookRepository.findAll();
    }

    @Override
    public void updateBook(Long id, Book book) {
        book.setId(id);
        bookRepository.save(book);
    }

    @Override
    public void addBook(Book book) {
        bookRepository.save(book);
    }

    @Override

    @RateLimiter(name = "basic", fallbackMethod = "fallMethodRateLimiter")

    public Book getBook(Long id) {
        log.info(LocalDateTime.now() + "IN GET FACULTY BY ID");
        return bookRepository.findById(id).get();
    }

    @Override
    public void deleteBook(Long id) {
        bookRepository.deleteById(id);

    }
    public Book fallMethodRateLimiter(int id, RequestNotPermitted rnp) {
        log.info("Request Not Permitted By Many Request");
        return null;
    }
}
