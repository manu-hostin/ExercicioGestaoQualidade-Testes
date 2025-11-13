package org.example.repository;

import org.example.model.Falha;

import java.sql.SQLException;
import java.util.List;

public interface FalhaRepository {

    Falha buscarIDExistente(Long id) throws SQLException;

    List<Falha> buscarFalhasCriticasAbertas() throws SQLException ;

    Falha registrarNovaFalha(Falha falha) throws SQLException;

    void atualizarStatusFalha(String status, Long id) throws SQLException;
}
