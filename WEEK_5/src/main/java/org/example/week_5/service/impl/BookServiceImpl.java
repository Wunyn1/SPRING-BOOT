package org.example.week_5.service.impl;

import org.example.week_5.DTO.request.CreateBookRequest;
import org.example.week_5.DTO.request.UpdateBookRequest;
import org.example.week_5.DTO.response.BookReponse;
import org.example.week_5.entity.Book;
import org.example.week_5.entity.BookCategory;
import org.example.week_5.repository.BookRepository;
import org.example.week_5.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookRepository bookRepo;

    @Override
    public Page<BookReponse> findAll(Pageable pageable) {
        Page<Book> books = bookRepo.findAll(pageable);
        return books.map(book -> mapToBookResponse(book));
    }

    @Override
    public BookReponse findById(Long id) {
        Book book = bookRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("khong tim thay sach nao co id la "+id));
        return mapToBookResponse(book);
    }

    @Override
    public BookReponse create(CreateBookRequest createBookRequest) {
        Book book = new Book();
        book.setTitle(createBookRequest.getTitle());
        book.setIsbn(createBookRequest.getIsbn());
        book.setCategory(createBookRequest.getCategory());
        book.setStatus(createBookRequest.getStatus());
        book.setAuthor(createBookRequest.getAuthor());
        book.setPublishedYear(createBookRequest.getPublishedYear());
        book.setAvailableCopies(createBookRequest.getAvailableCopies());
        book.setTotalCopies(createBookRequest.getTotalCopies());

        Book saveBook = bookRepo.save(book);
        return mapToBookResponse(saveBook);
    }

    @Override
    public BookReponse update(Long id, UpdateBookRequest updateBookRequest) {
        Book book = bookRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("khong tim thay sach nao co id la "+id));
        book.setTitle(updateBookRequest.getTitle());
        book.setIsbn(updateBookRequest.getIsbn());
        book.setCategory(updateBookRequest.getCategory());
        book.setStatus(updateBookRequest.getStatus());
        book.setAuthor(updateBookRequest.getAuthor());
        book.setPublishedYear(updateBookRequest.getPublishedYear());
        book.setAvailableCopies(updateBookRequest.getAvailableCopies());
        book.setTotalCopies(updateBookRequest.getTotalCopies());
        return mapToBookResponse(book);
    }

    @Override
    public void delete(Long id) {
        Book book = bookRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("khong tim thay sach nao co id la "+id));
        bookRepo.delete(book);
    }

    @Override
    public BookReponse borrow(Long id) {
        Book book = bookRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("khong tim thay sach nao co id la "+id));
        if(book.getAvailableCopies() <= 0){
            throw new RuntimeException("sach nay hien khong co san");
        }
        book.setAvailableCopies(book.getAvailableCopies() - 1);
        Book update = bookRepo.save(book);
        return mapToBookResponse(update);
    }

    @Override
    public BookReponse returnBook(Long id) {
        Book book = bookRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("khong tim thay sach nao co id la "+id));
        book.setAvailableCopies(book.getAvailableCopies() + 1);
        Book update = bookRepo.save(book);
        return mapToBookResponse(update);
    }

    @Override
    public Page<BookReponse> search(String search, Pageable pageable) {
        
        return null;
    }

    @Override
    public Page<BookReponse> findByCategory(BookCategory bookCategory, Pageable pageable) {
        return null;
    }

    private BookReponse mapToBookResponse(Book book){
        BookReponse response = new BookReponse();
        response.setId(book.getId());
        response.setIsbn(book.getIsbn());
        response.setTitle(book.getTitle());
        response.setCategory(book.getCategory());
        response.setStatus(book.getStatus());
        response.setAuthor(book.getAuthor());
        response.setPublishedYear(book.getPublishedYear());
        response.setAvailableCopies(book.getAvailableCopies());
        response.setTotalCopies(book.getTotalCopies());
        return response;
    }

}
