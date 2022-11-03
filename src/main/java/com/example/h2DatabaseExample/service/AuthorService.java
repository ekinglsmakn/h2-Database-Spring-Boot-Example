package com.example.h2DatabaseExample.service;

import com.example.h2DatabaseExample.model.dto.AuthorDto;
import java.util.List;

public interface AuthorService {
    public void saveAuthor(AuthorDto authorDto);
    public void deleteAuthor(AuthorDto authorDto);
    public AuthorDto updateAuthor(AuthorDto authorDto);
    public List<AuthorDto> findAllAuthor();
}
