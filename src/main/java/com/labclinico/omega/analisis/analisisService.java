package com.labclinico.omega.analisis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

@Service
public class analisisService {

    private final analisisRepository analisisRepository;

    @Autowired
    public analisisService(analisisRepository analisisRepository) {
        this.analisisRepository = analisisRepository;
    }

    public List<analisisModel> getAllAnalisis() {
        return analisisRepository.findAll();
    }

    public Optional<analisisModel> getAnalisisById(String id) {
        return analisisRepository.findById(id);
    }

    public analisisModel saveAnalisis(analisisModel analisis) {
        return analisisRepository.save(analisis);
    }

    public void deleteAnalisis(String id) {
        analisisRepository.deleteById(id);
    }

    public List<analisisModel> getAnalisisByMuestra(String muestraId) {
        return analisisRepository.findByIdMuestra(muestraId);
    }

    //public List<analisisModel> getAnalisisByEstado(String estado) {
    //    return analisisRepository.findByEstado(estado);
    //}
    
    public Page<analisisModel> getAnalisisByEstado(String estado, Pageable pageable) {
        return analisisRepository.findByEstado(estado, pageable);
    }

    public List<analisisModel> getAnalisisByTipoAnalisis(String tipo) {
        return analisisRepository.findByTipo(tipo);
    }

}
