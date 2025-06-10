package com.example.demo.exception;

import com.example.demo.dto.ApiResponse;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.support.MetaDataAccessException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.Instant;
import java.util.Map;
import java.util.stream.Collectors;

//????
@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ApiResponse<Object>> handleResourceNotFound(NotFoundException ex,  HttpServletRequest request) {
        ApiResponse<Object> apiResponse = new ApiResponse<>(
                "not_found",
                ex.getMessage(),
                null,
                Map.of(
                        "timestamp", Instant.now(),
                        "path", request.getRequestURI()
                )
        );
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(apiResponse);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiResponse<Object>> handleOtherExceptions(Exception ex,  HttpServletRequest request) {
        ApiResponse<Object> apiResponse = new ApiResponse<>(
                "error",
                ex.getMessage(),
                null,
                Map.of(
                        "timestamp", Instant.now(),
                        "path", request.getRequestURI()
                )
        );
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(apiResponse);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<ApiResponse<String>> handleIllegalArgumentException(IllegalArgumentException ex,  HttpServletRequest request) {
        ApiResponse<String> apiResponse = new ApiResponse<>(
                "error",
                ex.getMessage(),
                null,
                Map.of(
                        "timestamp", Instant.now(),
                        "path", request.getRequestURI()
                )
        );
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(apiResponse);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ApiResponse<String>> handleMetaDataAccessException(MethodArgumentNotValidException ex,  HttpServletRequest request) {
        String errorMessage = ex.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(FieldError::getDefaultMessage)
                .collect(Collectors.joining(", ")); // Gộp thành 1 chuỗi

        ApiResponse<String> apiResponse = new ApiResponse<>(
                "error",
                errorMessage,
                null,
                Map.of(
                        "timestamp", Instant.now(),
                        "path", request.getRequestURI()
                )
        );
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(apiResponse);
    }

    @ExceptionHandler(MetaDataAccessException.class)
    public ResponseEntity<ApiResponse<String>> handleMetaDataAccessException(MetaDataAccessException ex,  HttpServletRequest request) {
        ApiResponse<String> apiResponse = new ApiResponse<>(
                "error",
                ex.getMessage(),
                null,
                Map.of(
                        "timestamp", Instant.now(),
                        "path", request.getRequestURI()
                )
        );
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(apiResponse);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiResponse<String>> handleException(Exception ex,  HttpServletRequest request) {
        ApiResponse<String> apiResponse = new ApiResponse<>(
                "error",
                ex.getMessage(),
                null,
                Map.of(
                        "timestamp", Instant.now(),
                        "path", request.getRequestURI()
                )
        );
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(apiResponse);
    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<ApiResponse<String>> handleRuntimeException(RuntimeException ex,  HttpServletRequest request) {
        ApiResponse<String> apiResponse = new ApiResponse<>(
                "error",
                ex.getMessage(),
                null,
                Map.of(
                        "timestamp", Instant.now(),
                        "path", request.getRequestURI()
                )
        );
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(apiResponse);
    }

    @ExceptionHandler(IllegalStateException.class)
    public ResponseEntity<ApiResponse<String>> handleIllegalStateException(IllegalStateException ex,  HttpServletRequest request) {
        ApiResponse<String> apiResponse = new ApiResponse<>(
                "error",
                ex.getMessage(),
                null,
                Map.of(
                        "timestamp", Instant.now(),
                        "path", request.getRequestURI()
                )
        );
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(apiResponse);
    }
}
