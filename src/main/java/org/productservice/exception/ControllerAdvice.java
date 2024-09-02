package org.productservice.exception;

import org.productservice.dtos.ExceptionDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

@org.springframework.web.bind.annotation.ControllerAdvice
public class ControllerAdvice {

    @ExceptionHandler(NotFoundException.class)
    private ResponseEntity<ExceptionDto> handledNotFoundException(NotFoundException notFoundException){
        return new ResponseEntity(
                new ExceptionDto(HttpStatus.NOT_FOUND,notFoundException.getMessage()),
                HttpStatus.NOT_FOUND
        );
    }

    @ExceptionHandler(ArrayIndexOutOfBoundsException.class)
    private ResponseEntity<ExceptionDto> handledNotFoundException(ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException){
        return new ResponseEntity(
                new ExceptionDto(HttpStatus.NOT_FOUND,arrayIndexOutOfBoundsException.getMessage()),
                HttpStatus.NOT_FOUND
        );
    }
}
