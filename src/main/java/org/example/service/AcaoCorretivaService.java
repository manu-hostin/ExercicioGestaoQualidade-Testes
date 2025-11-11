package org.example.service;

import org.example.model.AcaoCorretiva;
import org.example.repository.AcaoCorretivaRepository;
import org.example.repository.EquipamentoRepository;
import org.example.repository.FalhaRepository;

import java.sql.SQLException;

public class AcaoCorretivaService {

    AcaoCorretiva registrarConclusaoDeAcao(AcaoCorretiva acao) throws SQLException{
        var repository = new AcaoCorretivaRepository();
        var falhaRepo = new FalhaRepository();
        var eqRepo = new EquipamentoRepository();

        var falha = falhaRepo.buscarIDExistente(acao.getFalhaId());
        if(falha == null){
            throw new RuntimeException("ID da Falha não existe.");
        } else {
            repository.registrarConclusaoDeAcao(acao);
        }

        if (falha.getCriticidade().equals("CRITICA")) {
            eqRepo.atualizarStatusEquipamento("OPERACIONAL", falha.getEquipamentoId());
            falhaRepo.atualizarStatusFalha("RESOLVIDA", falha.getId());
        } else {
            falhaRepo.atualizarStatusFalha("RESOLVIDA", falha.getId());
        }

        return acao;
    }
}
