package org.example.service;

import org.example.DTO.EquipamentoContagemFalhasDTO;
import org.example.DTO.FalhaDetalhadaDTO;
import org.example.DTO.RelatorioParadaDTO;
import org.example.model.Equipamento;
import org.example.repository.EquipamentoRepositoryImpl;
import org.example.repository.RelatorioRepository;
import org.example.repository.RelatorioRepositoryImpl;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public interface RelatorioService {

    List<RelatorioParadaDTO> gerarRelatorioTempoParada() throws SQLException;

    List<Equipamento> buscarEquipamentosSemFalhasPorPeriodo(LocalDate dataInicio, LocalDate datafim) throws SQLException;

    Optional<FalhaDetalhadaDTO> buscarDetalhesCompletosFalha(long falhaId) throws SQLException;

    List<EquipamentoContagemFalhasDTO> gerarRelatorioManutencaoPrevelntiva(int contagemMinimaFalhas) throws SQLException;

}
