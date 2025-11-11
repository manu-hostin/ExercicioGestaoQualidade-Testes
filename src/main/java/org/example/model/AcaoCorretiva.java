package org.example.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class AcaoCorretiva {

    private Long id;

    private Long falhaId;

    private LocalDateTime dataHoraInicio;

    private LocalDateTime dataHoraFim;

    private String responsavel;

    private String descricaoAcao;

    public AcaoCorretiva(Long id, Long falhaId, LocalDateTime dataHoraInicio, LocalDateTime dataHoraFim, String responsavel, String descricaoAcao) {
        this.id = id;
        this.falhaId = falhaId;
        this.dataHoraInicio = dataHoraInicio;
        this.dataHoraFim = dataHoraFim;
        this.responsavel = responsavel;
        this.descricaoAcao = descricaoAcao;
    }

    public AcaoCorretiva(Long falhaId, LocalDateTime dataHoraInicio, LocalDateTime dataHoraFim, String responsavel, String descricaoAcao) {
        this.falhaId = falhaId;
        this.dataHoraInicio = dataHoraInicio;
        this.dataHoraFim = dataHoraFim;
        this.responsavel = responsavel;
        this.descricaoAcao = descricaoAcao;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getFalhaId() {
        return falhaId;
    }

    public void setFalhaId(Long falhaId) {
        this.falhaId = falhaId;
    }

    public LocalDateTime getdataHoraFim() {
        return dataHoraFim;
    }

    public void setdataHoraFim(LocalDateTime dataHoraFim) {
        this.dataHoraFim = dataHoraFim;
    }

    public String getResponsavel() {
        return responsavel;
    }

    public void setResponsavel(String responsavel) {
        this.responsavel = responsavel;
    }

    public String getDescricaoAcao() {
        return descricaoAcao;
    }

    public void setDescricaoAcao(String descricaoAcao) {
        this.descricaoAcao = descricaoAcao;
    }

    public LocalDateTime getDataHoraInicio() {
        return dataHoraInicio;
    }

    public void setDataHoraInicio(LocalDateTime dataHoraInicio) {
        this.dataHoraInicio = dataHoraInicio;
    }
}
