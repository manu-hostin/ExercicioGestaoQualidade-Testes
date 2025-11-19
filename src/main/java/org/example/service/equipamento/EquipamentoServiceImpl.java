package org.example.service.equipamento;

import com.sun.source.tree.NewArrayTree;
import org.example.model.Equipamento;
import org.example.repository.EquipamentoRepositoryImpl;

import java.sql.SQLException;

public class EquipamentoServiceImpl implements EquipamentoService {

    @Override
    public Equipamento criarEquipamento (Equipamento equipamento) throws SQLException {
        var repo = new EquipamentoRepositoryImpl();

        equipamento.setStatusOperacional("OPERACIONAL");

        if (equipamento.getNome().isEmpty() || equipamento.getNome() == null){
            throw new RuntimeException();
        }

        equipamento = repo.criarEquipamento(equipamento);

        if (equipamento.getId() == null) {
            throw new RuntimeException("Ocorreu um erro.");
        }
        return equipamento;
    }
    @Override
    public Equipamento buscarEquipamentoPorId (Long id) throws SQLException {
        var repo = new EquipamentoRepositoryImpl();

        Equipamento equipamento = repo.buscarEquipamentoPorId(id);

        if (equipamento == null) {
            throw new RuntimeException ("Equipamento não encontrado!");
        }
        return equipamento;

    }
}