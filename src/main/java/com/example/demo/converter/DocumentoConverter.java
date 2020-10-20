package com.example.demo.converter;

import com.example.demo.common.AbstractConverter;
import com.example.demo.model.dto.DocumentoDto;
import com.example.demo.model.entity.DocumentoEntity;
import com.example.demo.service.DocumentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class DocumentoConverter extends AbstractConverter<DocumentoEntity, DocumentoDto> {

    @Autowired
    private DocumentoService documentoService;

    @Override
    protected DocumentoDto entityToDto(DocumentoEntity entity) throws Exception {
        return DocumentoDto.builder()
                .id(entity.getId())
                .nombre(entity.getNombre())
                .fecRegistro(new SimpleDateFormat("dd-MM-yyyy").format(entity.getFecRegistro()))
                .fecModificacion(new SimpleDateFormat("dd-MM-yyyy").format(entity.getFecModificacion()))
                .estado(entity.getEstado())
                .build();
    }

    @Override
    protected DocumentoEntity dtoToEntity(DocumentoDto dto) throws Exception {

        DocumentoEntity entity;

        if (dto.getId() == null) {
            entity = new DocumentoEntity();
            entity.setFecRegistro(new Date());
        } else {
            entity = documentoService.getById(dto.getId());
        }

        entity.setNombre(dto.getNombre().trim());
        entity.setFecModificacion(new Date());
        entity.setEstado(dto.getEstado());

        return entity;
    }

}
