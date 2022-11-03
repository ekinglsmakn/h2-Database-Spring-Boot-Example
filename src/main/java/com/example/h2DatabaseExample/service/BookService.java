package com.example.h2DatabaseExample.service;

import com.example.h2DatabaseExample.model.dto.BookDto;

import java.util.List;

public interface BookService {
    public void saveBook(BookDto bookDto);
    public void deleteBook(BookDto bookDto);
    public BookDto updateBook(BookDto bookDto);
    public List<BookDto> findAllBook();
}
