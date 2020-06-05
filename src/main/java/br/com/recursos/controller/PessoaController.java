package br.com.recursos.controller;

import br.com.recursos.entity.Pessoa;
import br.com.recursos.service.PessoaService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.models.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pessoa")
public class PessoaController {

    @Autowired
    private PessoaService pessoaService;

    @ApiOperation(value="Faz a requisição de todos os dados da tabela pessoa")
    @GetMapping("/findAll")
    public List<Pessoa> findAll() {
        return pessoaService.findAll();
    }

    @ApiOperation(value = "Salva a pessoa informada", response = Response.class)
    @ApiResponses({
            @ApiResponse(code = 200, message = "Retorna um pessoa solicitado"),
            @ApiResponse(code = 400, message = "Falha ao processar a solicitação")
    })
    @PostMapping(value = "/")
    public ResponseEntity save(@RequestBody Pessoa pessoa) {
        return ResponseEntity.ok(pessoaService.save(pessoa));
    }

    @ApiOperation(value = "Atualiza a pessoa informada", response = Response.class)
    @ApiResponses({
            @ApiResponse(code = 200, message = "Retorna um pessoa solicitado"),
            @ApiResponse(code = 400, message = "Falha ao processar a solicitação")
    })    @PutMapping(value = "/{id}")
    public ResponseEntity update(@PathVariable("id") Long id, @RequestBody Pessoa pessoa) {
        return ResponseEntity.ok(pessoaService.update(id, pessoa));
    }

    @ApiOperation(value = "Remove a pessoa baseado no id informado", response = Response.class)
    @ApiResponses({
            @ApiResponse(code = 200, message = "pessoa foi removido com sucesso"),
            @ApiResponse(code = 400, message = "Falha ao processar a solicitação")
    })
    @DeleteMapping(value = "/{id}")
    public ResponseEntity deleteById(@PathVariable("id") Long id) {
        pessoaService.delete(id);
        return ResponseEntity.ok("{ msg : 'Pessoa removida com sucesso'}");
    }

    @ApiOperation(value="Consumir dados MockApi.")
    @GetMapping("/mockapi")
    public ResponseEntity mockapi() throws Exception {
        pessoaService.mockapi();
        return ResponseEntity.ok("{ msg : 'Carga mockapi feita.'}");
    }

}