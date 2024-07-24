package com.labclinico.omega.analisis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

@RestController
@RequestMapping("/api/analisis")
public class analisisController {

    private final analisisService analisisService;

    @Autowired
    public analisisController(analisisService analisisService) {
        this.analisisService = analisisService;
    }

    @GetMapping
    public ResponseEntity<List<analisisModel>> getAllAnalisis() {
        return ResponseEntity.ok(analisisService.getAllAnalisis());
    }

    @GetMapping("/{id}")
    public ResponseEntity<analisisModel> getAnalisisById(@PathVariable String id) {
        return analisisService.getAnalisisById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<analisisModel> saveAnalisis(@RequestBody analisisModel analisis) {
        return ResponseEntity.ok(analisisService.saveAnalisis(analisis));
    }

    @PutMapping("/{id}")
    public ResponseEntity<analisisModel> updateAnalisis(@PathVariable String id, @RequestBody analisisModel analisis) {
        return analisisService.getAnalisisById(id)
                .map(existingAnalisis -> {
                    analisis.setId(id);
                    return ResponseEntity.ok(analisisService.saveAnalisis(analisis));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAnalisis(@PathVariable String id) {
        analisisService.deleteAnalisis(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/muestra/{muestraId}")
    public List<analisisModel> getAnalisisByMuestra(@PathVariable String muestraId) {
        return analisisService.getAnalisisByMuestra(muestraId);
    }

    @GetMapping("/estado/{estado}")
    //public List<analisisModel> getAnalisisByEstado(@PathVariable String estado) {
    //    return analisisService.getAnalisisByEstado(estado);

    public ResponseEntity<Page<analisisModel>> getAnalisisByEstado(
            @PathVariable String estado,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<analisisModel> analisisPage = analisisService.getAnalisisByEstado(estado, pageable);
        return ResponseEntity.ok(analisisPage);
    }
        

    @GetMapping("/analisis")
    public List<analisisModel> getAnalisisByTipo(@RequestParam String tipoAnalisis) {
        return analisisService.getAnalisisByTipoAnalisis(tipoAnalisis);
    }

}
