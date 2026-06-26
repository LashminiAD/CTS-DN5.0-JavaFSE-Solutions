package com.library.service;

import com.library.repository.BookRepository;

public class BookService {

    private BookRepository repository;

    // Constructor Injection
    public BookService(BookRepository repository) {
        this.repository = repository;
        System.out.println("Constructor Injection Done");
    }

    // Setter Injection
    public void setRepository(BookRepository repository) {
        this.repository = repository;
        System.out.println("Setter Injection Done");
    }

    public void display() {
        System.out.println("BookService is using BookRepository");
    }
}