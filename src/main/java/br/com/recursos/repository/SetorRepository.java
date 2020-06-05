package br.com.recursos.repository;

import br.com.recursos.entity.Pessoa;
import br.com.recursos.entity.Setor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SetorRepository extends JpaRepository<Setor, Long> {

    Setor findById(Long id);
}