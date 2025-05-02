package com.Acoes.Pelo.Futuro.Model.acao;

import com.Acoes.Pelo.Futuro.Model.enums.CategoriaAcao;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@NoArgsConstructor
@RequiredArgsConstructor
@Data
public class AcaoSustentavel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NonNull
    private String titulo;

    @NonNull
    private String descricao;

    @Enumerated(EnumType.STRING)
    @NonNull
    private CategoriaAcao categoria;


    @NonNull
    private LocalDate dataRealizacao;


    @NonNull
    private String responsavel;


}
