package com.example.demo.converter;

import com.example.demo.common.AbstractConverter;
import com.example.demo.model.dto.DepartamentoDto;
import com.example.demo.model.entity.DepartamentoEntity;
import com.example.demo.service.DepartamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class DepartamentoConverter extends AbstractConverter<DepartamentoEntity, DepartamentoDto> {

    @Autowired
    private DepartamentoService departamentoService;

    @Override
    protected DepartamentoDto entityToDto(DepartamentoEntity entity) throws Exception {
        return DepartamentoDto.builder()
                .id(entity.getId())
                .nombre(entity.getNombre())
                .codigo(entity.getCodigo())
                .build();
    }

    @Override
    protected DepartamentoEntity dtoToEntity(DepartamentoDto dto) throws Exception {

        DepartamentoEntity entity;

        if (dto.getId() == null) {
            entity = new DepartamentoEntity();
        } else {
            entity = departamentoService.getById(dto.getId());
        }

        return entity;
    }

}
