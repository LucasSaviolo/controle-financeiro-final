package org.example.controlefinanceiro.controller;

import org.example.controlefinanceiro.model.MetaFinanceira;
import org.example.controlefinanceiro.model.Usuario;
import org.example.controlefinanceiro.service.MetaFinanceiraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/metas")
public class MetaFinanceiraController {
    @Autowired
    private MetaFinanceiraService metaFinanceiraService;

    @PostMapping
    public MetaFinanceira criarMeta(@RequestBody MetaFinanceira meta) {
        return metaFinanceiraService.salvarMeta(meta);
    }

    @GetMapping("/{usuarioId}")
    public List<MetaFinanceira> listarMetas(@PathVariable Long usuarioId) {
        Usuario usuario = new Usuario();
        usuario.setId(usuarioId);
        return metaFinanceiraService.listarMetas(usuario);
    }
}
