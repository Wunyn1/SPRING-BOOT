package org.example.week_5.service;

import org.example.week_5.DTO.request.CreateAuthorRequest;
import org.example.week_5.DTO.request.UpdateAuthorRequest;
import org.example.week_5.DTO.response.AuthorReponse;
import org.example.week_5.DTO.response.BookReponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface AuthorService {
    Page<AuthorReponse> findAll(Pageable pageable);
    AuthorReponse findById(Long id);
    AuthorReponse create(CreateAuthorRequest createAuthorRequest);
    AuthorReponse update(Long id, UpdateAuthorRequest updateAuthorRequest);
    void delete(Long id);
    Page<BookReponse> findBooksByAuthor(Long id, Pageable pageable);
}
