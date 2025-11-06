package org.example.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class AcaoCorretiva {

    private Long id;

    private Long falhaId;

    private LocalDateTime dataHoraInicio;

    private LocalDateTime ndataHoraFim;

    private String responsavel;

    private String descricaoAcao;

    public AcaoCorretiva(Long id, Long falhaId, LocalDateTime dataHoraInicio, LocalDateTime ndataHoraFim, String responsavel, String descricaoAcao) {
        this.id = id;
        this.falhaId = falhaId;
        this.dataHoraInicio = dataHoraInicio;
        this.ndataHoraFim = ndataHoraFim;
        this.responsavel = responsavel;
        this.descricaoAcao = descricaoAcao;
    }

    public AcaoCorretiva(Long falhaId, LocalDateTime dataHoraInicio, LocalDateTime ndataHoraFim, String responsavel, String descricaoAcao) {
        this.id = id;
        this.falhaId = falhaId;
        this.dataHoraInicio = dataHoraInicio;
        this.ndataHoraFim = ndataHoraFim;
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

    public LocalDateTime getNdataHoraFim() {
        return ndataHoraFim;
    }

    public void setNdataHoraFim(LocalDateTime ndataHoraFim) {
        this.ndataHoraFim = ndataHoraFim;
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
