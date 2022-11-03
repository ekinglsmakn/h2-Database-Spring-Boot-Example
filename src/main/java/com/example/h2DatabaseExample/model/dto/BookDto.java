package com.example.h2DatabaseExample.model.dto;

import com.example.h2DatabaseExample.model.entity.Author;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookDto {
    private Long id;
    private String name;
    private String type;
    private Author author;
}
