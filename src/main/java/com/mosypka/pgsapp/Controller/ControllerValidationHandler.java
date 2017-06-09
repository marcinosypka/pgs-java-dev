package com.mosypka.pgsapp.Controller;

import com.mosypka.pgsapp.DTO.ErrorMessageDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by marcin on 09.06.2017.
 */
@ControllerAdvice
public class ControllerValidationHandler {

    @ExceptionHandler(org.springframework.web.bind.MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ResponseEntity processValidationError(MethodArgumentNotValidException ex) {

        FieldError error = ex.getBindingResult().getFieldError();
        ErrorMessageDTO errorMessageDTO = new ErrorMessageDTO(error.getField() + ": " + error.getDefaultMessage());
        return ResponseEntity.badRequest().body(errorMessageDTO);
    }
}
