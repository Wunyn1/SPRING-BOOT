package org.example.week_3.model;

import lombok.*;

import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    private Long id;
    private String studentCode;
    private String name;
    private String email;
    private String phone;
    private LocalDate dateOfBirth;
    private Double gpa;
    private String major;
    private Integer year;

}
