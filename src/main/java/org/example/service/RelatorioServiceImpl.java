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

public class RelatorioServiceImpl implements RelatorioService {

    @Override
    public List<RelatorioParadaDTO> gerarRelatorioTempoParada() throws SQLException {
        var repo = new RelatorioRepositoryImpl();

        List<RelatorioParadaDTO> lista = new ArrayList<>();
        lista = repo.gerarRelatorioTempoParada();

        lista.forEach(relatorioParadaDTO -> {
            System.out.println("ID equipamento: " + relatorioParadaDTO.getIdEq());
            System.out.println("Nome: "+relatorioParadaDTO.getNomeEq());
            System.out.println("Tempo: "+relatorioParadaDTO.getTempoParada());
        });
        return lista;
    }
    @Override
    public List<Equipamento> buscarEquipamentosSemFalhasPorPeriodo(LocalDate dataInicio, LocalDate datafim) throws SQLException {
        var eqpRepo = new EquipamentoRepositoryImpl();
        RelatorioRepository relatorioRepo = new RelatorioRepositoryImpl();

        List<Equipamento> listaTodosEq = eqpRepo.buscarEquipamentos();
        List<Equipamento> listaEqFalha = relatorioRepo.buscarEquipamentosSemFalhasPorPeriodo(dataInicio, datafim);

        List<Equipamento> listaSemFalha = new ArrayList<>();
        for (Equipamento item : listaTodosEq) {
            if (!listaEqFalha.contains(item)) {
                listaSemFalha.add(item);
            }
        }

        return listaSemFalha;
    }
    @Override
    public Optional<FalhaDetalhadaDTO> buscarDetalhesCompletosFalha(long falhaId) throws SQLException{

         return null;
    }
    @Override
    public List<EquipamentoContagemFalhasDTO> gerarRelatorioManutencaoPrevelntiva(int contagemMinimaFalhas) throws SQLException{

        return null;
    }
}
