package org.shvedovva.exceptions;

public class DatabaseException extends RuntimeException{
    public DatabaseException(String error) {
        super(error);
    }
}
