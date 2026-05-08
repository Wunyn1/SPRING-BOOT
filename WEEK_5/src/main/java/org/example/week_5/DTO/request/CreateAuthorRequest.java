package org.example.week_5.DTO.request;

import jakarta.persistence.Column;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Data
public class CreateAuthorRequest {
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
}
