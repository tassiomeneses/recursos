package br.com.recursos.controller;

import br.com.recursos.entity.Pessoa;
import br.com.recursos.entity.Setor;
import br.com.recursos.service.SetorService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.models.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/setor")
public class SetorController {

	@Autowired
	private SetorService setorService;

	@ApiOperation(value="Faz a requisição de todos os dados da tabela Setor")
	@GetMapping("/findAll")
	public List<Setor> findAll() {
		return setorService.findAll();
	}

	@ApiOperation(value = "Salva o setor informado", response = Response.class)
	@ApiResponses({
			@ApiResponse(code = 200, message = "Retorna um pessoa solicitado"),
			@ApiResponse(code = 400, message = "Falha ao processar a solicitação")
	})
	@PostMapping(value = "/")
	public ResponseEntity save(@RequestBody Setor setor) {
		return ResponseEntity.ok(setorService.save(setor));
	}

	@ApiOperation(value = "Atualiza o setor informado", response = Response.class)
	@ApiResponses({
			@ApiResponse(code = 200, message = "Retorna um setor solicitado"),
			@ApiResponse(code = 400, message = "Falha ao processar a solicitação")
	})    @PutMapping(value = "/{id}")
	public ResponseEntity update(@PathVariable("id") Long id, @RequestBody Setor setor) {
		return ResponseEntity.ok(setorService.update(id, setor));
	}

	@ApiOperation(value = "Remove o setor baseado no id informado", response = Response.class)
	@ApiResponses({
			@ApiResponse(code = 200, message = "setor foi removido com sucesso"),
			@ApiResponse(code = 400, message = "Falha ao processar a solicitação")
	})
	@DeleteMapping(value = "/{id}")
	public ResponseEntity deleteById(@PathVariable("id") Long id) {
		setorService.delete(id);
		return ResponseEntity.ok("{ msg : 'Setor removido com sucesso'}");
	}

}