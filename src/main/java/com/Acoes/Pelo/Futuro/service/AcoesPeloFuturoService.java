package com.Acoes.Pelo.Futuro.service;

import com.Acoes.Pelo.Futuro.DTO.AcaoRequestDTO;
import com.Acoes.Pelo.Futuro.Model.AcaoSustentavel;
import com.Acoes.Pelo.Futuro.DTO.AcaoResponseDTO;
import com.Acoes.Pelo.Futuro.Model.enums.CategoriaAcao;
import com.Acoes.Pelo.Futuro.repository.AcaoSustentavelRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AcoesPeloFuturoService {

    @Autowired
    private final AcaoSustentavelRepository acaoSustentavelRepository;

    @Autowired
    private ModelMapper modelMapper;

    public AcoesPeloFuturoService (AcaoSustentavelRepository acaoSustentavelRepository){
        this.acaoSustentavelRepository = acaoSustentavelRepository;
    }


    public AcaoResponseDTO cadastrarAcao (AcaoRequestDTO acaoRequestDTO){
       AcaoSustentavel acaoSustentavel = modelMapper.map(acaoRequestDTO, AcaoSustentavel.class);

       acaoSustentavel = acaoSustentavelRepository.save(acaoSustentavel);

       return modelMapper.map(acaoSustentavel, AcaoResponseDTO.class);

    }

    public List<AcaoResponseDTO> mostrarTodasAcoes (){
        List<AcaoSustentavel> acaoSustentavels = acaoSustentavelRepository.findAll();
        return acaoSustentavels.stream().map(acaoSustentavel -> modelMapper.map(acaoSustentavel, AcaoResponseDTO.class))
                .collect(Collectors.toList());
    }

    public Optional<AcaoResponseDTO> MostrarPorID (Long id){
        Optional<AcaoSustentavel> acaoSustentavel = acaoSustentavelRepository.findById(id);
        return acaoSustentavel.map(acao -> modelMapper.map(acao, AcaoResponseDTO.class));
    }


    public AcaoResponseDTO atualizar (Long id, AcaoRequestDTO DTO){
        AcaoSustentavel acaoSustentavel = acaoSustentavelRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Ação não encontrada"));

       modelMapper.map(DTO, acaoSustentavel);

       AcaoSustentavel acaoSustentavelUpdate = acaoSustentavelRepository.save(acaoSustentavel);

       return modelMapper.map(acaoSustentavelUpdate, AcaoResponseDTO.class);
    }

    public void deletar (Long id){
        AcaoSustentavel acaoSustentavel = acaoSustentavelRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "ID não encontrado"));

        acaoSustentavelRepository.delete(acaoSustentavel);
    }

    public List<AcaoResponseDTO> buscarPorCategoria(CategoriaAcao categoria) {
        List<AcaoSustentavel> acoes = acaoSustentavelRepository.findByCategoria(categoria);
        return acoes.stream()
                .map(acao -> modelMapper.map(acao, AcaoResponseDTO.class))
                .toList();
    }




}
