package org.example.service.equipamento;

import org.example.model.Equipamento;

import java.sql.SQLException;

public interface EquipamentoService {

    Equipamento criarEquipamento(Equipamento equipamento) throws SQLException;

    Equipamento buscarEquipamentoporId(Long id) throws SQLException;

}
