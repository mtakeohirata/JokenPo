package br.org.takeo.jokenpo.rest.controller.advice;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.server.ResponseStatusException;

import br.org.takeo.jokenpo.exception.JokenPoError;

@RestControllerAdvice
public class ApplicationControllerAdvice {

	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	public JokenPoError handleValidationExceptio(MethodArgumentNotValidException e) {
		BindingResult r = e.getBindingResult();
		
		List<String> listError = r.getAllErrors()
				.stream()
				.map(error -> error.getDefaultMessage())
				.collect(Collectors.toList());
		JokenPoError error = new JokenPoError(listError);
		
		return error;
	}
	
	@ExceptionHandler(ResponseStatusException.class)
	public ResponseEntity handleResponseStatusException(ResponseStatusException e){
		String msgErro = e.getMessage();
		HttpStatus codigoErro = e.getStatus();
		
		JokenPoError jokenPoException = new JokenPoError(msgErro);
		
		return new ResponseEntity(jokenPoException, codigoErro);
	}
	
	
}
