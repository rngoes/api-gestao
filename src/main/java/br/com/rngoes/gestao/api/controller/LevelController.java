package br.com.rngoes.gestao.api.controller;

import br.com.rngoes.gestao.domain.model.Level;
import br.com.rngoes.gestao.domain.service.RegistroLevelService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/admin/levels")
public class LevelController {

    private RegistroLevelService registroLevelService;

    @GetMapping
    public List<Level> consultar () {
        return registroLevelService.consultar();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Level adicionar (@Valid @RequestBody Level level) {
        return registroLevelService.salvar(level);
    }

    @PutMapping("/{levelId}")
    public ResponseEntity<Level> atualizar (@PathVariable Long levelId, @Valid @RequestBody Level level) {
        if (!registroLevelService.existeId(levelId)) {
            return ResponseEntity.notFound().build();
        }
        level.setId(levelId);
        Level levelAtualizado = registroLevelService.salvar(level);
        return ResponseEntity.ok(levelAtualizado);
    }

    @DeleteMapping("/{levelId}")
    public ResponseEntity<Void> remover (@PathVariable Long levelId) {
        if (!registroLevelService.existeId(levelId)) {
            return ResponseEntity.notFound().build();
        }
        registroLevelService.excluir(levelId);
        return ResponseEntity.noContent().build();
    }

}
