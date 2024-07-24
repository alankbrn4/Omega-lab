package com.labclinico.omega.recursoDigital;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Document(collection = "recursosDigitales")
public class recursoDigitalModel {

    @Id
    private String id;
    private String nombre;
    private String tipo;
    private String url;
    private String descripcion;
    private String metadata;
    private List<String> etiquetas;

}
