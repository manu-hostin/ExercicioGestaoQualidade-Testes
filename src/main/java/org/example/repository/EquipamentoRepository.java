package org.example.repository;

import org.example.model.Equipamento;
import org.example.util.ConexaoBanco;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EquipamentoRepository {

    public static Equipamento criarEquipamento (Equipamento equipamento) throws SQLException {
        String query = "INSERT INTO Equipamento (nome, numeroDeSerie, areaSetor, statusOperacional) VALUES (?, ?, ?, ?)";

        try(Connection conn = ConexaoBanco.conectar();
            PreparedStatement stmt = conn.prepareStatement(query)){

            stmt.setString(1, equipamento.getNome());
            stmt.setString(2, equipamento.getNumeroDeSerie());
            stmt.setString(3, equipamento.getAreaSetor());
            stmt.setString(4, equipamento.getStatusOperacional());
            stmt.executeUpdate();

        }
        return equipamento;
    }
    public static Equipamento buscarEquipamentoPorId (long id) throws SQLException {
        String query = "SELECT id, nome, numeroDeSerie, areaSetor, statusOperacional FROM Equipamento WHERE id = ?";

        try (Connection conn = ConexaoBanco.conectar();
        PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setLong(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                String nome = rs.getString("nome");
                String numero = rs.getString("numeroDeSerie");
                String area = rs.getString("areaSetor");
                String status = rs.getString("statusOperacional");

                return new Equipamento(id, nome, numero, area, status);
            }
        }
        return null;
    }
    public static void atualizarStatusEquipamento (String status, Long id) throws SQLException{
        String query = "UPDATE Equipamento SET statusOperacional = ? WHERE id = ?";

        try (Connection conn = ConexaoBanco.conectar();
        PreparedStatement stmt = conn.prepareStatement(query)){

            stmt.setString(1, status);
            stmt.setLong(2, id);
            stmt.executeUpdate();
        }
    }
    public static List<Equipamento> buscarEquipamentos () throws SQLException {
        String query = "SELECT id, nome, numeroDeSerie, areaSetor, statusOperacional FROM Equipamento";

        List<Equipamento> lista = new ArrayList<>();
        try (Connection conn = ConexaoBanco.conectar();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Long id = rs.getLong("id");
                String nome = rs.getString("nome");
                String numero = rs.getString("numeroDeSerie");
                String area = rs.getString("areaSetor");
                String status = rs.getString("statusOperacional");

                var eq = new Equipamento(id, nome, numero, area, status);
                lista.add(eq);
            }
        }
        return lista;
    }

}
