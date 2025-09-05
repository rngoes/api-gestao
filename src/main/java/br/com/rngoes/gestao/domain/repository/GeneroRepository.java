package br.com.rngoes.gestao.domain.repository;

import br.com.rngoes.gestao.domain.model.Genero;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface GeneroRepository extends JpaRepository<Genero, Long> {

    Optional<Genero> findByDescricao(String descricao);

}
