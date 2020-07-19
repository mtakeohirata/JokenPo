package br.org.takeo.jokenpo.vo;

import br.org.takeo.jokenpo.dto.PlayerDTO;
import br.org.takeo.jokenpo.enums.TipoJogadaEnum;
import br.org.takeo.jokenpo.enums.TipoStatusPlayerEnum;

public class PlayerVO{
	private int codigo;
	private String nome;
	private TipoJogadaEnum jogada;
	private TipoStatusPlayerEnum status;
	
	public PlayerVO() {}
	
	public PlayerVO(int codigo, PlayerDTO player, TipoStatusPlayerEnum status) {
		this.codigo = codigo;
		this.nome = player.getNome();
		this.status = status;
	}

	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public TipoJogadaEnum getJogada() {
		return jogada;
	}
	public void setJogada(TipoJogadaEnum jogada) {
		this.jogada = jogada;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + codigo;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PlayerVO other = (PlayerVO) obj;
		if (codigo != other.codigo)
			return false;
		return true;
	}

	public TipoStatusPlayerEnum getStatus() {
		return status;
	}

	public void setStatus(TipoStatusPlayerEnum status) {
		this.status = status;
	}
	
}
