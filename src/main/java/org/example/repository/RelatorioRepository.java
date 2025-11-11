package org.example.repository;

import org.example.model.Equipamento;
import org.example.util.ConexaoBanco;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class RelatorioRepository {

    public static List<RelatorioParadaDTO> gerarRelatorioTempoParada() throws SQLException {

    }
    public static List<Equipamento> buscarEquipamentosSemFalhasPorPeriodo(LocalDate dataInicio, LocalDate datafim) throws SQLException {
        String query = """
                SELECT e.id, 
                       e.nome, 
                       e.numeroDeSerie, 
                       e.areaSetor, 
                       e.statusOperacional
                FROM Equipamento e
                JOIN Falha f ON f.equipamentoId = e.id
                JOIN AcaoCorretiva a ON a.falhaId = f.id
                WHERE a.dataHoraInicio = ?
                AND a.dataHoraFim = ?
                """;

        List<Equipamento> lista = new ArrayList<>();
        try(Connection conn = ConexaoBanco.conectar();
            PreparedStatement stmt = conn.prepareStatement(query)){

            stmt.setDate(1, Date.valueOf(dataInicio));
            stmt.setDate(2, Date.valueOf(datafim));
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Long id = rs.getLong("id");
                String nome = rs.getString("nome");
                String nSerie = rs.getString("numeroDeSerie");
                String area = rs.getString("areaSetor");
                String status = rs.getString("statusOperacional");

                var eq = new Equipamento(id, nome, nSerie, area, status);
                lista.add(eq);
            }
        }
        return lista;
    }
    public static Optional<FalhaDetalhadaDTO> buscarDetalhesCompletosFalha(long falhaId) throws SQLException{

    }
    public static List<EquipamentoContagemFalhasDTO> gerarRelatorioManutencaoPrevelntiva(int contagemMinimaFalhas) throws SQLException{

    }

}
