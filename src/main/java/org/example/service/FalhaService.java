package org.example.service;

import org.example.model.Equipamento;
import org.example.model.Falha;
import org.example.repository.EquipamentoRepository;
import org.example.repository.FalhaRepository;

import java.sql.SQLException;
import java.util.List;

public class FalhaService {

    Falha registrarNovaFalha(Falha falha) throws SQLException {
        var repository = new FalhaRepository();
        var repoEq = new EquipamentoRepository();
        var eq = repoEq.buscarEquipamentoPorId(falha.getEquipamentoId());

        if (eq != null) {

            falha.setStatus("ABERTA");

            if(falha.getCriticidade().equals("CRITICA")){

                repoEq.atualizarStatusEquipamento("EM_MANUTENCAO", eq.getId());

            }
            repository.registrarNovaFalha(falha);
        } else {
            throw new RuntimeException();
        }
        return falha;
    }
    List<Falha> buscarFalhasCriticasAbertas() throws SQLException {
        var repository = new FalhaRepository();

        List<Falha> falhas = repository.buscarFalhasCriticasAbertas();
        falhas.forEach(falha -> {
            System.out.println("Falha ID: " + falha.getId());
            System.out.println("Equipamento ID: " + falha.getEquipamentoId());
            System.out.println("Criticidade: " + falha.getCriticidade());
            System.out.println("Status: " + falha.getStatus());
            System.out.println("Data/Hora: " + falha.getDataHoraOcorrencia());
            System.out.println("Descrição: " + falha.getDescricao());
            System.out.println("-----------------------");
        });

        return falhas;
    }

}
