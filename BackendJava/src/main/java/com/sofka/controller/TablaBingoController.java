
package com.sofka.controller;



import com.sofka.domain.TablaBingo;
import com.sofka.domain.Usuario;
import com.sofka.service.TablaBingoService;
import java.util.List;
import java.util.Optional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *  Clase TablaBingoController que servira como controlador realizado con Springboot la cual nos dara los puntos de acceso para el consumo de APIS
 * @author Michael Arango
 */
@Slf4j
@RestController
public class TablaBingoController {
    
    @Autowired
    private TablaBingoService tablaBingoService;
    
    /**
     *  Método para devolver una lista de todos los registros que hay en la BD
     * @return 
     */
    @GetMapping(path = "/tablasbingo")
    public List<TablaBingo> listado() {

        var tablasBingo = tablaBingoService.list();
        return tablasBingo;

    }
    
    /**
     *  Método para devolver una lista de todos los registros que hay en la BD
     * @return 
     */
    @GetMapping(path = "/tablabingo/{id}")
    public Optional<TablaBingo> buscarTablaBingo(TablaBingo tablaBingo,@PathVariable("id") Long id) {
        
        return tablaBingoService.findContact(tablaBingo);
    }
    
    /**
     *  Método para crear un registro en la BD contacto
     * @param tablaBingo recibe el usuario_id para el que será la tabla
     * @return respuesta con el registro creado
     */
    @PostMapping(path = "/tablabingo")
    public ResponseEntity crearTablabingo(@RequestBody TablaBingo tablaBingo) {
        

         tablaBingo.llenarTablaBingo(tablaBingo);
         
        log.info("Tabla a crear: {}", tablaBingo);
        tablaBingoService.save(tablaBingo);
        return new ResponseEntity<>(tablaBingo, HttpStatus.CREATED);
    }
    
}
