package org.example.DTO;

import java.math.BigDecimal;

public class RelatorioParadaDTO {

    private Long idEq;

    private String nomeEq;

    private BigDecimal tempoParada;

    public RelatorioParadaDTO(Long idEq, String nomeEq, BigDecimal tempoParada) {
        this.idEq = idEq;
        this.nomeEq = nomeEq;
        this.tempoParada = tempoParada;
    }

    public Long getIdEq() {
        return idEq;
    }

    public void setIdEq(Long idEq) {
        this.idEq = idEq;
    }

    public String getNomeEq() {
        return nomeEq;
    }

    public void setNomeEq(String nomeEq) {
        this.nomeEq = nomeEq;
    }

    public BigDecimal getTempoParada() {
        return tempoParada;
    }

    public void setTempoParada(BigDecimal tempoParada) {
        this.tempoParada = tempoParada;
    }

}
