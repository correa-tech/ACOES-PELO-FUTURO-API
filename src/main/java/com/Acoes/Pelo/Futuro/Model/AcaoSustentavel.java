package com.Acoes.Pelo.Futuro.Model;

import com.Acoes.Pelo.Futuro.Model.enums.CategoriaAcao;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class AcaoSustentavel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private String descriacao;

    @Enumerated(EnumType.STRING)
    private CategoriaAcao categoria;
    private LocalDate dataRealizacao;
    private String resonsavel;

    public AcaoSustentavel() {
    }

    public AcaoSustentavel(String titulo, String descriacao, CategoriaAcao categoria, LocalDate dataRealizacao, String resonsavel) {
        this.titulo = titulo;
        this.descriacao = descriacao;
        this.categoria = categoria;
        this.dataRealizacao = dataRealizacao;
        this.resonsavel = resonsavel;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public String getResonsavel() {
        return resonsavel;
    }

    public void setResonsavel(String resonsavel) {
        this.resonsavel = resonsavel;
    }
}
