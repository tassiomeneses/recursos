package br.com.recursos.service;


import br.com.recursos.entity.Pessoa;
import br.com.recursos.entity.Setor;
import br.com.recursos.repository.SetorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class SetorService {

    @Autowired
    private SetorRepository repository;

    public List<Setor> findAll() {
        return repository.findAll();
    }

    public Setor save(Setor setor) {
        return repository.save(setor);
    }

    public Setor update(Long id, Setor entity) {
        Setor setor = Optional.ofNullable(repository.findById(id)).orElseThrow(() -> new RuntimeException("Setor não encontrada."));
        setor.setCareer(Optional.ofNullable(entity.getCareer()).orElse(setor.getCareer()));
        setor.setDepartament(Optional.ofNullable(entity.getDepartament()).orElse(setor.getDepartament()));
        return repository.save(setor);
    }

    public void delete(Long id) {
        repository.delete(id);
    }

}
