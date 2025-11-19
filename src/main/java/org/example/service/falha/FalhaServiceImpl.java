package org.example.service.falha;

import org.example.model.Falha;
import org.example.repository.EquipamentoRepositoryImpl;
import org.example.repository.FalhaRepositoryImpl;

import java.sql.SQLException;
import java.util.List;

public class FalhaServiceImpl implements FalhaService {

    @Override
    public Falha registrarNovaFalha(Falha falha) throws SQLException {
        var repository = new FalhaRepositoryImpl();
        var repoEq = new EquipamentoRepositoryImpl();
//        var eq = repoEq.buscarEquipamentoPorId(falha.getEquipamentoId());
//
//        if (eq != null) {
//
//            falha.setStatus("ABERTA");
//
//            if(falha.getCriticidade().equals("CRITICA")){
//
//                repoEq.atualizarStatusEquipamento("EM_MANUTENCAO", eq.getId());
//
//            }
//            repository.registrarNovaFalha(falha);
//        } else {
//            throw new IllegalArgumentException("Equipamento não encontrado!");
//        }
//        return falha;

//        OU
        if (repoEq.equipamentoExiste(falha.getEquipamentoId())){
           throw new IllegalArgumentException();
        }
        falha.setStatus("ABERTA");
        falha = repository.registrarNovaFalha(falha);

        if(falha.getCriticidade().equals("CRITICA")){
            repoEq.atualizarStatusEquipamento("EM_MANUTENCAO", falha.getEquipamentoId());
        }
        if (falha.getId() == null) {
            throw new RuntimeException("Erro ao salvar falha!");
        }
        return falha;
    }
    @Override
    public List<Falha> buscarFalhasCriticasAbertas() throws SQLException {
        var repository = new FalhaRepositoryImpl();

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
        // ou return repository.buscarFalhasCriticasAbertas();
    }

}
