package org.example.week_4.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserRequest {
    @NotBlank(message = "ten khong duoc de trong")
    private String name;

    @Email(message = "email khong hop le")
    private String email;

    @Min(value = 18, message = "phai tren 18 tuoi")
    private int age;
}
