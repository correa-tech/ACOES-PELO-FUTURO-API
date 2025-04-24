package com.Acoes.Pelo.Futuro.repository;

import com.Acoes.Pelo.Futuro.Model.AcaoSustentavel;
import com.Acoes.Pelo.Futuro.Model.enums.CategoriaAcao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AcaoSustentavelRepository extends JpaRepository<AcaoSustentavel, Long> {

    List<AcaoSustentavel> findByCategoria(CategoriaAcao categoria);

}
