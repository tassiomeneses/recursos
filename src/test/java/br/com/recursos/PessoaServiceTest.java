package br.com.recursos;

import br.com.recursos.controller.PessoaController;
import br.com.recursos.entity.Pessoa;
import br.com.recursos.service.PessoaService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
//@SpringBootTest
@WebMvcTest(PessoaController.class)
public class PessoaServiceTest {

    @Autowired
    private
    PessoaService pessoaService;

    @Test
    public void testAdicionarPessoa() {
        Pessoa pessoa = new Pessoa();
        pessoa.setFirstName("Teste");
        this.pessoaService.save(pessoa);
    }
}
