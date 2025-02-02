package br.com.lucassousa.backend.controller;

import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class ExceptionHandlerController {
    @ExceptionHandler(JobInstanceAlreadyCompleteException.class)
    private ResponseEntity<Object> handleFileAlreadyImported(
            JobInstanceAlreadyCompleteException exception) {
                return ResponseEntity.status(HttpStatus.CONFLICT).body(
                        "O arquivo informado já foi importado no sistema");
    }
}
