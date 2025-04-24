package com.Acoes.Pelo.Futuro.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AcaoSustentavelMapper {

    @Bean
    public ModelMapper modelMap(){
        return new ModelMapper();
    }

}
