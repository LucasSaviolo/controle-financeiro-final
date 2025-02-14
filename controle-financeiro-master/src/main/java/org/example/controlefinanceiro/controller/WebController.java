package org.example.controlefinanceiro.controller;

import org.example.controlefinanceiro.model.Transacao;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class WebController {

    @GetMapping("/")
    public String home() {
        return "index";
    }

    @GetMapping("/registrar")
    public String registrarUsuario() {
        return "registrar";
    }

    @GetMapping("/login")
    public String loginUsuario() {
        return "login";
    }

    @GetMapping("/transacoes")
    public String listarTransacoes(Model model) {
       List<Transacao> transacoes = new ArrayList<>();
        model.addAttribute("transacoes", transacoes);
        return "transacoes";
    }

    @GetMapping("/nova-transacao")
    public String novaTransacao() {
        return "nova-transacao";
    }
}