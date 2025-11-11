package org.example.service;

import org.example.model.Equipamento;
import org.example.repository.EquipamentoRepository;
import org.example.repository.RelatorioRepository;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class RelatorioService {

    //public static List<RelatorioParadaDTO> gerarRelatorioTempoParada() throws SQLException{
    //
    // }

    public static List<Equipamento> buscarEquipamentosSemFalhasPorPeriodo(LocalDate dataInicio, LocalDate datafim) throws SQLException {
        var eqpRepo = new EquipamentoRepository();
        var relatorioRepo = new RelatorioRepository();

        List<Equipamento> listaTodosEq = eqpRepo.buscarEquipamentos();
        List<Equipamento> listaEqFalha = relatorioRepo.buscarEquipamentosSemFalhasPorPeriodo(dataInicio, datafim);

        List<Equipamento> listaSemFalha = new ArrayList<>();
        for (Equipamento item : listaTodosEq){
            if(!listaEqFalha.contains(item)){
                listaSemFalha.add(item);
            }
        }

        return listaSemFalha;
    }

//    public static Optional<FalhaDetalhadaDTO> buscarDetalhesCompletosFalha(long falhaId) throws SQLException{
//
//    }
//    public static List<EquipamentoContagemFalhasDTO> gerarRelatorioManutencaoPrevelntiva(int contagemMinimaFalhas) throws SQLException{
//
//    }
}
