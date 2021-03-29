package com.upgrad.quora.api.exception;
 feature/answer-api
import org.springframework.web.bind.annotation.ControllerAdvice;
master
import com.upgrad.quora.api.model.ErrorResponse;
import com.upgrad.quora.service.exception.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
feature/answer-api
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

//@ControllerAdvice is an annotation provided by Spring allowing you to write global code that can be applied to a wide range of controllers
@ControllerAdvice
public class RestExceptionHandler {

    @ExceptionHandler(AnswerNotFoundException.class)
    public ResponseEntity<ErrorResponse> answerNotFoundException(
            AnswerNotFoundException exception, WebRequest request) {

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class RestExceptionHandler {

    @ExceptionHandler(InvalidQuestionException.class)
    public ResponseEntity<ErrorResponse> invalidQuestionException(
            InvalidQuestionException exception, WebRequest request) {
master
        return new ResponseEntity<ErrorResponse>(
                new ErrorResponse().code(exception.getCode()).message(exception.getErrorMessage()),
                HttpStatus.NOT_FOUND);
    }
feature/answer-api

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<ErrorResponse> userNotFoundException(UserNotFoundException exception, WebRequest request) {
        return new ResponseEntity<ErrorResponse>(
                new ErrorResponse().code(exception.getCode()).message(exception.getErrorMessage()), HttpStatus.NOT_FOUND
        );
    }

    @ExceptionHandler(AuthorizationFailedException.class)
    public ResponseEntity<ErrorResponse> authorizationFailedException(AuthorizationFailedException exception, WebRequest request) {
        return new ResponseEntity<ErrorResponse>(
                new ErrorResponse().code(exception.getCode()).message(exception.getErrorMessage()), HttpStatus.FORBIDDEN
        );
    }

    @ExceptionHandler(SignUpRestrictedException.class)
    public ResponseEntity<ErrorResponse> signUpRestrictionException(SignUpRestrictedException exception, WebRequest request) {
        return new ResponseEntity<ErrorResponse>(
                new ErrorResponse().code(exception.getCode()).message(exception.getErrorMessage()), HttpStatus.CONFLICT
        );
    }

    @ExceptionHandler(AuthenticationFailedException.class)
    public ResponseEntity<ErrorResponse> authorizationFailedException(AuthenticationFailedException exception, WebRequest request) {
        return new ResponseEntity<ErrorResponse>(
                new ErrorResponse().code(exception.getCode()).message(exception.getErrorMessage()), HttpStatus.UNAUTHORIZED
        );
    }

    @ExceptionHandler(SignOutRestrictedException.class)
    public ResponseEntity<ErrorResponse> signOutRestrictedException(SignOutRestrictedException exception, WebRequest request){
        return new ResponseEntity<ErrorResponse>(
                new ErrorResponse().code(exception.getCode()).message(exception.getErrorMessage()), HttpStatus.UNAUTHORIZED
        );
    }

master
}
