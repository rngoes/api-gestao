package br.com.rngoes.gestao.domain.service;

import br.com.rngoes.gestao.domain.exception.NegocioException;
import br.com.rngoes.gestao.domain.model.Organizacao;
import br.com.rngoes.gestao.domain.repository.OrganizacaoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@AllArgsConstructor
@Service
public class RegistroOrganizacaoService {

    private OrganizacaoRepository organizacaoRepository;

    public List<Organizacao> consultar () {
        return organizacaoRepository.findAll();
    }

    public boolean existeId (Long id) {
        return organizacaoRepository.existsById(id);
    }

    @Transactional
    public Organizacao salvar (Organizacao organizacao) {
        boolean existeDescricao = organizacaoRepository.findByDescricao(organizacao.getDescricao()).filter(o -> !o.equals(organizacao)).isPresent();

        if (existeDescricao) {
            throw new NegocioException("Organização já cadastrada.");
        }

        return organizacaoRepository.save(organizacao);
    }

    @Transactional
    public void excluir (Long organizacaoId) {
        organizacaoRepository.deleteById(organizacaoId);
    }
}
