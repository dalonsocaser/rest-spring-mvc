package es.caser.spring.mvc.advice;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;

import es.caser.spring.mvc.exception.UserNotFoundException;
import es.caser.spring.mvc.model.ErrorBean;

@ControllerAdvice
@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE)
public class UserControllerAdvice {
	@ExceptionHandler(UserNotFoundException.class)
	public ResponseEntity<ErrorBean> notFoundException(final UserNotFoundException e) {
		return new ResponseEntity<>(new ErrorBean(e.getCode(),e.getDesc()), HttpStatus.NOT_FOUND);
	}
}
