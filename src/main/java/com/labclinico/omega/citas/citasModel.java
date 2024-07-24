package com.labclinico.omega.citas;

import lombok.Data;

import com.labclinico.omega.doctores.doctoresModel;
import com.labclinico.omega.patients.pacientesModel;

import jakarta.persistence.*;

@Data
@Entity
@Table(name = "cita")
public class citasModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_cita;
    
    private String fecha_hora;
    private String motivo;
    private String tipo_analisis;
    
    @ManyToOne
    @JoinColumn(name = "idPaciente")
    private pacientesModel paciente;

    @ManyToOne
    @JoinColumn(name = "id_medico")
    private doctoresModel medico;

}
