package org.example.week_5.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "author")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "ten khong duoc de trong")
    @Size(min = 2, max = 100, message = "ten phai tu 2-100 ki tu")
    @Column(nullable = false, length = 100)
    private String name;

    @Email(message = "email khong hop le")
    @NotBlank(message = "email khong duoc de trong")
    @Column(nullable = false, unique = true)
    private String email;

    @NotBlank(message = "sdt khong duoc de trong")
    @Size(min = 10, max = 10, message = "sdt phai gom 10 ki tu")
    @Column(length = 10)
    private String phone;

    @CreationTimestamp
    @Column(updatable = false)
    private LocalDateTime createdAt;

    @UpdateTimestamp
    private LocalDateTime updateAt;

    @OneToMany
    private List<Book> books;
}
