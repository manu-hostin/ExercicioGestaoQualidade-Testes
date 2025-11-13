package org.example.service.equipamento;

import org.example.model.Equipamento;
import org.example.repository.EquipamentoRepositoryImpl;

import java.sql.SQLException;

public class EquipamentoServiceImpl implements EquipamentoService {

    @Override
    public Equipamento criarEquipamento(Equipamento equipamento) throws SQLException {
        var repo = new EquipamentoRepositoryImpl();

        if(equipamento.getNome().isEmpty() || equipamento.getNome() == null){
            throw new RuntimeException();
        }

        repo.criarEquipamento(equipamento);
        return equipamento;
    }
    @Override
    public Equipamento buscarEquipamentoporId(Long id) throws SQLException {
        var repo = new EquipamentoRepositoryImpl();

        return repo.buscarEquipamentoPorId(id);

    }
}