package br.com.rngoes.gestao.domain.service;

import br.com.rngoes.gestao.domain.exception.NegocioException;
import br.com.rngoes.gestao.domain.model.Genero;
import br.com.rngoes.gestao.domain.repository.GeneroRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@AllArgsConstructor
@Service
public class RegistroGeneroService {

    private final GeneroRepository generoRepository;

    public List<Genero> consultar() {
        return generoRepository.findAll();
    }

    public boolean ExisteId(Long id) {
        return generoRepository.existsById(id);
    }

    @Transactional
    public Genero salvar (Genero genero) {
        boolean existeDescricao = generoRepository.findByDescricao(genero.getDescricao())
                .filter(g -> !g.equals(genero)).isPresent();

        if (existeDescricao) {
            throw new NegocioException("Gênero já cadastrado.");
        }
        return generoRepository.save(genero);
    }

    @Transactional
    public void excluir(Long generoId) {
        generoRepository.deleteById(generoId);
    }
}
