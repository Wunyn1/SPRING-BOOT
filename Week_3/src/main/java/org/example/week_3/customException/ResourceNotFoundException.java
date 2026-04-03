package org.example.week_3.customException;

public class ResourceNotFoundException extends AppException {

    public ResourceNotFoundException(String resource, String field, Object value) {
        super(404, String.format("%s khooong tìm thấy với %s: '%s'", resource,field, value ));
    }
}
