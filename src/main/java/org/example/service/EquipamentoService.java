package org.example.service;

import org.example.model.Equipamento;
import org.example.repository.EquipamentoRepository;

import java.sql.SQLException;

public class EquipamentoService {


    public static Equipamento criarEquipamento (Equipamento equipamento) throws SQLException {
        var repo = new EquipamentoRepository();

        return repo.criarEquipamento(equipamento);
    }
    public static Equipamento buscarEquipamentoPorID (Long id) throws SQLException{
        var repo = new EquipamentoRepository();

        return repo.buscarEquipamentoPorId(id);
    }

}