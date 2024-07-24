package com.labclinico.omega.citas;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

@Service
public class citasService {

    private final citasRepository citasRepository;

    @Autowired
    public citasService(citasRepository citasRepository) {
        this.citasRepository = citasRepository;
    }

    public List<citasModel> getAllCitas() {
        return citasRepository.findAll();
    }

    public Optional<citasModel> getCitasById(Long id) {
        return citasRepository.findById(id);
    }

    public citasModel saveCitas(citasModel citas) {
        return citasRepository.save(citas);
    }

    public void deleteCitas(Long id) {
        citasRepository.deleteById(id);

    }

    public void updateCitas(Long id, citasModel citas) {
        citasRepository.save(citas);
    }

    
}
