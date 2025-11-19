package org.example.service.acaocorretiva;

import org.example.model.AcaoCorretiva;
import org.example.repository.AcaoCorretivaRepositoryImpl;
import org.example.repository.EquipamentoRepositoryImpl;
import org.example.repository.FalhaRepositoryImpl;

import java.sql.SQLException;

public class AcaoCorretivaServiceImpl implements AcaoCorretivaService {

    @Override
    public AcaoCorretiva registrarConclusaoDeAcao (AcaoCorretiva acao) throws SQLException {
        var repository = new AcaoCorretivaRepositoryImpl();
        var falhaRepo = new FalhaRepositoryImpl();
        var eqRepo = new EquipamentoRepositoryImpl();

        var falha = falhaRepo.buscarIDExistente(acao.getFalhaId());
        if (falha == null) {
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
