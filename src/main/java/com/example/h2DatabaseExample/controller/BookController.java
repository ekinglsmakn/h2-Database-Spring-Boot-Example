package com.example.h2DatabaseExample.controller;

import com.example.h2DatabaseExample.model.dto.BookDto;
import com.example.h2DatabaseExample.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class BookController {

    @Autowired
    private BookService bookService;

    @RequestMapping(value = "/savebook",method = RequestMethod.POST)
    public void saveBook(@RequestBody BookDto bookDto){
        this.bookService.saveBook(bookDto);
    }

    @RequestMapping(value = "/updatebook",method = RequestMethod.PUT)
    public void updateBook(@RequestBody BookDto bookDto){
        this.bookService.updateBook(bookDto);
    }
}
