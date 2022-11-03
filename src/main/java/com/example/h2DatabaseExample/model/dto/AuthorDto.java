package com.example.h2DatabaseExample.model.dto;

import com.example.h2DatabaseExample.model.entity.Book;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class AuthorDto {
    private Long id;
    private String name;
    private String Surname;
    private List<Book> bookList;
}
