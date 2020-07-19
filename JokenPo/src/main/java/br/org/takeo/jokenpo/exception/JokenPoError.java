package br.org.takeo.jokenpo.exception;

import java.util.Arrays;
import java.util.List;

public class JokenPoError {

	private List<String> errors;

	public JokenPoError(List<String> errors) {
		this.errors = errors;
	}
	
	public JokenPoError(String error) {
		this.errors = Arrays.asList(error);
	}
	
	
	public List<String> getErrors() {
		return errors;
	}

	public void setErrors(List<String> errors) {
		this.errors = errors;
	}
	
}
