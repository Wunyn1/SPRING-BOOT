package org.example.week_5.DTO.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.week_5.entity.Book;

import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AuthorReponse {
    private Long id;
    private String name;

    private String email;

    private String phone;

}
