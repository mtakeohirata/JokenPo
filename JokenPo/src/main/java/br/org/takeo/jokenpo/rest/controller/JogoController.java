package br.org.takeo.jokenpo.rest.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.org.takeo.jokenpo.dto.JogadaDTO;
import br.org.takeo.jokenpo.dto.PlayerDTO;
import br.org.takeo.jokenpo.dto.ResponseDTO;
import br.org.takeo.jokenpo.rest.service.JogoService;

@RestController
@RequestMapping("/api")
public class JogoController {

	private JogoService jogoService = new JogoService();
	
	private final String URL_BASE_PLAYER = "/player";
	private final String URL_BASE_JOGADA = "/jogada";
	
	
	@PostMapping(URL_BASE_PLAYER +"/salva")
	@ResponseStatus(code = HttpStatus.CREATED)
	public ResponseDTO salvaPlayer(@RequestBody @Valid PlayerDTO player){
		ResponseDTO dto = new ResponseDTO();
		dto.getListObjects().add(jogoService.salvaPlayer(player));
		dto.setMensagem("Player salvo com sucesso!");
		return dto;
	}
	
	@DeleteMapping(URL_BASE_PLAYER + "/deleta/{codigo}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public ResponseDTO deletaPlayerCodigo(@PathVariable int codigo) {
		ResponseDTO dto = new ResponseDTO();
		jogoService.deletaPlayerCodigo(codigo);
		dto.setMensagem("Player deletado com sucesso!");
		
		return dto;
		
	}
	
	@GetMapping(URL_BASE_PLAYER + "/consulta")
	public ResponseDTO consultaTodosPlayers(){
		ResponseDTO dto = new ResponseDTO();
		
		jogoService.consultaTodosPlayers()
		.forEach(p -> dto.getListObjects().add(p));
		
		dto.setMensagem("Consulta realizada com sucesso");
		
		return dto;
		
	};
	
	@GetMapping(URL_BASE_PLAYER + "/consulta/{codigo}")
	public ResponseDTO consultaPlayerCodigo(@PathVariable int codigo ){
		ResponseDTO dto = new ResponseDTO();
		dto.getListObjects().add(jogoService.consultaPlayerCodigo(codigo));
		dto.setMensagem("Consulta realizada com sucesso");
		return dto; 
	};
	
	@PostMapping(URL_BASE_JOGADA + "/realiza")
	@ResponseStatus(code = HttpStatus.CREATED)
	public ResponseDTO realizaJogada(@RequestBody @Valid JogadaDTO jogadaDTO) {
		ResponseDTO dto = new ResponseDTO();
		dto.getListObjects().add(jogoService.realizaJogada(jogadaDTO));
		dto.setMensagem("Jogada realizada com sucesso");
		
		return dto;
	}
	
	@PutMapping(URL_BASE_JOGADA + "/deleta/{id1}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public ResponseDTO deletaJogada(@PathVariable(name="id1") int codigoJogada) {
		ResponseDTO dto = new ResponseDTO();
		dto.getListObjects().add(jogoService.deletaJogada(codigoJogada));
		dto.setMensagem("Jogada removida com sucesso");
		
		return dto;
	}
	
	@GetMapping("/jogar")
	public ResponseDTO jogar (){
		ResponseDTO dto = new ResponseDTO();
		dto.getListObjects().add(jogoService.jogar());
		return dto;
		
	}

}
