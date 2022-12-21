package com.sofka.controller;

import com.sofka.dao.BalotaDao;
import com.sofka.domain.Balota;
import com.sofka.domain.Juego;
import com.sofka.service.BalotaService;
import com.sofka.service.JuegoService;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Clase JuegoController que servira como controlador realizado con Springboot
 * la cual nos dara los puntos de acceso para el consumo de APIS
 *
 * @author Michael Arango
 */
@Slf4j
@RestController
public class JuegoController {

    @Autowired
    private JuegoService juegoService;
    @Autowired
    private BalotaDao balotaDao;

    /**
     * Método para devolver una lista de todos los registros que hay en la BD
     *
     * @return
     */
    @GetMapping(path = "/games")
    public List<Juego> listado() {

        var games = juegoService.list();
        return games;
    }

    /**
     * Método para devolver una lista de todos los registros que hay en la BD
     * con el estadoJuego indicado
     *
     * @return
     */
    @GetMapping(path = "/juegoestado/{id}")
    public Optional<Juego> buscarJuego(Juego juego, @PathVariable("id") Long id) {

        return juegoService.findContact(juego);

    }

    /**
     * Método para devolver los registros con el estadoJuego que envien
     *
     * @return
     */
    @GetMapping(path = "/juego/fecha/{estadoJuego}")
    public Optional<Juego> buscarJuegoEnum(@PathVariable("id") Juego juego) {

        return juegoService.findbyEnum(juego);

    }

    /**
     * Método para crear un registro en la BD juego
     *
     * @param juego recibe todos los parametros para crearlo
     * @return respuesta con el registro creado
     */
    @PostMapping(path = "/juego")
    public ResponseEntity crear(@RequestBody Juego juego) {
        log.info("Juego a crear: {}", juego);

        juegoService.save(juego);
        return new ResponseEntity<>(juego, HttpStatus.CREATED);
    }

    /**
     * Método para borrar fisicamente un registro en la BD contacto
     *
     * @param juego recibe el parametro Id del contacto a eliminar
     * @return respuesta con el registro eliminado.
     */
    @DeleteMapping(path = "/juego/{id}")
    public ResponseEntity borrar(Juego juego) {
        log.info("Juego a borrar: {}", juego);
        juegoService.delete(juego);
        return new ResponseEntity<>(juego, HttpStatus.OK);
    }

    /**
     * Método para actualizar todo un registro del a BD contacto
     *
     * @param juego recibe por body todos los campos del contacto
     * @param id recibe por url el id a actualizar.
     * @return respuesta con el campo del registro ya actualizado.
     */
    @PutMapping(path = "/juego/{id}")
    public ResponseEntity actualizar(@RequestBody Juego juego, @PathVariable("id") Long id) {
        
        if (juego.getEstadoJuego().equals("finalizado")) {

            borrarBalotas();
        }
        
        log.info("Juego a modificar: {}", juego);
        juegoService.update(id, juego);
        return new ResponseEntity<>(juego, HttpStatus.OK);
    }

    /**
     * Método para actualizar solo el campo estadoJuego en la BD contacto
     *
     * @param juego recibe por body el nombre a actualizar.
     * @param id recibe por url el Id del registro a actualizar.
     * @return respuesta con el campo del registro ya actualizado.
     */
    @PatchMapping(path = "/juego/estadojuego/{id}")
    public ResponseEntity actualizarEstadoJuego(@RequestBody Juego juego, @PathVariable("id") Long id) {

        if (juego.getEstadoJuego().equals("en curso")) {

            llenarBalotas();
        }
        
        if (juego.getEstadoJuego().equals("finalizado")) {

            borrarBalotas();
        }
        
        juegoService.updateEstadoJuego(id, juego);
        return new ResponseEntity<>(juego, HttpStatus.OK);

    }
    
    
    /**
     * Método para actualizar solo el campo ganadorJuego en la BD databingo
     *
     * @param juego recibe por body el ganadorJuego a actualizar.
     * @param id recibe por url el Id del registro a actualizar.
     * @return respuesta con el campo del registro ya actualizado.
     */
    @PatchMapping(path = "/juego/ganador/{id}")
    public ResponseEntity actualizarGanadorJuego(@RequestBody Juego juego, @PathVariable("id") Long id) {
        juegoService.updateGanadorJuego(id, juego);
        return new ResponseEntity<>(juego, HttpStatus.OK);

    }
    
     /**
     * Método para actualizar solo el campo fechaInicio en la BD dataBingo
     *
     * @param juego recibe por body la fecha a actualizar.
     * @param id recibe por url el Id del registro a actualizar.
     * @return respuesta con el campo del registro ya actualizado.
     */
    @PatchMapping(path = "/juego/fechaInicio/{id}")
    public ResponseEntity actualizarFechaInicio(@RequestBody Juego juego, @PathVariable("id") Long id) {
        juegoService.update(id, juego);
        return new ResponseEntity<>(juego, HttpStatus.OK);

    }

    /**
     * Método usado para Llenar un array de balotas (usado para llenar tabla Balota en la BD)
     */
    public void llenarBalotas() {

        List<Balota> balotas = new ArrayList<>();

        String ballotF = null;
         
        int e = 0;
        int ballot;

        for (long i = 1; i <= 75; i++) {
            
            
            

            do {
                
                Balota b = new Balota();
                
                e = 0;
                ballot = (int) (Math.random() * 75 + 1);

                if (ballot <= 15) {

                    ballotF = 'B' + String.valueOf(ballot);
                    b.setBalota(ballotF);
                }
                if (ballot > 15 && ballot <= 30) {

                    ballotF = 'I' + String.valueOf(ballot);
                    b.setBalota(ballotF);
                }
                if (ballot > 30 && ballot <= 45) {

                    ballotF = 'N' + String.valueOf(ballot);
                    b.setBalota(ballotF);
                }
                if (ballot > 45 && ballot <= 60) {

                    ballotF = 'G' + String.valueOf(ballot);
                    b.setBalota(ballotF);
                }
                if (ballot > 60 && ballot <= 75) {

                    ballotF = 'O' + String.valueOf(ballot);
                    b.setBalota(ballotF);
                }

                for (Balota x : balotas) {

                    if (b.getBalota().equals(x.getBalota())) {
                        e = e + 1;
                        log.info("entre", e);
                    }
                }

            } while (e != 0);

            if (ballot <= 15) {

                balotas.add(new Balota(i, ballotF));
            }
            if (ballot > 15 && ballot <= 30) {

                balotas.add(new Balota(i, ballotF));
            }
            if (ballot > 30 && ballot <= 45) {

                balotas.add(new Balota(i, ballotF));
            }
            if (ballot > 45 && ballot <= 60) {

                balotas.add(new Balota(i, ballotF));
            }
            if (ballot > 60 && ballot <= 75) {

                balotas.add(new Balota(i, ballotF));
            }

        }

        balotaDao.saveAll(balotas);

    }

    public void borrarBalotas() {
        balotaDao.deleteAll();
    }

}

/*

 */
