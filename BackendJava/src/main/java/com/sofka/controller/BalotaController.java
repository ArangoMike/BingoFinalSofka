package com.sofka.controller;


import com.sofka.domain.Balota;
import com.sofka.service.BalotaService;
import java.util.List;
import java.util.Optional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * Clase BalotaControoler que servira como controlador realizado con Springboot
 * la cual nos dará los puntos de acceso para el consumo de APIS
 *
 * @author Michael Arango
 */
@Slf4j
@RestController
public class BalotaController {

    @Autowired
    private BalotaService balotaService;

    /**
     * Método para devolver una lista de todos los registros que hay en la BD
     *
     * @return
     */
    @GetMapping(path = "/ballots")
    public List<Balota> listado() {

        var ballots = balotaService.list();
        return ballots;
    }

    /**
     * Método para devolver una lista de todos los registros que hay en la BD
     *
     * @return
     */
    @GetMapping(path = "/ballot/{id}")
    public Optional<Balota> buscarBalota(Balota balota, @PathVariable("id") Long id) {

        return balotaService.findBallot(balota);

    }

  
    

    
    


}
