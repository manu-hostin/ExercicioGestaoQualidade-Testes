package org.example.repository;

import org.example.model.Equipamento;

import java.sql.SQLException;
import java.util.List;

public interface EquipamentoRepository {

    Equipamento criarEquipamento(Equipamento equipamento) throws SQLException;

    Equipamento buscarEquipamentoPorId(long id) throws SQLException;


    void atualizarStatusEquipamento(String status, Long id) throws SQLException;

    List<Equipamento> buscarEquipamentos() throws SQLException;
}

