package br.com.rngoes.gestao.domain.repository;

import br.com.rngoes.gestao.domain.model.Organizacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface OrganizacaoRepository extends JpaRepository<Organizacao, Long> {

    Optional<Organizacao> findByDescricao(String descricao);

}
