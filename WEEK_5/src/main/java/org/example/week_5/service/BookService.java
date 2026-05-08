package org.example.week_5.service;

import org.example.week_5.DTO.request.CreateAuthorRequest;
import org.example.week_5.DTO.request.CreateBookRequest;
import org.example.week_5.DTO.request.UpdateBookRequest;
import org.example.week_5.DTO.response.BookReponse;
import org.example.week_5.entity.BookCategory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface BookService {
    Page<BookReponse> findAll(Pageable pageable);
    BookReponse findById(Long id);
    BookReponse create(CreateBookRequest createBookRequest);
    BookReponse update(Long id, UpdateBookRequest updateBookRequest);
    void delete(Long id);
    BookReponse borrow(Long id);
    BookReponse returnBook(Long id);
    Page<BookReponse> search(String search, Pageable pageable);
    Page<BookReponse> findByCategory(BookCategory bookCategory, Pageable pageable);
}
