package com.example.demo.converter;

import com.example.demo.common.AbstractConverter;
import com.example.demo.model.dto.DistritoDto;
import com.example.demo.model.entity.DistritoEntity;
import com.example.demo.service.DistritoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DistritoConverter extends AbstractConverter<DistritoEntity, DistritoDto> {

    @Autowired
    private DistritoService distritoService;

    @Autowired
    private ProvinciaConverter provinciaConverter;

    @Override
    protected DistritoDto entityToDto(DistritoEntity entity) throws Exception {
        return DistritoDto.builder()
                .id(entity.getId())
                .nombre(entity.getNombre())
                .provincia(provinciaConverter.toDto(entity.getProvincia()))
                .codigo(entity.getCodigo())
                .build();
    }

    @Override
    protected DistritoEntity dtoToEntity(DistritoDto dto) throws Exception {

        DistritoEntity entity;

        if (dto.getId() == null) {
            entity = new DistritoEntity();
        } else {
            entity = distritoService.getById(dto.getId());
        }

        return entity;
    }

}
