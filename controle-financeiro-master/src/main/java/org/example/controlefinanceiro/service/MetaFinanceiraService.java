package org.example.controlefinanceiro.service;

import org.example.controlefinanceiro.model.MetaFinanceira;
import org.example.controlefinanceiro.model.Usuario;
import org.example.controlefinanceiro.repository.MetaFinanceiraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
}
