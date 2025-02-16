package org.example.controlefinanceiro.controller;

import org.example.controlefinanceiro.model.Transacao;
import org.example.controlefinanceiro.model.Usuario;

import org.example.controlefinanceiro.service.TransacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/transacoes")
public class TransacaoController {
    @Autowired
    private TransacaoService transacaoService;

    @PostMapping("cadastro")
    public Transacao registrarTransacao(@RequestBody Transacao transacao) {
        return transacaoService.salvarTransacao(transacao);
    }

    @GetMapping("listar/{usuarioId}")
    public List<Transacao> listarTransacoes(@PathVariable Long usuarioId) {
        Usuario usuario = new Usuario();
        usuario.setId(usuarioId);
        return transacaoService.listarTransacoes(usuario);
    }

    @DeleteMapping("excluir/{id}")
    public void excluirTransacao(@PathVariable Long id) {
        transacaoService.excluirTransacao(id);
    }

    @PutMapping("atualizar/{id}")
    public Transacao atualizarTransacao(@PathVariable Long id, @RequestBody Transacao transacao) {
        return transacaoService.atualizarTransacao(id, transacao);
    }

    @GetMapping("{id}")
    public Transacao buscarTransacaoPorId(@PathVariable Long id) {
        return transacaoService.buscarPorId(id)
                .orElseThrow(() -> new RuntimeException("Transação não encontrada com ID: " + id));
    }


}

