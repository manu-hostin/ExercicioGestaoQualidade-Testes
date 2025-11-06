package org.example.service;

import org.example.model.Equipamento;
import org.example.repository.EquipamentoRepository;

import java.sql.SQLException;

public class EquipamentoService {


    public static Equipamento criarEquipamento (Equipamento equipamento) throws SQLException {
        var repo = new EquipamentoRepository();

        return repo.criarEquipamento(equipamento);
    }
    public static Equipamento buscarEquipamentoPorID (Long id) throws SQLException{
        var repo = new EquipamentoRepository();

        return repo.buscarEquipamentoPorId(id);
    }

}


//-- Armazena os ativos físicos da planta.
//CREATE TABLE IF NOT EXISTS Equipamento (
//        id BIGINT AUTO_INCREMENT PRIMARY KEY,
//        nome VARCHAR(255) NOT NULL,
//numeroDeSerie VARCHAR(100) NOT NULL UNIQUE,
//areaSetor VARCHAR(100) NOT NULL,
//statusOperacional VARCHAR(50) NOT NULL,
//
//    -- Garante que o status só possa ter valores pré-definidos
//CONSTRAINT chk_status_equipamento CHECK (statusOperacional IN ('OPERACIONAL', 'EM_MANUTENCAO', 'INATIVO'))
//        );

//        -- 2. Tabela Falha
//-- Registra cada ocorrência de falha, ligada a um equipamento.
//CREATE TABLE IF NOT EXISTS Falha (
//        id BIGINT AUTO_INCREMENT PRIMARY KEY,
//        equipamentoId BIGINT NOT NULL,
//        dataHoraOcorrencia DATETIME NOT NULL,
//        descricao TEXT NOT NULL,
//        criticidade VARCHAR(50) NOT NULL,
//status VARCHAR(50) NOT NULL,
//tempoParadaHoras DECIMAL(10, 2) DEFAULT 0.00,
//
//        -- Garante que criticidade e status tenham valores pré-definidos
//CONSTRAINT chk_criticidade_falha CHECK (criticidade IN ('BAIXA', 'MEDIA', 'ALTA', 'CRITICA')),
//CONSTRAINT chk_status_falha CHECK (status IN ('ABERTA', 'EM_ANDAMENTO', 'RESOLVIDA')),
//
//        -- Chave estrangeira ligando a Falha ao Equipamento
//CONSTRAINT fk_falha_equipamento
//FOREIGN KEY (equipamentoId)
//REFERENCES Equipamento(id)
//ON DELETE RESTRICT -- Impede excluir um equipamento se ele tiver falhas registradas
//);

//        -- 3. Tabela AcaoCorretiva
//-- Detalha as ações tomadas para resolver uma falha específica.
//CREATE TABLE IF NOT EXISTS AcaoCorretiva (
//        id BIGINT AUTO_INCREMENT PRIMARY KEY,
//        falhaId BIGINT NOT NULL,
//        dataHoraInicio DATETIME NOT NULL,
//        dataHoraFim DATETIME NOT NULL,
//        responsavel VARCHAR(255) NOT NULL,
//descricaoAcao TEXT NOT NULL,
//
//    -- Chave estrangeira ligando a Ação à Falha
//CONSTRAINT fk_acao_falha
//FOREIGN KEY (falhaId)
//REFERENCES Falha(id)
//ON DELETE RESTRICT -- Impede excluir uma falha se ela tiver ações corretivas
//);

