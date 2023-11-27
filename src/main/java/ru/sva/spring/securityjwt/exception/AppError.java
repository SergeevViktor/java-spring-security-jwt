package ru.sva.spring.securityjwt.exception;

public class AppError extends RuntimeException {
    public AppError(String message) {
        super(message);
    }
}
