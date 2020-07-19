package br.org.takeo.jokenpo.dto;

import javax.validation.constraints.NotNull;

public class JogadaDTO{
	
	@NotNull(message = "{codigo.jogada.obrigatorio}")
	private int codigoJogada;
	
	@NotNull(message = "{codigo.player.obrigatorio}")
	private int codigoPlayer;
	
	public JogadaDTO() {
		// TODO Auto-generated constructor stub
	}

	public int getCodigoJogada() {
		return codigoJogada;
	}

	public void setCodigoJogada(int codigoJogada) {
		this.codigoJogada = codigoJogada;
	}

	public int getCodigoPlayer() {
		return codigoPlayer;
	}

	public void setCodigoPlayer(int codigoPlayer) {
		this.codigoPlayer = codigoPlayer;
	}
}
