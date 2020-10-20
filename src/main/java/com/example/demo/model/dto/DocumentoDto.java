package com.example.demo.model.dto;

import com.example.demo.model.enums.EstadoEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DocumentoDto {

    private Long id;
    private String nombre;
    private String fecRegistro;
    private String fecModificacion;
    private EstadoEnum estado;

}
