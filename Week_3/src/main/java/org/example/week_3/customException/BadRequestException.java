package org.example.week_3.customException;

public class BadRequestException extends AppException {
    public BadRequestException(String message) {
        super(400, message);
    }
}
