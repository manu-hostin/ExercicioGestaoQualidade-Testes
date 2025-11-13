package org.example.repository;

import org.example.DTO.EquipamentoContagemFalhasDTO;
import org.example.DTO.FalhaDetalhadaDTO;
import org.example.DTO.RelatorioParadaDTO;
import org.example.model.Equipamento;

import java.sql.*;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface RelatorioRepository {

    List<RelatorioParadaDTO> gerarRelatorioTempoParada() throws SQLException;

    List<Equipamento> buscarEquipamentosSemFalhasPorPeriodo(LocalDate dataInicio, LocalDate datafim);

    Optional<FalhaDetalhadaDTO> buscarDetalhesCompletosFalha(long falhaId) throws SQLException;

    List<EquipamentoContagemFalhasDTO> gerarRelatorioManutencaoPrevelntiva(int contagemMinimaFalhas) throws SQLException;

}
