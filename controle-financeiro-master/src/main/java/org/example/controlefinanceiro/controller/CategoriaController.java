package org.example.controlefinanceiro.controller;

import org.example.controlefinanceiro.model.Categoria;
import org.example.controlefinanceiro.model.Usuario;
import org.example.controlefinanceiro.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {

    @Autowired
    private CategoriaService categoriaService;

    @PostMapping("cadastrar")
    public ResponseEntity<Categoria> cadastrar(@RequestBody Categoria categoria) {
        Categoria novaCategoria = categoriaService.cadastrar(categoria);
        return ResponseEntity.ok(novaCategoria);
    }

    @PutMapping("atualizar/{id}")
    public ResponseEntity<Categoria> editar(@PathVariable Long id, @RequestBody Categoria categoria) {
        categoria.setId(id);
        Categoria categoriaEditada = categoriaService.editar(categoria);
        return ResponseEntity.ok(categoriaEditada);
    }

    @DeleteMapping("excluir/{id}")
    public ResponseEntity<Void> excluir(@PathVariable Long id) {
        categoriaService.excluir(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("listar/{usuarioId}")
    public List<Categoria> listarCategorias(@PathVariable Long usuarioId) {
        Usuario usuario = new Usuario();
        usuario.setId(usuarioId);
        return categoriaService.listarCategorias(usuario);
    }

    @GetMapping("/{id}")
    public Categoria buscarPorId(@PathVariable Long id) {
        return categoriaService.buscarPorId(id)
        .orElseThrow(() -> new RuntimeException("Categoria não encontrada com ID: " + id));
    }
}