package br.com.rngoes.gestao.api.controller;

import br.com.rngoes.gestao.domain.model.Genero;
import br.com.rngoes.gestao.domain.repository.GeneroRepository;
import br.com.rngoes.gestao.domain.service.RegistroGeneroService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/admin/generos")
public class GeneroController {

    private final RegistroGeneroService registroGeneroService;

    @GetMapping
    public List<Genero> listar() {
        return registroGeneroService.consultar();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Genero adicionar(@Valid @RequestBody Genero genero) {
        return registroGeneroService.salvar(genero);
    }

    @PutMapping("/{generoId}")
    public ResponseEntity<Genero> atualizar (@PathVariable Long generoId, @Valid @RequestBody Genero genero) {
        if (!registroGeneroService.ExisteId(generoId)) {
            ResponseEntity.notFound().build();
        }
        genero.setId(generoId);
        Genero generoAtualizado = registroGeneroService.salvar(genero);
        return ResponseEntity.ok(generoAtualizado);
    }

    @DeleteMapping("/{generoId}")
    public ResponseEntity<Void> remover(@PathVariable Long generoId) {
        if (!registroGeneroService.ExisteId(generoId)) {
            return ResponseEntity.notFound().build();
        }
        registroGeneroService.excluir(generoId);
        return ResponseEntity.noContent().build();
    }
}
