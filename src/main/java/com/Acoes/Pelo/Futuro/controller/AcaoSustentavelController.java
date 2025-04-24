package com.Acoes.Pelo.Futuro.controller;

import com.Acoes.Pelo.Futuro.DTO.AcaoRequestDTO;
import com.Acoes.Pelo.Futuro.DTO.AcaoResponseDTO;
import com.Acoes.Pelo.Futuro.Model.enums.CategoriaAcao;
import com.Acoes.Pelo.Futuro.exception.RecursoNaoEncontradoException;
import com.Acoes.Pelo.Futuro.service.AcoesPeloFuturoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/")
public class AcaoSustentavelController {

    @Autowired
    AcoesPeloFuturoService service;


    @PostMapping("/acoes")
    public ResponseEntity<AcaoResponseDTO> cadastrarAcao(@RequestBody @Valid AcaoRequestDTO acaoRequestDTO){
        AcaoResponseDTO dto = service.cadastrarAcao(acaoRequestDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(dto);
    }

    @GetMapping ("/acoes")
    public ResponseEntity<List<AcaoResponseDTO>> mostrarAcoes(){
        List<AcaoResponseDTO> responseDTOS = service.mostrarTodasAcoes();
        return ResponseEntity.ok(responseDTOS);
    }
    
    @GetMapping("/acoes/{id}")
    public ResponseEntity<AcaoResponseDTO> mostrarAcaoPeloID (@PathVariable Long id){
        Optional<AcaoResponseDTO> responseDTOS = service.MostrarPorID(id);

        return responseDTOS.map(ResponseEntity::ok).
                orElseThrow(() -> new RecursoNaoEncontradoException("Cliente com o id: " + id + " Não encontrado"));
    }

    @PutMapping("/acoes/{id}")
    public ResponseEntity<AcaoResponseDTO> atualizar (@PathVariable Long id, @RequestBody AcaoRequestDTO acaoSustentavelDTO){
        AcaoResponseDTO dto = service.atualizar(id, acaoSustentavelDTO);
        return ResponseEntity.ok(dto);
    }

    @DeleteMapping("/acoes/{id}")
    public ResponseEntity<Void> deletar (@PathVariable Long id){
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/categoria")
    public ResponseEntity<List<AcaoResponseDTO>> buscarPorCategoria(@RequestParam CategoriaAcao categoria) {
        List<AcaoResponseDTO> acoes = service.buscarPorCategoria(categoria);
        return ResponseEntity.ok(acoes);
    }

}
