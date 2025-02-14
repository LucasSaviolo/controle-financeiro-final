package org.example.controlefinanceiro.controller;

import org.example.controlefinanceiro.model.Relatorio;
import org.example.controlefinanceiro.service.RelatorioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/relatorios")
public class RelatorioController {

    @Autowired
    private RelatorioService relatorioService;

    @PostMapping
    public ResponseEntity<Relatorio> gerarRelatorio(@RequestBody Relatorio relatorio) {
        Relatorio novoRelatorio = relatorioService.gerarRelatorio(relatorio);
        return ResponseEntity.ok(novoRelatorio);
    }

    @PostMapping("/{id}/exportar")
    public ResponseEntity<byte[]> exportarPDF(@PathVariable Long id) {
        Optional<Relatorio> relatorio = relatorioService.buscarPorId(id);
        if (relatorio.isPresent()) {
            try {
                byte[] pdf = relatorioService.exportarPDF(relatorio.get());
                HttpHeaders headers = new HttpHeaders();
                headers.setContentType(MediaType.APPLICATION_PDF);
                headers.setContentDispositionFormData("filename", "relatorio.pdf");
                return ResponseEntity.ok().headers(headers).body(pdf);
            } catch (IOException e) {
                return ResponseEntity.status(500).build();
            }
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping
    public ResponseEntity<List<Relatorio>> listar() {
        List<Relatorio> relatorios = relatorioService.listar();
        return ResponseEntity.ok(relatorios);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Relatorio>> buscarPorId(@PathVariable Long id) {
        Optional<Relatorio> relatorio = relatorioService.buscarPorId(id);
        return ResponseEntity.ok(relatorio);
    }
}