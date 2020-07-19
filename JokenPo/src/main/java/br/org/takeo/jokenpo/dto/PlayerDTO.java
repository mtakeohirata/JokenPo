package br.org.takeo.jokenpo.dto;

import javax.validation.constraints.NotEmpty;

public class PlayerDTO{
	
	
	@NotEmpty(message = "{nome.obrigatorio}")
	private String nome;
	
	public PlayerDTO() {
		// TODO Auto-generated constructor stub
	}
	
	public PlayerDTO(String nome) {
		this.nome = nome;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
}
