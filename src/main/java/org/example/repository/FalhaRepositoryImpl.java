package org.example.repository;

import org.example.model.Falha;
import org.example.database.Conexao;

import java.math.BigDecimal;
import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class FalhaRepositoryImpl {

    public Falha registrarNovaFalha (Falha falha) throws SQLException {
        String query = "INSERT INTO Falha (equipamentoId, dataHoraOcorrencia, descricao, criticidade, status, tempoParadaHoras) VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {

            stmt.setLong(1, falha.getEquipamentoId());
            stmt.setTimestamp(2, Timestamp.valueOf(falha.getDataHoraOcorrencia()));
            stmt.setString(3, falha.getDescricao());
            stmt.setString(4, falha.getCriticidade());
            stmt.setString(5, falha.getStatus());
            stmt.setBigDecimal(6, falha.getTempoParadaHoras());
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                falha.setId(rs.getLong(1));
                return falha;
            }
        }
        return falha;
    }
    public List<Falha> buscarFalhasCriticasAbertas () throws SQLException {
        String query = "SELECT id, equipamentoId, dataHoraOcorrencia, descricao, criticidade, status, tempoParadaHoras FROM Falha WHERE status = 'ABERTA' AND criticidade = 'CRITICA'";

        List<Falha> falhas = new ArrayList<>();
        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {

                Long ID = rs.getLong("id");
                Long eqID = rs.getLong("equipamentoId");
                LocalDateTime dataOcorrencia = rs.getTimestamp("dataHoraOcorrencia").toLocalDateTime();
                String descricao = rs.getString("descricao");
                String criticidade = rs.getString("criticidade");
                String status = rs.getString("status");
                BigDecimal tempo = rs.getBigDecimal("tempoParadaHoras");

                var falha = new Falha(ID, eqID, dataOcorrencia, descricao, criticidade, status, tempo);
                falhas.add(falha);
            }
        }
        return falhas;
    }
    public Falha buscarIDExistente (Long id) throws SQLException {
        String query = "SELECT id, criticidade, equipamentoId, tempoParadaHoras, descricao, status, dataHoraOcorrencia FROM Falha WHERE id = ?";

        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setLong(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                Long idCerto = rs.getLong("id");
                String criticidade = rs.getString("criticidade");
                Long equip = rs.getLong("equipamentoId");
                BigDecimal parada = rs.getBigDecimal("tempoParadaHoras");
                String desc = rs.getString("descricao");
                String status = rs.getString("status");
                LocalDateTime data = rs.getTimestamp("dataHoraOcorrencia").toLocalDateTime();

                return new Falha(idCerto, equip, data, desc, criticidade, status, parada);
            }
        }
        return null;
    }

    public void atualizarStatusFalha (String status, Long id) throws SQLException {
        String query = "UPDATE Falha SET status = ? WHERE id = ?";

        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, status);
            stmt.setLong(2, id);
            stmt.executeUpdate();

        }
    }
}
