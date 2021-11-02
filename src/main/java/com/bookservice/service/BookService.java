package com.bookservice.service;

import com.bookservice.entity.Book;

import java.util.List;

public interface BookService {

    List<Book> getListBook();

    void updateBook(Long id, Book book);

    void addBook(Book book);

    Book getBook(Long id);

    void deleteBook(Long id);
}
