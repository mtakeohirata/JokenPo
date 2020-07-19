package br.org.takeo.jokenpo.enums;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public enum TipoJogadaEnum {
	
	PEDRA 	(1, "PEDRA"),
	PAPEL 	(2, "PAPEL"),
	TESOURA (3, "Tesoura"),
	LAGARTO (4, "Lagarto"),
	SPOCK	(5, "Spock");
	

	private int codigo;
	private String descricao;
	
	private TipoJogadaEnum(int codigo, String descricao) {
		this.setCodigo(codigo);
		this.setDescricao(descricao);
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public static TipoJogadaEnum obtemJogadaPorCodigo(int codigoJogada) {
		return Stream.of(TipoJogadaEnum.values())
				.filter(t -> t.getCodigo() == codigoJogada)
				.findFirst()
				.get();
	}
	
	public static List<TipoJogadaEnum> obtemJogadaVencedora(List<TipoJogadaEnum> listJogadas){
		List<TipoJogadaEnum> listGanhadora = new ArrayList<TipoJogadaEnum>();
		
		for (TipoJogadaEnum jogada : listJogadas) {
			for (TipoJogadaEnum tipoJogadaEnum : TipoJogadaEnum.values()) {
				
			}
		}
		
		return listGanhadora;
	}
	
	
}
