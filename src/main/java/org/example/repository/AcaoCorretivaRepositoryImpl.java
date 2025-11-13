package org.example.repository;

import org.example.model.AcaoCorretiva;
import org.example.database.Conexao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;

public class AcaoCorretivaRepositoryImpl implements AcaoCorretivaRepository {

    @Override
    public AcaoCorretiva registrarConclusaoDeAcao(AcaoCorretiva acao) throws SQLException {
        String query = "INSERT INTO AcaoCorretiva (falhaId, dataHoraInicio, dataHoraFim, responsavel, descricaoAcao) VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setLong(1, acao.getFalhaId());
            stmt.setTimestamp(2, Timestamp.valueOf(acao.getDataHoraInicio()));
            stmt.setTimestamp(3, Timestamp.valueOf(acao.getdataHoraFim()));
            stmt.setString(4, acao.getResponsavel());
            stmt.setString(5, acao.getDescricaoAcao());
            stmt.executeUpdate();
        }
        return acao;
    }
}
