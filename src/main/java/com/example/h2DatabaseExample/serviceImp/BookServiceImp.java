package com.example.h2DatabaseExample.serviceImp;

import com.example.h2DatabaseExample.configuration.ModelMapperCustom;
import com.example.h2DatabaseExample.model.dto.BookDto;
import com.example.h2DatabaseExample.model.entity.Book;
import com.example.h2DatabaseExample.repository.BookRepo;
import com.example.h2DatabaseExample.service.BookService;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImp implements BookService {

    @Autowired
    private BookRepo bookRepo;

    @Autowired
    private ModelMapperCustom modelMapper;

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void saveBook(BookDto bookDto) {
        Book book = modelMapper.map(bookDto,Book.class);
        this.bookRepo.save(book);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void deleteBook(BookDto bookDto) {
        this.bookRepo.deleteById(bookDto.getId());
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public BookDto updateBook(BookDto bookDto) {
        //bookDto'nun id'sine gore donen nesnenin null olup olmama ihtimaline karsi "optional" kullanilir
       Optional<Book> bookOptional = this.bookRepo.findById(bookDto.getId());
       Book book = new Book();

       if(bookOptional.isPresent()){
           book = bookOptional.get(); //If a value is present in this Optional, returns the value, otherwise throws NoSuchElementException
           book.setName(bookDto.getName());
           book.setType(bookDto.getType());
           book.setAuthor(bookDto.getAuthor());
           this.bookRepo.save(book);
       }
       return modelMapper.map(book,BookDto.class);
    }

    @Transactional(readOnly = true)
    @Override
    public List<BookDto> findAllBook() {
        List<BookDto> bookDto = modelMapper.map(this.bookRepo.findAll(), new TypeToken<List<BookDto>>(){}.getType());
        return bookDto;
    }
}
