package com.bookservice.controller;

import com.bookservice.entity.Book;
import com.bookservice.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookRestController {
    @Autowired
    private BookService bookService;
    @GetMapping("/")
    public List<Book> getListBook(){
        return bookService.getListBook();
    }
    @GetMapping("/{id}")
    public Book getBook(@PathVariable("id") Long id){
        return bookService.getBook(id);
    }

    @PostMapping("/")
    public String addFaculty(@RequestBody Book book){
        try{
            bookService.addBook(book);
            return "Add Success";
        }catch (Exception e){
            return e.getMessage();
        }
    }

    @PutMapping("/{id}")
    public String updateFaculty(@PathVariable("id") Long id, @RequestBody Book book){
        try{
            bookService.updateBook(id, book);
            return "Update Success";
        }catch (Exception e){
            return e.getMessage();
        }
    }

    @DeleteMapping("/{id}")
    public String deleteFaculty(@PathVariable("id") Long id){
        try{
            bookService.deleteBook(id);
            return "Success";
        }catch (Exception e){
            return e.getMessage();
        }
    }

}
