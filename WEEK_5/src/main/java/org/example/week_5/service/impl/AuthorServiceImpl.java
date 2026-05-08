package org.example.week_5.service.impl;

import org.example.week_5.DTO.request.CreateAuthorRequest;
import org.example.week_5.DTO.request.UpdateAuthorRequest;
import org.example.week_5.DTO.response.AuthorReponse;
import org.example.week_5.DTO.response.BookReponse;
import org.example.week_5.entity.Author;
import org.example.week_5.entity.Book;
import org.example.week_5.repository.AuthorRepository;
import org.example.week_5.repository.BookRepository;
import org.example.week_5.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class AuthorServiceImpl implements AuthorService {
    @Autowired
    private AuthorRepository authorRepo;

    @Autowired
    private BookRepository bookRepo;

    @Override
    public Page<AuthorReponse> findAll(Pageable pageable) {
        Page<Author> authors = authorRepo.findAll(pageable);
        return authors.map(author -> mapToAuthorResponse(author));
    }

    @Override
    public AuthorReponse findById(Long id) {
        Author author = authorRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("khong tim thay tac gia nao co id la "+id));
        return mapToAuthorResponse(author);
    }

    @Override
    public AuthorReponse create(CreateAuthorRequest createAuthorRequest) {
        Author author = new Author();
        author.setName(createAuthorRequest.getName());
        author.setPhone(createAuthorRequest.getPhone());
        author.setEmail(createAuthorRequest.getEmail());

        Author saveAuthor = authorRepo.save(author);
        return mapToAuthorResponse(saveAuthor);
    }

    @Override
    public AuthorReponse update(Long id, UpdateAuthorRequest updateAuthorRequest) {
        Author author = authorRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("khong tim thay tac gia co id la "+id));
        author.setName(updateAuthorRequest.getName());
        author.setPhone(updateAuthorRequest.getPhone());
        author.setEmail(updateAuthorRequest.getEmail());
        return mapToAuthorResponse(author);
    }

    @Override
    public void delete(Long id) {
        Author author = authorRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("khong tim thay tac gia co id la "+id));
        authorRepo.delete(author);
    }

    @Override
    public Page<BookReponse> findBooksByAuthor(Long id, Pageable pageable) {
        Author authorById = authorRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("khong tim thay tac gia co id la "+id));
        Book book = new Book();
        Author author = new Author();
        author.setId(id);
        book.setAuthor(author);

        Example<Book> example = Example.of(book);
        Page<Book> books = bookRepo.findAll(example, pageable);
        return books.map(b -> mapToBookResponse(b));
    }


    //hàm để mapping dữ liệu entity <-> dto
    private AuthorReponse mapToAuthorResponse(Author author){
        AuthorReponse response = new AuthorReponse();
        response.setId(author.getId());
        response.setName(author.getName());
        response.setPhone(author.getPhone());
        response.setEmail(author.getEmail());
        return response;
    }
    private BookReponse mapToBookResponse(Book book){
        BookReponse response = new BookReponse();
        response.setId(book.getId());
        response.setIsbn(book.getIsbn());
        response.setAuthor(book.getAuthor());
        response.setCategory(book.getCategory());
        response.setStatus(book.getStatus());
        response.setPublishedYear(book.getPublishedYear());
        response.setAvailableCopies(book.getAvailableCopies());
        response.setTotalCopies(book.getTotalCopies());
        return response;
    }
}
