package br.com.rngoes.gestao.domain.service;

import br.com.rngoes.gestao.domain.exception.NegocioException;
import br.com.rngoes.gestao.domain.model.Level;
import br.com.rngoes.gestao.domain.repository.LevelRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@AllArgsConstructor
@Service
public class RegistroLevelService {

    private LevelRepository levelRepository;

    public List<Level> consultar () {
        return levelRepository.findAll();
    }

    public boolean existeId (Long id) {
        return levelRepository.existsById(id);
    }

    @Transactional
    public Level salvar (Level level) {
        boolean existeDescricao = levelRepository.findByDescricao(level.getDescricao())
                .filter(l -> !l.equals(level)).isPresent();

        if (existeDescricao) {
            throw new NegocioException("Level já cadastrado.");
        }
        return levelRepository.save(level);
    }

    @Transactional
    public void excluir(Long levelId) {
        levelRepository.deleteById(levelId);
    }

}
