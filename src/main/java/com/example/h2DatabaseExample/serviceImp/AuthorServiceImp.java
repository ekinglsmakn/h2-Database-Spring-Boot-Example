package com.example.h2DatabaseExample.serviceImp;

import com.example.h2DatabaseExample.configuration.ModelMapperCustom;
import com.example.h2DatabaseExample.model.dto.AuthorDto;
import com.example.h2DatabaseExample.model.entity.Author;
import com.example.h2DatabaseExample.repository.AuthorRepo;
import com.example.h2DatabaseExample.service.AuthorService;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class AuthorServiceImp implements AuthorService {
    @Autowired
    private AuthorRepo authorRepo;

    @Autowired
    private ModelMapperCustom modelMapper;

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void saveAuthor(AuthorDto authorDto) {
        this.authorRepo.save(modelMapper.map(authorDto, Author.class));
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void deleteAuthor(AuthorDto authorDto) {
       this.authorRepo.deleteById(authorDto.getId());
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public AuthorDto updateAuthor(AuthorDto authorDto) {
        Optional<Author> optionalAuthor = this.authorRepo.findById(authorDto.getId());
        Author author = new Author();
        if(optionalAuthor.isPresent()){
            author.setName(authorDto.getName());
            author.setSurname(authorDto.getSurname());
            this.authorRepo.save(author);
        }

        return modelMapper.map(author,AuthorDto.class);
    }

    @Transactional(readOnly = true)
    @Override
    public List<AuthorDto> findAllAuthor() {
        return modelMapper.map(this.authorRepo.findAll(),new TypeToken<List<AuthorDto>>(){}.getType());
    }
}
