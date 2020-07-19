package br.org.takeo.jokenpo.enums;

import java.util.stream.Stream;

public enum TipoJogadaEnum {
	
	PEDRA 	(1, "PEDRA"){
		@Override
		public boolean ganha(TipoJogadaEnum jogada) {
			return jogada == TipoJogadaEnum.LAGARTO || jogada == TipoJogadaEnum.TESOURA;
		}

		@Override
		public boolean perde(TipoJogadaEnum jogada) {
			return jogada == TipoJogadaEnum.SPOCK || jogada == TipoJogadaEnum.PAPEL;
		}
	},
	PAPEL 	(2, "PAPEL"){
		@Override
		public boolean ganha(TipoJogadaEnum jogada) {
			return jogada == TipoJogadaEnum.PEDRA || jogada == TipoJogadaEnum.SPOCK;
		}

		@Override
		public boolean perde(TipoJogadaEnum jogada) {
			return jogada == TipoJogadaEnum.TESOURA || jogada == TipoJogadaEnum.LAGARTO;
		}
	},
	TESOURA (3, "Tesoura"){
		@Override
		public boolean ganha(TipoJogadaEnum jogada) {
			return jogada == TipoJogadaEnum.LAGARTO || jogada == TipoJogadaEnum.PAPEL;
		}

		@Override
		public boolean perde(TipoJogadaEnum jogada) {
			return jogada == TipoJogadaEnum.SPOCK || jogada == TipoJogadaEnum.PEDRA;
		}

	},
	LAGARTO (4, "Lagarto"){
		@Override
		public boolean ganha(TipoJogadaEnum jogada) {
			return jogada == TipoJogadaEnum.SPOCK || jogada == TipoJogadaEnum.PAPEL;
		}

		@Override
		public boolean perde(TipoJogadaEnum jogada) {
			return jogada == TipoJogadaEnum.TESOURA || jogada == TipoJogadaEnum.PEDRA;
		}
	},
	SPOCK	(5, "Spock"){
		@Override
		public boolean ganha(TipoJogadaEnum jogada) {
			return jogada == TipoJogadaEnum.TESOURA || jogada == TipoJogadaEnum.PEDRA;
		}

		@Override
		public boolean perde(TipoJogadaEnum jogada) {
			return jogada == TipoJogadaEnum.LAGARTO || jogada == TipoJogadaEnum.PAPEL;
		}
	};
	

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
	
	public abstract boolean ganha(TipoJogadaEnum jogada);

	public abstract boolean perde(TipoJogadaEnum jogada);
	
	
}
