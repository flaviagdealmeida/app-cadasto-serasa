package br.com.app_cadastro.exception.handler;

import java.time.OffsetDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

import br.com.app_cadastro.exception.ExceptionResponse;

@ControllerAdvice
@RestController
public class ManipuladorGlobalDeExceptions {
	
	public final ResponseEntity<ExceptionResponse>
	invalidJwtAuthenticationException(Exception ex, WebRequest request){
		
		ExceptionResponse exceptionResponse = 
				new ExceptionResponse(
						 OffsetDateTime.now(), 
						ex.getMessage(), 
						request.getDescription(false));
		
		return new ResponseEntity<>(exceptionResponse, HttpStatus.BAD_REQUEST);
	}
	

}
