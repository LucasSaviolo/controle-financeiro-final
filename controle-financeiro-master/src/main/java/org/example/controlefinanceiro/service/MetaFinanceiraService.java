package org.example.controlefinanceiro.service;

import org.example.controlefinanceiro.model.MetaFinanceira;
import org.example.controlefinanceiro.model.Transacao;
import org.example.controlefinanceiro.model.Usuario;
import org.example.controlefinanceiro.repository.MetaFinanceiraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MetaFinanceiraService {
    private final MetaFinanceiraRepository metaFinanceiraRepository;

    @Autowired
    public MetaFinanceiraService(MetaFinanceiraRepository metaFinanceiraRepository) {
        this.metaFinanceiraRepository = metaFinanceiraRepository;
    }
    public MetaFinanceira salvarMeta(MetaFinanceira meta) {
        return metaFinanceiraRepository.save(meta);
    }

    public List<MetaFinanceira> listarMetas(Usuario usuario) {
        return metaFinanceiraRepository.findByUsuario(usuario);
    }

    public void excluirMeta(Long id) {metaFinanceiraRepository.deleteById(id);}

    public Optional<MetaFinanceira> buscarPorId(Long id) {
        return metaFinanceiraRepository.findById(id);
    }

    public MetaFinanceira atualizarMeta(Long id, MetaFinanceira metaAtualizada) {
        return metaFinanceiraRepository.findById(id).map(meta -> {
            meta.setTipo(metaAtualizada.getTipo());
            meta.setValor(metaAtualizada.getValor());
            meta.setPrazo(metaAtualizada.getPrazo());
            return metaFinanceiraRepository.save(meta);
        }).orElseThrow(() -> new RuntimeException("Meta não encontrada com ID: " + id));
    }
}
