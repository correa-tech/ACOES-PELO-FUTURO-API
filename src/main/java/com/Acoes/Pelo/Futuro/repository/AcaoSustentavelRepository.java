package com.Acoes.Pelo.Futuro.repository;

import com.Acoes.Pelo.Futuro.Model.AcaoSustentavel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AcaoSustentavelRepository extends JpaRepository<AcaoSustentavel, Long> {
}
