package com.example.h2DatabaseExample.controller;

import com.example.h2DatabaseExample.model.dto.AuthorDto;
import com.example.h2DatabaseExample.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class AuthorController {
    @Autowired
    private AuthorService authorService;

    @RequestMapping(value = "/saveauthor",method = RequestMethod.POST)
    public void saveAuthor(@RequestBody AuthorDto authorDto){
        this.authorService.saveAuthor(authorDto);
    }
}
