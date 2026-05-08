package org.example.week_5.DTO.request;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import org.example.week_5.entity.Author;
import org.example.week_5.entity.BookCategory;
import org.example.week_5.entity.BookStatus;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Data
public class CreateBookRequest {

    @NotBlank(message = "tieu de khong duocn de trong")
    @Size(min = 2, max = 200, message = "tieu de phai tu 2-200 ki tu")
    @Column(nullable = false, length = 200)
    private String title;

    @NotBlank(message = "isbn khong duoc de trong")
    @Column(nullable = false, unique = true)
    private String isbn;

    @NotNull(message = "the loai khong duoc de trong")
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private BookCategory category;

    @NotNull(message = "trang thai khong duoc de trong")
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private BookStatus status = BookStatus.AVAILABLE ;

    @NotNull(message = "so luong ban sao khong duoc de trong")
    @Size(min = 1, message = "so luong ban sao phai >= 1")
    @Column(nullable = false)
    private Integer totalCopies;

    @NotNull(message = "so luong ban sao co san khong duoc de trong")
    @Size(min = 1, message = "so luong ban sao co san phai >= 0")
    @Column(nullable = false)
    private Integer availableCopies;

    @Column(nullable = true)
    private Integer publishedYear;

    @NotNull(message = "tac gia khong duoc de trong")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "author_id", nullable = false)
    private Author author;

    @CreationTimestamp
    private LocalDateTime createdAt;



}
