package br.org.takeo.jokenpo.rest.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import br.org.takeo.jokenpo.dto.JogadaDTO;
import br.org.takeo.jokenpo.dto.PlayerDTO;
import br.org.takeo.jokenpo.enums.TipoJogadaEnum;
import br.org.takeo.jokenpo.utils.IntegerUtils;
import br.org.takeo.jokenpo.vo.PlayerVO;

@Service
public class JogoService {

	private List<PlayerVO> players = new ArrayList<PlayerVO>();

	public PlayerVO salvaPlayer(PlayerDTO player){
		int codigo = 0;
		if (!this.players.isEmpty()) {
			codigo = geraCodigoPlayer();
		}
		
		PlayerVO playerAdicionadoVO = new PlayerVO(codigo, player);
		this.players.add(playerAdicionadoVO);
		
		return playerAdicionadoVO;
	}

	private int geraCodigoPlayer() {
		PlayerVO ultimo = this.players.get(this.players.size() -1);
		
		return ultimo.getCodigo() + 1;
	}
	
	public List<PlayerVO> consultaTodosPlayers(){
		if (this.players.isEmpty()) {
			throw new ResponseStatusException(HttpStatus.NO_CONTENT, "Não foi encontrado players");
		}else {
			return this.players;
		}
	} 
	
	
	public PlayerVO consultaPlayerCodigo(int codigo) {
		return this.players.stream()
				.filter(p -> p.getCodigo() == codigo)
				.findFirst()
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Player não encontrado"));
	}
	
	public void deletaPlayerCodigo(int codigo) {
		PlayerVO playerEncontrado = consultaPlayerCodigo(codigo);
		this.players.remove(playerEncontrado);
	}
	
	public PlayerVO realizaJogada(JogadaDTO jogadaDTO) {
		validaJogada(jogadaDTO);
		
		PlayerVO playerVO = new PlayerVO();
		TipoJogadaEnum jogadaEnum = TipoJogadaEnum.obtemJogadaPorCodigo(jogadaDTO.getCodigoJogada());
		
		playerVO = this.players.stream()
		.filter(p -> p.getCodigo() == jogadaDTO.getCodigoPlayer())
		.findFirst()
		.map(p -> 
				{
					p.setJogada(jogadaEnum);
					return p;
				}
			).get();
		
		return playerVO;
	}

	private void validaJogada(JogadaDTO jogadaDTO) {
		if (!IntegerUtils.between(jogadaDTO.getCodigoJogada(), 1, 5)) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Escolha uma jogada entre 1 e 5");
		}
		
		consultaPlayerCodigo(jogadaDTO.getCodigoPlayer());
	}

	public PlayerVO deletaJogada(int codigoPlayer) {
		consultaPlayerCodigo(codigoPlayer);
		
		PlayerVO playerVO = this.players.stream()
		.filter(p -> p.getCodigo() == codigoPlayer)
		.findFirst()
		.map(p -> 
				{
					p.setJogada(null);
					return p;
				}
			)
		.get();
		
		return playerVO;
	}
	
	public List<PlayerDTO> jogar(){
		List<PlayerDTO> playersVencedores = new ArrayList<PlayerDTO>();
		
		//Implementar RN de jogo
		
		return playersVencedores;
	}
	
}
