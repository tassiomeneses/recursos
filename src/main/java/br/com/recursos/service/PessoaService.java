package br.com.recursos.service;


import br.com.recursos.entity.EmployerDTO;
import br.com.recursos.entity.Pessoa;
import br.com.recursos.entity.Setor;
import br.com.recursos.repository.PessoaRepository;
import br.com.recursos.repository.SetorRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import javassist.bytecode.AttributeInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.*;


@Service
public class PessoaService {

    @Autowired
    private PessoaRepository repository;

    @Autowired
    private SetorRepository setorRepository;

    public List<Pessoa> findAll() {
        return repository.findAll();
    }

    public Pessoa save(Pessoa pessoa) {
        return repository.save(pessoa);
    }

    public void delete(Long id) {
        repository.delete(id);
    }

    public Pessoa update(Long id, Pessoa entity) {
        Pessoa pessoa = Optional.ofNullable(repository.findById(id)).orElseThrow(() -> new RuntimeException("Pessoa não encontrada."));
        pessoa.setFirstName(Optional.ofNullable(entity.getFirstName()).orElse(pessoa.getFirstName()));
        pessoa.setLastName(Optional.ofNullable(entity.getLastName()).orElse(pessoa.getLastName()));
        return repository.save(pessoa);
    }

    public void mockapi() throws Exception {
        try {
            RestTemplate template = new RestTemplate();
            final String baseUrl = "https://5e61af346f5c7900149bc5b3.mockapi.io/desafio03/employer";
            //System.getenv("URL_AUTH_SERVER");

            String response = template.getForObject(baseUrl, String.class);
            ObjectMapper objectMapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            JsonNode jsonNode = null;

            try {
                jsonNode = objectMapper.readTree(response);
                List<EmployerDTO> employerDTOList = objectMapper.readValue(String.valueOf(jsonNode), objectMapper.getTypeFactory().constructCollectionType(List.class, EmployerDTO.class));

                employerDTOList.stream().forEach(employerDTO -> {
                    Setor setor = new Setor();
                    setor.setCareer(employerDTO.getCareer());
                    setor.setDepartament(employerDTO.getDepartament());
                    setor = setorRepository.save(setor);

                    Pessoa pessoa = new Pessoa();
                    pessoa.setFirstName(employerDTO.getFirst_name());
                    pessoa.setLastName(employerDTO.getLast_name());
                    pessoa.setSetorList(Arrays.asList(setor));
                    repository.save(pessoa);
                });

            } catch (JsonProcessingException e) {
                throw new Exception("Não foi possível fornecer acesso.");
            }

        } catch (URISyntaxException e) {
            throw new Exception("Não foi possível fornecer acesso.");
        } catch (HttpClientErrorException e) {
            throw new Exception("Não foi possível fornecer acesso.");
        }
    }
}
