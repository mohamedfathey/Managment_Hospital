package com.hospital.Error;

public class DuplicateRecordException extends  RuntimeException {


    public DuplicateRecordException() {
        super();
    }

    public DuplicateRecordException(String message) {
        super(message);
    }
}
