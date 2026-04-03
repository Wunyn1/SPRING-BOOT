package org.example.week_3.customException;

public class DuplicateResourceException extends AppException {

    public DuplicateResourceException(String resource, String field, Object value) {
        super(409, String.format("%s đ tồn tại với %s: '%s'", resource, field, value));
    }
}
