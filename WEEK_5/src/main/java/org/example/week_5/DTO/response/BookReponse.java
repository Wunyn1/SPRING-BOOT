package org.example.week_5.DTO.response;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.week_5.entity.Author;
import org.example.week_5.entity.BookCategory;
import org.example.week_5.entity.BookStatus;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookReponse {
    private Long id;
    private String title;

    private String isbn;

    private BookCategory category;

    private BookStatus status = BookStatus.AVAILABLE ;

    private Integer publishedYear;

    private Author author;

    private Integer totalCopies;

    private Integer availableCopies;
}
