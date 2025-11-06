package org.example.repository;

import org.example.model.Falha;
import org.example.util.ConexaoBanco;

import java.math.BigDecimal;
import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class FalhaRepository {

    public static Falha registrarNovaFalha(Falha falha) throws SQLException {
        String query = "INSERT INTO Falha (equipamentoId, dataHoraOcorrencia, descricao, criticidade, status, tempoParadaHoras) VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection conn = ConexaoBanco.conectar();
             PreparedStatement stmt = conn.prepareStatement(query)){

            stmt.setLong(1, falha.getEquipamentoId());
            stmt.setTimestamp(2, Timestamp.valueOf(falha.getDataHoraOcorrencia()));
            stmt.setString(3, falha.getDescricao());
            stmt.setString(4, falha.getCriticidade());
            stmt.setString(5, falha.getStatus());
            stmt.setBigDecimal(6, falha.getTempoParadaHoras());
            stmt.executeUpdate();

        }
        return falha;
    }
    public static List<Falha> buscarFalhasCriticasAbertas () throws SQLException {
        String query = "SELECT id, equipamentoId, dataHoraOcorrencia, descricao, criticidade, status, tempoParadaHoras FROM Falha WHERE status = 'ABERTA' AND criticidade = 'CRITICA'";

        List<Falha> falhas = new ArrayList<>();
        try (Connection conn = ConexaoBanco.conectar();
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

                var falha = new Falha (ID, eqID, dataOcorrencia, descricao, criticidade, status, tempo);
                falhas.add(falha);
            }
        }
        return falhas;
    }
}
