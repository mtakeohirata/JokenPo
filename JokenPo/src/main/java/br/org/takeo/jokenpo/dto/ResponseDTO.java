package br.org.takeo.jokenpo.dto;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ResponseDTO {

	private String mensagem;
	private List<Object> listObjects = new ArrayList<Object>();

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

	@JsonProperty(value = "descricao")
	public List<Object> getListObjects() {
		return listObjects;
	}

	public void setListObjects(List<Object> listObjects) {
		this.listObjects = listObjects;
	}
}
