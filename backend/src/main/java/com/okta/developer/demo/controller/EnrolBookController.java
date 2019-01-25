package com.okta.developer.demo.controller;

import com.okta.developer.demo.entity.*;
import com.okta.developer.demo.repository.*;
import java.util.Collection;
import java.util.stream.Collectors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class EnrolBookController {
    @Autowired
    private BooksRepository  bookRepository;
    @Autowired
    private AuthorRepository authorRepository;
    @Autowired
    private BookTypeRepository booktypeRepository;
    @Autowired
    private BookcaseRepository bookcaseRepository;

    @GetMapping("/book")
    public Collection<Book> book() {
        return bookRepository.findAll().stream().collect(Collectors.toList());
    }

    
    @GetMapping("/bookcase")
    public Collection<Bookcase> bookcase() {
        return bookcaseRepository.findAll().stream().collect(Collectors.toList());
    }
    
    @GetMapping("/booktype")
    public Collection<BookType> booktype() {
        return booktypeRepository.findAll().stream().collect(Collectors.toList());
    }
    
    @GetMapping("/author")
    public Collection<Author> author() {
        return authorRepository.findAll().stream().collect(Collectors.toList());
    }
    @PostMapping(path = "/Books/{bookname}/{quantity}/{authorname}/{booktype}/{bookcase}")
  public Book book(@PathVariable String bookname ,@PathVariable String quantity ,
                       @PathVariable String authorname , @PathVariable long booktype ,
                       @PathVariable long bookcase){

    Author authors = new Author();
    authors.setAuthorname(authorname);
    authorRepository.save(authors); 

    Book book = new Book();
    book.setName(bookname);
    book.setQuantity(quantity);
    book.setAuthor(authors);
 

    BookType booktypes = booktypeRepository.findById(booktype).get();
    Bookcase bookcases = bookcaseRepository.findById(bookcase).get();
    booktypes.setBookType(booktype);
    bookcases.setBookcase(bookcase);
 
    book.setBookType(booktypes);
    book.setBookcase(bookcases);

    bookRepository.save(book);
    return  book;
                       }
  
}
