package com.labclinico.omega.patients;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class pacientesService {

    private final pacientesRepository pacientesRepository;

    @Autowired
    public pacientesService(pacientesRepository pacientesRepository) {
        this.pacientesRepository = pacientesRepository;
    }

    public List<pacientesModel> getAllPacientes() {
        return pacientesRepository.findAll();
    }

    public Optional<pacientesModel> getPacienteById(Long id) {
        return pacientesRepository.findById(id);
    }

    public pacientesModel savePaciente(pacientesModel paciente) {
        return pacientesRepository.save(paciente);
    }

    public void deletePaciente(Long id) {
        pacientesRepository.deleteById(id);
    }

    public void updatePaciente(Long id, pacientesModel paciente) {
        pacientesRepository.save(paciente);
    }
}