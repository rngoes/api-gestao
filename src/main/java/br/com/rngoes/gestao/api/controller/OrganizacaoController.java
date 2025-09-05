package br.com.rngoes.gestao.api.controller;

import br.com.rngoes.gestao.domain.model.Organizacao;
import br.com.rngoes.gestao.domain.service.RegistroOrganizacaoService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/admin/organizacoes")
public class OrganizacaoController {

    private RegistroOrganizacaoService registroOrganizacaoService;

    @GetMapping
    public List<Organizacao> consultar () {
        return registroOrganizacaoService.consultar();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Organizacao adicionar (@Valid @RequestBody Organizacao organizacao) {
        return registroOrganizacaoService.salvar(organizacao);
    }

    @PutMapping("/{organizacaoId}")
    public ResponseEntity<Organizacao> atualizar (@PathVariable Long organizacaoId, @Valid @RequestBody Organizacao organizacao) {
        if (!registroOrganizacaoService.existeId(organizacaoId)) {
            return ResponseEntity.notFound().build();
        }
        organizacao.setId(organizacaoId);
        Organizacao organizacaoAtualizado = registroOrganizacaoService.salvar(organizacao);
        return ResponseEntity.ok(organizacaoAtualizado);
    }

    @DeleteMapping("/{organizacaoId}")
    public ResponseEntity<Void> remover (@PathVariable Long organizacaoId) {
        if (!registroOrganizacaoService.existeId(organizacaoId)) {
            return ResponseEntity.notFound().build();
        }
        registroOrganizacaoService.excluir(organizacaoId);
        return ResponseEntity.noContent().build();
    }

}
