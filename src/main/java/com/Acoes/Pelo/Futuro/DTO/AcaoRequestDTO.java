package com.Acoes.Pelo.Futuro.DTO;

import com.Acoes.Pelo.Futuro.Model.enums.CategoriaAcao;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@Data
@AllArgsConstructor
public class AcaoRequestDTO {

    @NotBlank(message = "O TÍTULO É OBRIGATÓRIO")
    private String titulo;

    @NotBlank(message = "A DESCRIÇÃO É OBRIGATÓRIA")
    private String descriacao;

    @Enumerated(EnumType.STRING)
    @NotNull(message = "A CATEGORIA DEVE SER OBRIGATÓRIA")
    private CategoriaAcao categoria;

    @NotNull(message = "DEFINA A DATA DA REALIZAÇÃO")
    private LocalDate dataRealizacao;

    @NotBlank(message = "O RESPONSÁVEL DEVE SER OBRIGATÓRIO")
    private String responsavel;


}
