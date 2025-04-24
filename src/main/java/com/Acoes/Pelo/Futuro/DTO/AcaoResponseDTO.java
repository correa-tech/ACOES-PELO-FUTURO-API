package com.Acoes.Pelo.Futuro.DTO;

import com.Acoes.Pelo.Futuro.Model.enums.CategoriaAcao;
import lombok.Data;

import java.time.LocalDate;

@Data
public class AcaoResponseDTO {

    private Long id;
    private String titulo;
    private String descriacao;
    private CategoriaAcao categoria;
    private LocalDate dataRealizacao;
    private String responsavel;


}
