package org.example.service;

import org.example.model.Equipamento;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

public class RelatorioService {

    public static List<RelatorioParadaDTO> gerarRelatorioTempoParada() throws SQLException{

    }
    public static List<Equipamento> buscarEquipamentosSemFalhasPorPeriodo(LocalDate dataInicio, LocalDate datafim) throws SQLException {

    }
    public static Optional<FalhaDetalhadaDTO> buscarDetalhesCompletosFalha(long falhaId) throws SQLException{

    }
    public static List<EquipamentoContagemFalhasDTO> gerarRelatorioManutencaoPreventiva(int contagemMinimaFalhas) throws SQLException{

    }
}
