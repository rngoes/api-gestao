package br.com.rngoes.gestao.domain.repository;

import br.com.rngoes.gestao.domain.model.Level;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LevelRepository extends JpaRepository<Level, Long> {

    Optional<Level> findByDescricao(String descricao);

}
