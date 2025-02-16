package org.example.controlefinanceiro.repository;

import org.example.controlefinanceiro.model.Categoria;
import org.example.controlefinanceiro.model.MetaFinanceira;
import org.example.controlefinanceiro.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Long> {

    List<Categoria> findByUsuario(Usuario usuario);
}