package com.Acoes.Pelo.Futuro.DTO;

import com.Acoes.Pelo.Futuro.Model.enums.CategoriaAcao;

import java.time.LocalDate;

public class AcaoSustentavelRequestDTO {

    private String titulo;
    private String descriacao;
    private CategoriaAcao categoria;
    private LocalDate dataRealizacao;
    private String responsavel;


    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescriacao() {
        return descriacao;
    }

    public void setDescriacao(String descriacao) {
        this.descriacao = descriacao;
    }

    public CategoriaAcao getCategoria() {
        return categoria;
    }

    public void setCategoria(CategoriaAcao categoria) {
        this.categoria = categoria;
    }

    public LocalDate getDataRealizacao() {
        return dataRealizacao;
    }

    public void setDataRealizacao(LocalDate dataRealizacao) {
        this.dataRealizacao = dataRealizacao;
    }

    public String getResponsavel() {
        return responsavel;
    }

    public void setResponsavel(String responsavel) {
        this.responsavel = responsavel;
    }
}
