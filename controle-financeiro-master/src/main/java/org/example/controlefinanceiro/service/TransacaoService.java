package org.example.controlefinanceiro.service;

import org.example.controlefinanceiro.model.Transacao;
import org.example.controlefinanceiro.model.Usuario;
import org.example.controlefinanceiro.repository.TransacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TransacaoService {

    private final TransacaoRepository transacaoRepository;

    @Autowired
    public TransacaoService(TransacaoRepository transacaoRepository) {
        this.transacaoRepository = transacaoRepository;
    }

    public Transacao salvarTransacao(Transacao transacao) {
        return transacaoRepository.save(transacao);
    }

    public List<Transacao> listarTransacoes(Usuario usuario) {
        return transacaoRepository.findByUsuario(usuario);
    }

    public void excluirTransacao(Long id) {transacaoRepository.deleteById(id);}

    public Optional<Transacao> buscarPorId(Long id) {
        return transacaoRepository.findById(id);
    }

    public Transacao atualizarTransacao(Long id, Transacao transacaoAtualizada) {
        return transacaoRepository.findById(id).map(transacao -> {
            transacao.setValor(transacaoAtualizada.getValor());
            transacao.setDescricao(transacaoAtualizada.getDescricao());
            transacao.setTipo(transacaoAtualizada.getTipo());
            transacao.setMetaFinanceira(transacaoAtualizada.getMetaFinanceira());
            return transacaoRepository.save(transacao);
        }).orElseThrow(() -> new RuntimeException("Transação não encontrada com ID: " + id));
    }





}
