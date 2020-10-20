package com.example.demo.converter;

import com.example.demo.common.AbstractConverter;
import com.example.demo.model.dto.ProvinciaDto;
import com.example.demo.model.entity.ProvinciaEntity;
import com.example.demo.service.ProvinciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProvinciaConverter extends AbstractConverter<ProvinciaEntity, ProvinciaDto> {

    @Autowired
    private ProvinciaService provinciaService;

    @Autowired
    private DepartamentoConverter departamentoConverter;

    @Override
    protected ProvinciaDto entityToDto(ProvinciaEntity entity) throws Exception {
        return ProvinciaDto.builder()
                .id(entity.getId())
                .nombre(entity.getNombre())
                .departamento(departamentoConverter.toDto(entity.getDepartamento()))
                .codigo(entity.getCodigo())
                .build();
    }

    @Override
    protected ProvinciaEntity dtoToEntity(ProvinciaDto dto) throws Exception {

        ProvinciaEntity entity;

        if (dto.getId() == null) {
            entity = new ProvinciaEntity();
        } else {
            entity = provinciaService.getById(dto.getId());
        }

        return entity;
    }

}
