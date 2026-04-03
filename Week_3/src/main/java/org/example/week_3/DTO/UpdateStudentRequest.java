package org.example.week_3.DTO;

import jakarta.validation.constraints.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class UpdateStudentRequest {
        @NotBlank(message = "tên sinh viên không được để trống")
        @Size(min = 2, max = 100,message = "teen sinh viên phải từ 2-100 kí tự")
        private String name;

        @NotBlank(message = "email không được để trống")
        @Email(message = "email không đúng định dạng")
        private String email;

        @NotBlank(message = "số điện thoại không đuọược để trống")
        @Pattern(regexp = "^0\\d{9}$", message = "số điện thoại phải bắt đầu từ 0 và gồm 10 số")
        private String phone;

        @NotNull(message = "ngày sinh không được để trống")
        @Past(message = "ngày sinh phải là một ngày trong quá khứ")
        private LocalDate dateOfBirth;

        @NotNull(message = "gpa không được để trống")
        @DecimalMin(value = "0.0", message = "gpa tối thiểu là 0.0")
        @DecimalMax(value = "4.0", message = "gpa tối đa là 4.0")
        private Double gpa;

        @NotBlank(message = "ngành học không được để trống")
        private String major;

        @NotNull(message = "năm học không được để trống")
        @Min(value = 1, message = "năm học tối thiểu là 1")
        @Max(value = 6, message = "năm học tối đa là 6")
        private Integer year;


}
